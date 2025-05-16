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

import com.entity.TousufuwuEntity;
import com.entity.view.TousufuwuView;

import com.service.TousufuwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投诉服务
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
@RestController
@RequestMapping("/tousufuwu")
public class TousufuwuController {
    @Autowired
    private TousufuwuService tousufuwuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TousufuwuEntity tousufuwu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tousuriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tousuriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jumin")) {
			tousufuwu.setJuminzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<TousufuwuEntity> ew = new EntityWrapper<TousufuwuEntity>();
        if(tousuriqistart!=null) ew.ge("tousuriqi", tousuriqistart);
        if(tousuriqiend!=null) ew.le("tousuriqi", tousuriqiend);


        //查询结果
		PageUtils page = tousufuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousufuwu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,TousufuwuEntity tousufuwu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tousuriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tousuriqiend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TousufuwuEntity> ew = new EntityWrapper<TousufuwuEntity>();
        if(tousuriqistart!=null) ew.ge("tousuriqi", tousuriqistart);
        if(tousuriqiend!=null) ew.le("tousuriqi", tousuriqiend);

        //查询结果
		PageUtils page = tousufuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousufuwu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TousufuwuEntity tousufuwu){
       	EntityWrapper<TousufuwuEntity> ew = new EntityWrapper<TousufuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tousufuwu, "tousufuwu")); 
        return R.ok().put("data", tousufuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TousufuwuEntity tousufuwu){
        EntityWrapper< TousufuwuEntity> ew = new EntityWrapper< TousufuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tousufuwu, "tousufuwu")); 
		TousufuwuView tousufuwuView =  tousufuwuService.selectView(ew);
		return R.ok("查询投诉服务成功").put("data", tousufuwuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TousufuwuEntity tousufuwu = tousufuwuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tousufuwu,deSens);
        return R.ok().put("data", tousufuwu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TousufuwuEntity tousufuwu = tousufuwuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tousufuwu,deSens);
        return R.ok().put("data", tousufuwu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TousufuwuEntity tousufuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousufuwu);
        tousufuwuService.insert(tousufuwu);
        return R.ok().put("data",tousufuwu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TousufuwuEntity tousufuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousufuwu);
        tousufuwuService.insert(tousufuwu);
        return R.ok().put("data",tousufuwu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TousufuwuEntity tousufuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousufuwu);
        //全部更新
        tousufuwuService.updateById(tousufuwu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tousufuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
