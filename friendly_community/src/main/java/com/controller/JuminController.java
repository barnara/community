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

import com.entity.JuminEntity;
import com.entity.view.JuminView;

import com.service.JuminService;
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
 * 居民
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:00
 */
@RestController
@RequestMapping("/jumin")
public class JuminController {
    @Autowired
    private JuminService juminService;
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
        JuminEntity u = juminService.selectOne(new EntityWrapper<JuminEntity>().eq("juminzhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"jumin",  "居民" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JuminEntity jumin, @RequestParam(required = false) String emailcode){
    	//ValidatorUtils.validateEntity(jumin);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	JuminEntity u = juminService.selectOne(new EntityWrapper<JuminEntity>().eq("juminzhanghao", jumin.getJuminzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同居民账号，否则返回错误信息
        if(juminService.selectCount(new EntityWrapper<JuminEntity>().eq("juminzhanghao", jumin.getJuminzhanghao()))>0) {
            return R.error("居民账号已存在");
        }
        //判断是否存在相同邮箱，否则返回错误信息
        u =juminService.selectOne(new EntityWrapper<JuminEntity>().eq("email", jumin.getEmail()));
        if(u!=null) {
            return R.error("邮箱已被注册");
        }
        //判断验证码是否正确，否则返回错误信息
        List<EmailregistercodeEntity> emailregistercodeList = emailregistercodeService.selectList(new EntityWrapper<EmailregistercodeEntity>().eq("role", "用户").eq("email", jumin.getEmail()).orderBy("addtime", false));
        boolean emailValidate = false;
        if(emailregistercodeList!=null && emailregistercodeList.size()>0) {
            if(emailregistercodeList.get(0).getCode().equals(emailcode)) {
                emailValidate = true;
            }
        }
        if(!emailValidate) return R.error("邮箱验证码不正确");
		Long uId = new Date().getTime();
		jumin.setId(uId);
        //保存用户
        juminService.insert(jumin);
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
        JuminEntity u = juminService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        JuminEntity u = juminService.selectOne(new EntityWrapper<JuminEntity>().eq("juminzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        juminService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JuminEntity jumin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();


        //查询结果
		PageUtils page = juminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jumin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JuminEntity jumin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();

        //查询结果
		PageUtils page = juminService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jumin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JuminEntity jumin){
       	EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jumin, "jumin")); 
        return R.ok().put("data", juminService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JuminEntity jumin){
        EntityWrapper< JuminEntity> ew = new EntityWrapper< JuminEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jumin, "jumin")); 
		JuminView juminView =  juminService.selectView(ew);
		return R.ok("查询居民成功").put("data", juminView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JuminEntity jumin = juminService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jumin,deSens);
        return R.ok().put("data", jumin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JuminEntity jumin = juminService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jumin,deSens);
        return R.ok().put("data", jumin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JuminEntity jumin, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(juminService.selectCount(new EntityWrapper<JuminEntity>().eq("juminzhanghao", jumin.getJuminzhanghao()))>0) {
            return R.error("居民账号已存在");
        }
        //ValidatorUtils.validateEntity(jumin);
        //验证账号唯一性，否则返回错误信息
        JuminEntity u = juminService.selectOne(new EntityWrapper<JuminEntity>().eq("juminzhanghao", jumin.getJuminzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	jumin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		jumin.setId(new Date().getTime());
        juminService.insert(jumin);
        return R.ok().put("data",jumin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JuminEntity jumin, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(juminService.selectCount(new EntityWrapper<JuminEntity>().eq("juminzhanghao", jumin.getJuminzhanghao()))>0) {
            return R.error("居民账号已存在");
        }
        //ValidatorUtils.validateEntity(jumin);
        //验证账号唯一性，否则返回错误信息
        JuminEntity u = juminService.selectOne(new EntityWrapper<JuminEntity>().eq("juminzhanghao", jumin.getJuminzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	jumin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		jumin.setId(new Date().getTime());
        juminService.insert(jumin);
        return R.ok().put("data",jumin.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        JuminEntity jumin = juminService.selectOne(new EntityWrapper<JuminEntity>().eq("juminzhanghao", username));
        return R.ok().put("data", jumin);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody JuminEntity jumin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jumin);
        //验证字段唯一性，否则返回错误信息
        if(juminService.selectCount(new EntityWrapper<JuminEntity>().ne("id", jumin.getId()).eq("juminzhanghao", jumin.getJuminzhanghao()))>0) {
            return R.error("居民账号已存在");
        }
        //全部更新
        juminService.updateById(jumin);
        if(null!=jumin.getJuminzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(jumin.getJuminzhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", jumin.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        juminService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_jumin_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
            //获取结果
        List<Map<String, Object>> result = juminService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_jumin_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = juminService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_jumin_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
        List<Map<String, Object>> result = juminService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_jumin_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = juminService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("group_jumin_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
        List<Map<String, Object>> result = juminService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JuminEntity jumin, HttpServletRequest request){
        EntityWrapper<JuminEntity> ew = new EntityWrapper<JuminEntity>();
        int count = juminService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jumin), params), params));
        return R.ok().put("data", count);
    }

}
