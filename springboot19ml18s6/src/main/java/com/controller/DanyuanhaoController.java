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

import com.entity.DanyuanhaoEntity;
import com.entity.view.DanyuanhaoView;

import com.service.DanyuanhaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 单元号
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@RestController
@RequestMapping("/danyuanhao")
public class DanyuanhaoController {
    @Autowired
    private DanyuanhaoService danyuanhaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DanyuanhaoEntity danyuanhao,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DanyuanhaoEntity> ew = new EntityWrapper<DanyuanhaoEntity>();


        //查询结果
		PageUtils page = danyuanhaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, danyuanhao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DanyuanhaoEntity danyuanhao, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DanyuanhaoEntity> ew = new EntityWrapper<DanyuanhaoEntity>();

        //查询结果
		PageUtils page = danyuanhaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, danyuanhao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DanyuanhaoEntity danyuanhao){
       	EntityWrapper<DanyuanhaoEntity> ew = new EntityWrapper<DanyuanhaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( danyuanhao, "danyuanhao")); 
        return R.ok().put("data", danyuanhaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DanyuanhaoEntity danyuanhao){
        EntityWrapper< DanyuanhaoEntity> ew = new EntityWrapper< DanyuanhaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( danyuanhao, "danyuanhao")); 
		DanyuanhaoView danyuanhaoView =  danyuanhaoService.selectView(ew);
		return R.ok("查询单元号成功").put("data", danyuanhaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DanyuanhaoEntity danyuanhao = danyuanhaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(danyuanhao,deSens);
        return R.ok().put("data", danyuanhao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DanyuanhaoEntity danyuanhao = danyuanhaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(danyuanhao,deSens);
        return R.ok().put("data", danyuanhao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DanyuanhaoEntity danyuanhao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(danyuanhao);
        danyuanhaoService.insert(danyuanhao);
        return R.ok().put("data",danyuanhao.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DanyuanhaoEntity danyuanhao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(danyuanhao);
        danyuanhaoService.insert(danyuanhao);
        return R.ok().put("data",danyuanhao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DanyuanhaoEntity danyuanhao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(danyuanhao);
        //全部更新
        danyuanhaoService.updateById(danyuanhao);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        danyuanhaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
