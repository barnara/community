package com.dao;

import com.entity.FangwudengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwudengjiVO;
import com.entity.view.FangwudengjiView;


/**
 * 房屋登记
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public interface FangwudengjiDao extends BaseMapper<FangwudengjiEntity> {
	
	List<FangwudengjiVO> selectListVO(@Param("ew") Wrapper<FangwudengjiEntity> wrapper);
	
	FangwudengjiVO selectVO(@Param("ew") Wrapper<FangwudengjiEntity> wrapper);
	
	List<FangwudengjiView> selectListView(@Param("ew") Wrapper<FangwudengjiEntity> wrapper);

	List<FangwudengjiView> selectListView(Pagination page,@Param("ew") Wrapper<FangwudengjiEntity> wrapper);

	
	FangwudengjiView selectView(@Param("ew") Wrapper<FangwudengjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwudengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwudengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangwudengjiEntity> wrapper);



}
