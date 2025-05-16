package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TousufuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TousufuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TousufuwuView;


/**
 * 投诉服务
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public interface TousufuwuService extends IService<TousufuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TousufuwuVO> selectListVO(Wrapper<TousufuwuEntity> wrapper);
   	
   	TousufuwuVO selectVO(@Param("ew") Wrapper<TousufuwuEntity> wrapper);
   	
   	List<TousufuwuView> selectListView(Wrapper<TousufuwuEntity> wrapper);
   	
   	TousufuwuView selectView(@Param("ew") Wrapper<TousufuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TousufuwuEntity> wrapper);

   	

}

