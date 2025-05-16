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


import com.dao.LouyumingchengDao;
import com.entity.LouyumingchengEntity;
import com.service.LouyumingchengService;
import com.entity.vo.LouyumingchengVO;
import com.entity.view.LouyumingchengView;

@Service("louyumingchengService")
public class LouyumingchengServiceImpl extends ServiceImpl<LouyumingchengDao, LouyumingchengEntity> implements LouyumingchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LouyumingchengEntity> page = this.selectPage(
                new Query<LouyumingchengEntity>(params).getPage(),
                new EntityWrapper<LouyumingchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LouyumingchengEntity> wrapper) {
		  Page<LouyumingchengView> page =new Query<LouyumingchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LouyumingchengVO> selectListVO(Wrapper<LouyumingchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LouyumingchengVO selectVO(Wrapper<LouyumingchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LouyumingchengView> selectListView(Wrapper<LouyumingchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LouyumingchengView selectView(Wrapper<LouyumingchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
