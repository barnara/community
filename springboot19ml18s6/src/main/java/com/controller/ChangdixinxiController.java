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
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.ChangdixinxiEntity;
import com.entity.view.ChangdixinxiView;

import com.service.ChangdixinxiService;
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
 * 场地信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
@RestController
@RequestMapping("/changdixinxi")
public class ChangdixinxiController {
    @Autowired
    private ChangdixinxiService changdixinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();


        //查询结果
		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();

        //查询结果
		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdixinxiEntity changdixinxi){
       	EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdixinxi, "changdixinxi")); 
        return R.ok().put("data", changdixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdixinxiEntity changdixinxi){
        EntityWrapper< ChangdixinxiEntity> ew = new EntityWrapper< ChangdixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdixinxi, "changdixinxi")); 
		ChangdixinxiView changdixinxiView =  changdixinxiService.selectView(ew);
		return R.ok("查询场地信息成功").put("data", changdixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdixinxiEntity changdixinxi = changdixinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdixinxi,deSens);
        return R.ok().put("data", changdixinxi);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdixinxiEntity changdixinxi = changdixinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdixinxi,deSens);
        return R.ok().put("data", changdixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(changdixinxiService.selectCount(new EntityWrapper<ChangdixinxiEntity>().eq("changdimingcheng", changdixinxi.getChangdimingcheng()))>0) {
            return R.error("场地名称已存在");
        }
        //ValidatorUtils.validateEntity(changdixinxi);
        changdixinxiService.insert(changdixinxi);
        return R.ok().put("data",changdixinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(changdixinxiService.selectCount(new EntityWrapper<ChangdixinxiEntity>().eq("changdimingcheng", changdixinxi.getChangdimingcheng()))>0) {
            return R.error("场地名称已存在");
        }
        //ValidatorUtils.validateEntity(changdixinxi);
        changdixinxiService.insert(changdixinxi);
        return R.ok().put("data",changdixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdixinxi);
        //验证字段唯一性，否则返回错误信息
        if(changdixinxiService.selectCount(new EntityWrapper<ChangdixinxiEntity>().ne("id", changdixinxi.getId()).eq("changdimingcheng", changdixinxi.getChangdimingcheng()))>0) {
            return R.error("场地名称已存在");
        }
        //全部更新
        changdixinxiService.updateById(changdixinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi, HttpServletRequest request,String pre){
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "changdixinxi"));
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering();

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(storeups, "userid", "refid", userId, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0 && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        // 根据协同结果查询结果并返回
        PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));;
        List<ChangdixinxiEntity> pageList = (List<ChangdixinxiEntity>)page.getList();
        if(recommendations!=null && recommendations.size()>0 && pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<ChangdixinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(changdixinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }






}
