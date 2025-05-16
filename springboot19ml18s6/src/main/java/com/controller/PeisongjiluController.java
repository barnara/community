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

import com.entity.PeisongjiluEntity;
import com.entity.view.PeisongjiluView;

import com.service.PeisongjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 配送记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
@RestController
@RequestMapping("/peisongjilu")
public class PeisongjiluController {
    @Autowired
    private PeisongjiluService peisongjiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeisongjiluEntity peisongjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qishou")) {
			peisongjilu.setQishouzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<PeisongjiluEntity> ew = new EntityWrapper<PeisongjiluEntity>();


        //查询结果
		PageUtils page = peisongjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongjilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,PeisongjiluEntity peisongjilu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<PeisongjiluEntity> ew = new EntityWrapper<PeisongjiluEntity>();

        //查询结果
		PageUtils page = peisongjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peisongjilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeisongjiluEntity peisongjilu){
       	EntityWrapper<PeisongjiluEntity> ew = new EntityWrapper<PeisongjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peisongjilu, "peisongjilu")); 
        return R.ok().put("data", peisongjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeisongjiluEntity peisongjilu){
        EntityWrapper< PeisongjiluEntity> ew = new EntityWrapper< PeisongjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peisongjilu, "peisongjilu")); 
		PeisongjiluView peisongjiluView =  peisongjiluService.selectView(ew);
		return R.ok("查询配送记录成功").put("data", peisongjiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeisongjiluEntity peisongjilu = peisongjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(peisongjilu,deSens);
        return R.ok().put("data", peisongjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeisongjiluEntity peisongjilu = peisongjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(peisongjilu,deSens);
        return R.ok().put("data", peisongjilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeisongjiluEntity peisongjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongjilu);
        peisongjiluService.insert(peisongjilu);
        return R.ok().put("data",peisongjilu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeisongjiluEntity peisongjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongjilu);
        peisongjiluService.insert(peisongjilu);
        return R.ok().put("data",peisongjilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeisongjiluEntity peisongjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peisongjilu);
        //全部更新
        peisongjiluService.updateById(peisongjilu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peisongjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
