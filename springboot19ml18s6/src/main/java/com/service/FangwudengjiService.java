package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangwudengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangwudengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwudengjiView;


/**
 * 房屋登记
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public interface FangwudengjiService extends IService<FangwudengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwudengjiVO> selectListVO(Wrapper<FangwudengjiEntity> wrapper);
   	
   	FangwudengjiVO selectVO(@Param("ew") Wrapper<FangwudengjiEntity> wrapper);
   	
   	List<FangwudengjiView> selectListView(Wrapper<FangwudengjiEntity> wrapper);
   	
   	FangwudengjiView selectView(@Param("ew") Wrapper<FangwudengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwudengjiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<FangwudengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<FangwudengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<FangwudengjiEntity> wrapper);



}

