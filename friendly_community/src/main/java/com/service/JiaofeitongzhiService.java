package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaofeitongzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaofeitongzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaofeitongzhiView;


/**
 * 缴费通知
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public interface JiaofeitongzhiService extends IService<JiaofeitongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaofeitongzhiVO> selectListVO(Wrapper<JiaofeitongzhiEntity> wrapper);
   	
   	JiaofeitongzhiVO selectVO(@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);
   	
   	List<JiaofeitongzhiView> selectListView(Wrapper<JiaofeitongzhiEntity> wrapper);
   	
   	JiaofeitongzhiView selectView(@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaofeitongzhiEntity> wrapper);

   	

}

