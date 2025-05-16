package com.dao;

import com.entity.JiaofeitongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaofeitongzhiVO;
import com.entity.view.JiaofeitongzhiView;


/**
 * 缴费通知
 * 
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public interface JiaofeitongzhiDao extends BaseMapper<JiaofeitongzhiEntity> {
	
	List<JiaofeitongzhiVO> selectListVO(@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);
	
	JiaofeitongzhiVO selectVO(@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);
	
	List<JiaofeitongzhiView> selectListView(@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);

	List<JiaofeitongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);

	
	JiaofeitongzhiView selectView(@Param("ew") Wrapper<JiaofeitongzhiEntity> wrapper);
	

}
