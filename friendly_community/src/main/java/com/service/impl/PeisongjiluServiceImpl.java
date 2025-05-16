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


import com.dao.PeisongjiluDao;
import com.entity.PeisongjiluEntity;
import com.service.PeisongjiluService;
import com.entity.vo.PeisongjiluVO;
import com.entity.view.PeisongjiluView;

@Service("peisongjiluService")
public class PeisongjiluServiceImpl extends ServiceImpl<PeisongjiluDao, PeisongjiluEntity> implements PeisongjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeisongjiluEntity> page = this.selectPage(
                new Query<PeisongjiluEntity>(params).getPage(),
                new EntityWrapper<PeisongjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeisongjiluEntity> wrapper) {
		  Page<PeisongjiluView> page =new Query<PeisongjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PeisongjiluVO> selectListVO(Wrapper<PeisongjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeisongjiluVO selectVO(Wrapper<PeisongjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeisongjiluView> selectListView(Wrapper<PeisongjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeisongjiluView selectView(Wrapper<PeisongjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
