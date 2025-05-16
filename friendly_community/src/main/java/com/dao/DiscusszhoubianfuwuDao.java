package com.dao;

import com.entity.DiscusszhoubianfuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhoubianfuwuVO;
import com.entity.view.DiscusszhoubianfuwuView;


/**
 * 周边服务评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:04
 */
public interface DiscusszhoubianfuwuDao extends BaseMapper<DiscusszhoubianfuwuEntity> {
	
	List<DiscusszhoubianfuwuVO> selectListVO(@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);
	
	DiscusszhoubianfuwuVO selectVO(@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);
	
	List<DiscusszhoubianfuwuView> selectListView(@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);

	List<DiscusszhoubianfuwuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);

	
	DiscusszhoubianfuwuView selectView(@Param("ew") Wrapper<DiscusszhoubianfuwuEntity> wrapper);
	

}
