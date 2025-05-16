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


import com.dao.CheweidengjiDao;
import com.entity.CheweidengjiEntity;
import com.service.CheweidengjiService;
import com.entity.vo.CheweidengjiVO;
import com.entity.view.CheweidengjiView;

@Service("cheweidengjiService")
public class CheweidengjiServiceImpl extends ServiceImpl<CheweidengjiDao, CheweidengjiEntity> implements CheweidengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheweidengjiEntity> page = this.selectPage(
                new Query<CheweidengjiEntity>(params).getPage(),
                new EntityWrapper<CheweidengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheweidengjiEntity> wrapper) {
		  Page<CheweidengjiView> page =new Query<CheweidengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CheweidengjiVO> selectListVO(Wrapper<CheweidengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheweidengjiVO selectVO(Wrapper<CheweidengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheweidengjiView> selectListView(Wrapper<CheweidengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheweidengjiView selectView(Wrapper<CheweidengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CheweidengjiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CheweidengjiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CheweidengjiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
