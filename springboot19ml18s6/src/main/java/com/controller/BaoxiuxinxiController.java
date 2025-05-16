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

import com.entity.BaoxiuxinxiEntity;
import com.entity.view.BaoxiuxinxiView;

import com.service.BaoxiuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 报修信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
@RestController
@RequestMapping("/baoxiuxinxi")
public class BaoxiuxinxiController {
    @Autowired
    private BaoxiuxinxiService baoxiuxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaoxiuxinxiEntity baoxiuxinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jumin")) {
			baoxiuxinxi.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        if(baoxiushijianstart!=null) ew.ge("baoxiushijian", baoxiushijianstart);
        if(baoxiushijianend!=null) ew.le("baoxiushijian", baoxiushijianend);


        //查询结果
		PageUtils page = baoxiuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiuxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,BaoxiuxinxiEntity baoxiuxinxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date baoxiushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
        if(baoxiushijianstart!=null) ew.ge("baoxiushijian", baoxiushijianstart);
        if(baoxiushijianend!=null) ew.le("baoxiushijian", baoxiushijianend);

        //查询结果
		PageUtils page = baoxiuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baoxiuxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaoxiuxinxiEntity baoxiuxinxi){
       	EntityWrapper<BaoxiuxinxiEntity> ew = new EntityWrapper<BaoxiuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baoxiuxinxi, "baoxiuxinxi")); 
        return R.ok().put("data", baoxiuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaoxiuxinxiEntity baoxiuxinxi){
        EntityWrapper< BaoxiuxinxiEntity> ew = new EntityWrapper< BaoxiuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baoxiuxinxi, "baoxiuxinxi")); 
		BaoxiuxinxiView baoxiuxinxiView =  baoxiuxinxiService.selectView(ew);
		return R.ok("查询报修信息成功").put("data", baoxiuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaoxiuxinxiEntity baoxiuxinxi = baoxiuxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(baoxiuxinxi,deSens);
        return R.ok().put("data", baoxiuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaoxiuxinxiEntity baoxiuxinxi = baoxiuxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(baoxiuxinxi,deSens);
        return R.ok().put("data", baoxiuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoxiuxinxi);
        baoxiuxinxiService.insert(baoxiuxinxi);
        return R.ok().put("data",baoxiuxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoxiuxinxi);
        baoxiuxinxiService.insert(baoxiuxinxi);
        return R.ok().put("data",baoxiuxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaoxiuxinxiEntity baoxiuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baoxiuxinxi);
        //全部更新
        baoxiuxinxiService.updateById(baoxiuxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baoxiuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
