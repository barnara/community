package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuyushenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuyushenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuyushenqingView;


/**
 * 区域申请
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
public interface QuyushenqingService extends IService<QuyushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuyushenqingVO> selectListVO(Wrapper<QuyushenqingEntity> wrapper);
   	
   	QuyushenqingVO selectVO(@Param("ew") Wrapper<QuyushenqingEntity> wrapper);
   	
   	List<QuyushenqingView> selectListView(Wrapper<QuyushenqingEntity> wrapper);
   	
   	QuyushenqingView selectView(@Param("ew") Wrapper<QuyushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuyushenqingEntity> wrapper);

   	

}

