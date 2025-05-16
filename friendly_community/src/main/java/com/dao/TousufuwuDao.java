package com.dao;

import com.entity.TousufuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TousufuwuVO;
import com.entity.view.TousufuwuView;


/**
 * 投诉服务
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public interface TousufuwuDao extends BaseMapper<TousufuwuEntity> {
	
	List<TousufuwuVO> selectListVO(@Param("ew") Wrapper<TousufuwuEntity> wrapper);
	
	TousufuwuVO selectVO(@Param("ew") Wrapper<TousufuwuEntity> wrapper);
	
	List<TousufuwuView> selectListView(@Param("ew") Wrapper<TousufuwuEntity> wrapper);

	List<TousufuwuView> selectListView(Pagination page,@Param("ew") Wrapper<TousufuwuEntity> wrapper);

	
	TousufuwuView selectView(@Param("ew") Wrapper<TousufuwuEntity> wrapper);
	

}
