package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DanyuanhaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DanyuanhaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DanyuanhaoView;


/**
 * 单元号
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public interface DanyuanhaoService extends IService<DanyuanhaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DanyuanhaoVO> selectListVO(Wrapper<DanyuanhaoEntity> wrapper);
   	
   	DanyuanhaoVO selectVO(@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);
   	
   	List<DanyuanhaoView> selectListView(Wrapper<DanyuanhaoEntity> wrapper);
   	
   	DanyuanhaoView selectView(@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DanyuanhaoEntity> wrapper);

   	

}

