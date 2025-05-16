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

import com.entity.LouyumingchengEntity;
import com.entity.view.LouyumingchengView;

import com.service.LouyumingchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 楼宇名称
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@RestController
@RequestMapping("/louyumingcheng")
public class LouyumingchengController {
    @Autowired
    private LouyumingchengService louyumingchengService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LouyumingchengEntity louyumingcheng,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<LouyumingchengEntity> ew = new EntityWrapper<LouyumingchengEntity>();


        //查询结果
		PageUtils page = louyumingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, louyumingcheng), params), params));
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
    public R list(@RequestParam Map<String, Object> params,LouyumingchengEntity louyumingcheng, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<LouyumingchengEntity> ew = new EntityWrapper<LouyumingchengEntity>();

        //查询结果
		PageUtils page = louyumingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, louyumingcheng), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LouyumingchengEntity louyumingcheng){
       	EntityWrapper<LouyumingchengEntity> ew = new EntityWrapper<LouyumingchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( louyumingcheng, "louyumingcheng")); 
        return R.ok().put("data", louyumingchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LouyumingchengEntity louyumingcheng){
        EntityWrapper< LouyumingchengEntity> ew = new EntityWrapper< LouyumingchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( louyumingcheng, "louyumingcheng")); 
		LouyumingchengView louyumingchengView =  louyumingchengService.selectView(ew);
		return R.ok("查询楼宇名称成功").put("data", louyumingchengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LouyumingchengEntity louyumingcheng = louyumingchengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(louyumingcheng,deSens);
        return R.ok().put("data", louyumingcheng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LouyumingchengEntity louyumingcheng = louyumingchengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(louyumingcheng,deSens);
        return R.ok().put("data", louyumingcheng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LouyumingchengEntity louyumingcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(louyumingcheng);
        louyumingchengService.insert(louyumingcheng);
        return R.ok().put("data",louyumingcheng.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LouyumingchengEntity louyumingcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(louyumingcheng);
        louyumingchengService.insert(louyumingcheng);
        return R.ok().put("data",louyumingcheng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LouyumingchengEntity louyumingcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(louyumingcheng);
        //全部更新
        louyumingchengService.updateById(louyumingcheng);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        louyumingchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
