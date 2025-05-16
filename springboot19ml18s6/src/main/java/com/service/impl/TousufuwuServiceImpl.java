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


import com.dao.TousufuwuDao;
import com.entity.TousufuwuEntity;
import com.service.TousufuwuService;
import com.entity.vo.TousufuwuVO;
import com.entity.view.TousufuwuView;

@Service("tousufuwuService")
public class TousufuwuServiceImpl extends ServiceImpl<TousufuwuDao, TousufuwuEntity> implements TousufuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TousufuwuEntity> page = this.selectPage(
                new Query<TousufuwuEntity>(params).getPage(),
                new EntityWrapper<TousufuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TousufuwuEntity> wrapper) {
		  Page<TousufuwuView> page =new Query<TousufuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TousufuwuVO> selectListVO(Wrapper<TousufuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TousufuwuVO selectVO(Wrapper<TousufuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TousufuwuView> selectListView(Wrapper<TousufuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TousufuwuView selectView(Wrapper<TousufuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
