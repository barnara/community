package com.dao;

import com.entity.LouyumingchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LouyumingchengVO;
import com.entity.view.LouyumingchengView;


/**
 * 楼宇名称
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public interface LouyumingchengDao extends BaseMapper<LouyumingchengEntity> {
	
	List<LouyumingchengVO> selectListVO(@Param("ew") Wrapper<LouyumingchengEntity> wrapper);
	
	LouyumingchengVO selectVO(@Param("ew") Wrapper<LouyumingchengEntity> wrapper);
	
	List<LouyumingchengView> selectListView(@Param("ew") Wrapper<LouyumingchengEntity> wrapper);

	List<LouyumingchengView> selectListView(Pagination page,@Param("ew") Wrapper<LouyumingchengEntity> wrapper);

	
	LouyumingchengView selectView(@Param("ew") Wrapper<LouyumingchengEntity> wrapper);
	

}
