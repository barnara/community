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

import com.entity.WeixiudengjiEntity;
import com.entity.view.WeixiudengjiView;

import com.service.WeixiudengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修登记
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
@RestController
@RequestMapping("/weixiudengji")
public class WeixiudengjiController {
    @Autowired
    private WeixiudengjiService weixiudengjiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiudengjiEntity weixiudengji,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jumin")) {
			weixiudengji.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<WeixiudengjiEntity> ew = new EntityWrapper<WeixiudengjiEntity>();
        if(baoxiushijianstart!=null) ew.ge("baoxiushijian", baoxiushijianstart);
        if(baoxiushijianend!=null) ew.le("baoxiushijian", baoxiushijianend);


        //查询结果
		PageUtils page = weixiudengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiudengji), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WeixiudengjiEntity weixiudengji, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiudengjiEntity> ew = new EntityWrapper<WeixiudengjiEntity>();
        if(baoxiushijianstart!=null) ew.ge("baoxiushijian", baoxiushijianstart);
        if(baoxiushijianend!=null) ew.le("baoxiushijian", baoxiushijianend);

        //查询结果
		PageUtils page = weixiudengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiudengji), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiudengjiEntity weixiudengji){
       	EntityWrapper<WeixiudengjiEntity> ew = new EntityWrapper<WeixiudengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiudengji, "weixiudengji")); 
        return R.ok().put("data", weixiudengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiudengjiEntity weixiudengji){
        EntityWrapper< WeixiudengjiEntity> ew = new EntityWrapper< WeixiudengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiudengji, "weixiudengji")); 
		WeixiudengjiView weixiudengjiView =  weixiudengjiService.selectView(ew);
		return R.ok("查询维修登记成功").put("data", weixiudengjiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiudengjiEntity weixiudengji = weixiudengjiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiudengji,deSens);
        return R.ok().put("data", weixiudengji);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiudengjiEntity weixiudengji = weixiudengjiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiudengji,deSens);
        return R.ok().put("data", weixiudengji);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiudengjiEntity weixiudengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiudengji);
        weixiudengjiService.insert(weixiudengji);
        return R.ok().put("data",weixiudengji.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiudengjiEntity weixiudengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiudengji);
        weixiudengjiService.insert(weixiudengji);
        return R.ok().put("data",weixiudengji.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiudengjiEntity weixiudengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiudengji);
        //全部更新
        weixiudengjiService.updateById(weixiudengji);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiudengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
