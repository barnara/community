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

import com.entity.ZhoubianfuwuEntity;
import com.entity.view.ZhoubianfuwuView;

import com.service.ZhoubianfuwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 周边服务
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@RestController
@RequestMapping("/zhoubianfuwu")
public class ZhoubianfuwuController {
    @Autowired
    private ZhoubianfuwuService zhoubianfuwuService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhoubianfuwuEntity zhoubianfuwu,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhoubianfuwuEntity> ew = new EntityWrapper<ZhoubianfuwuEntity>();


        //查询结果
		PageUtils page = zhoubianfuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhoubianfuwu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhoubianfuwuEntity zhoubianfuwu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhoubianfuwuEntity> ew = new EntityWrapper<ZhoubianfuwuEntity>();

        //查询结果
		PageUtils page = zhoubianfuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhoubianfuwu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhoubianfuwuEntity zhoubianfuwu){
       	EntityWrapper<ZhoubianfuwuEntity> ew = new EntityWrapper<ZhoubianfuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhoubianfuwu, "zhoubianfuwu")); 
        return R.ok().put("data", zhoubianfuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhoubianfuwuEntity zhoubianfuwu){
        EntityWrapper< ZhoubianfuwuEntity> ew = new EntityWrapper< ZhoubianfuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhoubianfuwu, "zhoubianfuwu")); 
		ZhoubianfuwuView zhoubianfuwuView =  zhoubianfuwuService.selectView(ew);
		return R.ok("查询周边服务成功").put("data", zhoubianfuwuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhoubianfuwuEntity zhoubianfuwu = zhoubianfuwuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhoubianfuwu,deSens);
        return R.ok().put("data", zhoubianfuwu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhoubianfuwuEntity zhoubianfuwu = zhoubianfuwuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhoubianfuwu,deSens);
        return R.ok().put("data", zhoubianfuwu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhoubianfuwuEntity zhoubianfuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhoubianfuwu);
        zhoubianfuwuService.insert(zhoubianfuwu);
        return R.ok().put("data",zhoubianfuwu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhoubianfuwuEntity zhoubianfuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhoubianfuwu);
        zhoubianfuwuService.insert(zhoubianfuwu);
        return R.ok().put("data",zhoubianfuwu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhoubianfuwuEntity zhoubianfuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhoubianfuwu);
        //全部更新
        zhoubianfuwuService.updateById(zhoubianfuwu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhoubianfuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
