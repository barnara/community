package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
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

import com.entity.JiaofeitongzhiEntity;
import com.entity.view.JiaofeitongzhiView;

import com.service.JiaofeitongzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 缴费通知
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@RestController
@RequestMapping("/jiaofeitongzhi")
public class JiaofeitongzhiController {
    @Autowired
    private JiaofeitongzhiService jiaofeitongzhiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaofeitongzhiEntity jiaofeitongzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jumin")) {
			jiaofeitongzhi.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JiaofeitongzhiEntity> ew = new EntityWrapper<JiaofeitongzhiEntity>();


        //查询结果
		PageUtils page = jiaofeitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeitongzhi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiaofeitongzhiEntity jiaofeitongzhi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiaofeitongzhiEntity> ew = new EntityWrapper<JiaofeitongzhiEntity>();

        //查询结果
		PageUtils page = jiaofeitongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeitongzhi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaofeitongzhiEntity jiaofeitongzhi){
       	EntityWrapper<JiaofeitongzhiEntity> ew = new EntityWrapper<JiaofeitongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaofeitongzhi, "jiaofeitongzhi")); 
        return R.ok().put("data", jiaofeitongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaofeitongzhiEntity jiaofeitongzhi){
        EntityWrapper< JiaofeitongzhiEntity> ew = new EntityWrapper< JiaofeitongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaofeitongzhi, "jiaofeitongzhi")); 
		JiaofeitongzhiView jiaofeitongzhiView =  jiaofeitongzhiService.selectView(ew);
		return R.ok("查询缴费通知成功").put("data", jiaofeitongzhiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaofeitongzhiEntity jiaofeitongzhi = jiaofeitongzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiaofeitongzhi,deSens);
        return R.ok().put("data", jiaofeitongzhi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaofeitongzhiEntity jiaofeitongzhi = jiaofeitongzhiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiaofeitongzhi,deSens);
        return R.ok().put("data", jiaofeitongzhi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaofeitongzhiEntity jiaofeitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaofeitongzhi);
        jiaofeitongzhiService.insert(jiaofeitongzhi);
        return R.ok().put("data",jiaofeitongzhi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaofeitongzhiEntity jiaofeitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaofeitongzhi);
        jiaofeitongzhiService.insert(jiaofeitongzhi);
        return R.ok().put("data",jiaofeitongzhi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaofeitongzhiEntity jiaofeitongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaofeitongzhi);
        //全部更新
        jiaofeitongzhiService.updateById(jiaofeitongzhi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaofeitongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
