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

import com.entity.QuyushenqingEntity;
import com.entity.view.QuyushenqingView;

import com.service.QuyushenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 区域申请
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
@RestController
@RequestMapping("/quyushenqing")
public class QuyushenqingController {
    @Autowired
    private QuyushenqingService quyushenqingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuyushenqingEntity quyushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qishou")) {
			quyushenqing.setQishouzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<QuyushenqingEntity> ew = new EntityWrapper<QuyushenqingEntity>();


        //查询结果
		PageUtils page = quyushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyushenqing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QuyushenqingEntity quyushenqing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<QuyushenqingEntity> ew = new EntityWrapper<QuyushenqingEntity>();

        //查询结果
		PageUtils page = quyushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyushenqing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuyushenqingEntity quyushenqing){
       	EntityWrapper<QuyushenqingEntity> ew = new EntityWrapper<QuyushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quyushenqing, "quyushenqing")); 
        return R.ok().put("data", quyushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuyushenqingEntity quyushenqing){
        EntityWrapper< QuyushenqingEntity> ew = new EntityWrapper< QuyushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quyushenqing, "quyushenqing")); 
		QuyushenqingView quyushenqingView =  quyushenqingService.selectView(ew);
		return R.ok("查询区域申请成功").put("data", quyushenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuyushenqingEntity quyushenqing = quyushenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quyushenqing,deSens);
        return R.ok().put("data", quyushenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuyushenqingEntity quyushenqing = quyushenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(quyushenqing,deSens);
        return R.ok().put("data", quyushenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuyushenqingEntity quyushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quyushenqing);
        quyushenqingService.insert(quyushenqing);
        return R.ok().put("data",quyushenqing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuyushenqingEntity quyushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quyushenqing);
        quyushenqingService.insert(quyushenqing);
        return R.ok().put("data",quyushenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuyushenqingEntity quyushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quyushenqing);
        //全部更新
        quyushenqingService.updateById(quyushenqing);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QuyushenqingEntity> list = new ArrayList<QuyushenqingEntity>();
        for(Long id : ids) {
            QuyushenqingEntity quyushenqing = quyushenqingService.selectById(id);
            quyushenqing.setSfsh(sfsh);
            quyushenqing.setShhf(shhf);
            list.add(quyushenqing);
        }
        quyushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quyushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
