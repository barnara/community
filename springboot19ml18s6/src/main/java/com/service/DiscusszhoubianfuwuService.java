package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhoubianfuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhoubianfuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhoubianfuwuView;


/**
 * 周边服务评论表
 *
 * @author 
 * @email 
 * @date 2025-04-28 16:38:04
 */
public interface DiscusszhoubianfuwuService extends IService<DiscusszhoubianfuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhoubianfuwuVO> selectListVO(Wrapper<DiscusszhoubianfuwuEntity> wrapper);
   	
   	DiscusszhoubianfuwuVO selectVO(@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);
   	
   	List<DiscusszhoubianfuwuView> selectListView(Wrapper<DiscusszhoubianfuwuEntity> wrapper);
   	
   	DiscusszhoubianfuwuView selectView(@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhoubianfuwuEntity> wrapper);

   	

}

