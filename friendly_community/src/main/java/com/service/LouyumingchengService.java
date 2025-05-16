package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LouyumingchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LouyumingchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LouyumingchengView;


/**
 * 楼宇名称
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public interface LouyumingchengService extends IService<LouyumingchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LouyumingchengVO> selectListVO(Wrapper<LouyumingchengEntity> wrapper);
   	
   	LouyumingchengVO selectVO(@Param("ew") Wrapper<LouyumingchengEntity> wrapper);
   	
   	List<LouyumingchengView> selectListView(Wrapper<LouyumingchengEntity> wrapper);
   	
   	LouyumingchengView selectView(@Param("ew") Wrapper<LouyumingchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LouyumingchengEntity> wrapper);

   	

}

