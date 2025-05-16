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


import com.dao.DanyuanhaoDao;
import com.entity.DanyuanhaoEntity;
import com.service.DanyuanhaoService;
import com.entity.vo.DanyuanhaoVO;
import com.entity.view.DanyuanhaoView;

@Service("danyuanhaoService")
public class DanyuanhaoServiceImpl extends ServiceImpl<DanyuanhaoDao, DanyuanhaoEntity> implements DanyuanhaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DanyuanhaoEntity> page = this.selectPage(
                new Query<DanyuanhaoEntity>(params).getPage(),
                new EntityWrapper<DanyuanhaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DanyuanhaoEntity> wrapper) {
		  Page<DanyuanhaoView> page =new Query<DanyuanhaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DanyuanhaoVO> selectListVO(Wrapper<DanyuanhaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DanyuanhaoVO selectVO(Wrapper<DanyuanhaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DanyuanhaoView> selectListView(Wrapper<DanyuanhaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DanyuanhaoView selectView(Wrapper<DanyuanhaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
