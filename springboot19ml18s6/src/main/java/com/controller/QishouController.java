package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QishouEntity;
import com.entity.view.QishouView;

import com.service.QishouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.EmailregistercodeService;
import com.entity.EmailregistercodeEntity;

/**
 * 骑手
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:00
 */
@RestController
@RequestMapping("/qishou")
public class QishouController {
    @Autowired
    private QishouService qishouService;
    @Autowired
    private EmailregistercodeService emailregistercodeService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"qishou",  "骑手" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QishouEntity qishou, @RequestParam(required = false) String emailcode){
    	//ValidatorUtils.validateEntity(qishou);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同骑手账号，否则返回错误信息
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
        //判断是否存在相同邮箱，否则返回错误信息
        u =qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("email", qishou.getEmail()));
        if(u!=null) {
            return R.error("邮箱已被注册");
        }
        //判断验证码是否正确，否则返回错误信息
        List<EmailregistercodeEntity> emailregistercodeList = emailregistercodeService.selectList(new EntityWrapper<EmailregistercodeEntity>().eq("role", "用户").eq("email", qishou.getEmail()).orderBy("addtime", false));
        boolean emailValidate = false;
        if(emailregistercodeList!=null && emailregistercodeList.size()>0) {
            if(emailregistercodeList.get(0).getCode().equals(emailcode)) {
                emailValidate = true;
            }
        }
        if(!emailValidate) return R.error("邮箱验证码不正确");
		Long uId = new Date().getTime();
		qishou.setId(uId);
        //保存用户
        qishouService.insert(qishou);
        return R.ok();
    }

    /**
     * 发送邮件
     */
    @IgnoreAuth
    @RequestMapping("/sendemail")
    public R sendemail(@RequestParam String email){
        String code = CommonUtil.getRandomNumber(4);
        EmailregistercodeEntity emailregistercode = new EmailregistercodeEntity();
        emailregistercode.setCode(code);
        emailregistercode.setRole("用户");
        emailregistercode.setEmail(email);
        emailregistercodeService.insert(emailregistercode);
        CommonUtil.sendEmail(email, "用户注册","您的注册验证码是【"+code+"】，请不要把验证码泄漏给其他人，如非本人请勿操作。");
        return R.ok();
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        QishouEntity u = qishouService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        qishouService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QishouEntity qishou,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();


        //查询结果
		PageUtils page = qishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qishou), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QishouEntity qishou, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();

        //查询结果
		PageUtils page = qishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qishou), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QishouEntity qishou){
       	EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qishou, "qishou")); 
        return R.ok().put("data", qishouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QishouEntity qishou){
        EntityWrapper< QishouEntity> ew = new EntityWrapper< QishouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qishou, "qishou")); 
		QishouView qishouView =  qishouService.selectView(ew);
		return R.ok("查询骑手成功").put("data", qishouView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QishouEntity qishou = qishouService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qishou,deSens);
        return R.ok().put("data", qishou);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QishouEntity qishou = qishouService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qishou,deSens);
        return R.ok().put("data", qishou);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QishouEntity qishou, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
        //ValidatorUtils.validateEntity(qishou);
        //验证账号唯一性，否则返回错误信息
        QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	qishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		qishou.setId(new Date().getTime());
        qishouService.insert(qishou);
        return R.ok().put("data",qishou.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QishouEntity qishou, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
        //ValidatorUtils.validateEntity(qishou);
        //验证账号唯一性，否则返回错误信息
        QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	qishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		qishou.setId(new Date().getTime());
        qishouService.insert(qishou);
        return R.ok().put("data",qishou.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        QishouEntity qishou = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", username));
        return R.ok().put("data", qishou);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody QishouEntity qishou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qishou);
        //验证字段唯一性，否则返回错误信息
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().ne("id", qishou.getId()).eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
        //全部更新
        qishouService.updateById(qishou);
        if(null!=qishou.getQishouzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(qishou.getQishouzhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", qishou.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qishouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
