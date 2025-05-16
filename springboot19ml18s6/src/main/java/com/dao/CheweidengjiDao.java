package com.dao;

import com.entity.CheweidengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheweidengjiVO;
import com.entity.view.CheweidengjiView;


/**
 * 车位登记
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public interface CheweidengjiDao extends BaseMapper<CheweidengjiEntity> {
	
	List<CheweidengjiVO> selectListVO(@Param("ew") Wrapper<CheweidengjiEntity> wrapper);
	
	CheweidengjiVO selectVO(@Param("ew") Wrapper<CheweidengjiEntity> wrapper);
	
	List<CheweidengjiView> selectListView(@Param("ew") Wrapper<CheweidengjiEntity> wrapper);

	List<CheweidengjiView> selectListView(Pagination page,@Param("ew") Wrapper<CheweidengjiEntity> wrapper);

	
	CheweidengjiView selectView(@Param("ew") Wrapper<CheweidengjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheweidengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheweidengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CheweidengjiEntity> wrapper);



}
