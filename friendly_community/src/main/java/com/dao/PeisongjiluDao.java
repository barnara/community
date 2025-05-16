package com.dao;

import com.entity.PeisongjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeisongjiluVO;
import com.entity.view.PeisongjiluView;


/**
 * 配送记录
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
public interface PeisongjiluDao extends BaseMapper<PeisongjiluEntity> {
	
	List<PeisongjiluVO> selectListVO(@Param("ew") Wrapper<PeisongjiluEntity> wrapper);
	
	PeisongjiluVO selectVO(@Param("ew") Wrapper<PeisongjiluEntity> wrapper);
	
	List<PeisongjiluView> selectListView(@Param("ew") Wrapper<PeisongjiluEntity> wrapper);

	List<PeisongjiluView> selectListView(Pagination page,@Param("ew") Wrapper<PeisongjiluEntity> wrapper);

	
	PeisongjiluView selectView(@Param("ew") Wrapper<PeisongjiluEntity> wrapper);
	

}
