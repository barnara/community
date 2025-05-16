package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheweidengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheweidengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheweidengjiView;


/**
 * 车位登记
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public interface CheweidengjiService extends IService<CheweidengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheweidengjiVO> selectListVO(Wrapper<CheweidengjiEntity> wrapper);
   	
   	CheweidengjiVO selectVO(@Param("ew") Wrapper<CheweidengjiEntity> wrapper);
   	
   	List<CheweidengjiView> selectListView(Wrapper<CheweidengjiEntity> wrapper);
   	
   	CheweidengjiView selectView(@Param("ew") Wrapper<CheweidengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheweidengjiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CheweidengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CheweidengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CheweidengjiEntity> wrapper);



}

