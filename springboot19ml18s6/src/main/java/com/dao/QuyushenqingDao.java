package com.dao;

import com.entity.QuyushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuyushenqingVO;
import com.entity.view.QuyushenqingView;


/**
 * 区域申请
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
public interface QuyushenqingDao extends BaseMapper<QuyushenqingEntity> {
	
	List<QuyushenqingVO> selectListVO(@Param("ew") Wrapper<QuyushenqingEntity> wrapper);
	
	QuyushenqingVO selectVO(@Param("ew") Wrapper<QuyushenqingEntity> wrapper);
	
	List<QuyushenqingView> selectListView(@Param("ew") Wrapper<QuyushenqingEntity> wrapper);

	List<QuyushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<QuyushenqingEntity> wrapper);

	
	QuyushenqingView selectView(@Param("ew") Wrapper<QuyushenqingEntity> wrapper);
	

}
