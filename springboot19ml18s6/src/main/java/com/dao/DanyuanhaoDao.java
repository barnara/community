package com.dao;

import com.entity.DanyuanhaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DanyuanhaoVO;
import com.entity.view.DanyuanhaoView;


/**
 * 单元号
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public interface DanyuanhaoDao extends BaseMapper<DanyuanhaoEntity> {
	
	List<DanyuanhaoVO> selectListVO(@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);
	
	DanyuanhaoVO selectVO(@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);
	
	List<DanyuanhaoView> selectListView(@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);

	List<DanyuanhaoView> selectListView(Pagination page,@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);

	
	DanyuanhaoView selectView(@Param("ew") Wrapper<DanyuanhaoEntity> wrapper);
	

}
