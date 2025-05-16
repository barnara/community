package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeisongjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeisongjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeisongjiluView;


/**
 * 配送记录
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
public interface PeisongjiluService extends IService<PeisongjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeisongjiluVO> selectListVO(Wrapper<PeisongjiluEntity> wrapper);
   	
   	PeisongjiluVO selectVO(@Param("ew") Wrapper<PeisongjiluEntity> wrapper);
   	
   	List<PeisongjiluView> selectListView(Wrapper<PeisongjiluEntity> wrapper);
   	
   	PeisongjiluView selectView(@Param("ew") Wrapper<PeisongjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeisongjiluEntity> wrapper);

   	

}

