package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QuyushenqingDao;
import com.entity.QuyushenqingEntity;
import com.service.QuyushenqingService;
import com.entity.vo.QuyushenqingVO;
import com.entity.view.QuyushenqingView;

@Service("quyushenqingService")
public class QuyushenqingServiceImpl extends ServiceImpl<QuyushenqingDao, QuyushenqingEntity> implements QuyushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuyushenqingEntity> page = this.selectPage(
                new Query<QuyushenqingEntity>(params).getPage(),
                new EntityWrapper<QuyushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuyushenqingEntity> wrapper) {
		  Page<QuyushenqingView> page =new Query<QuyushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QuyushenqingVO> selectListVO(Wrapper<QuyushenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuyushenqingVO selectVO(Wrapper<QuyushenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuyushenqingView> selectListView(Wrapper<QuyushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuyushenqingView selectView(Wrapper<QuyushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
