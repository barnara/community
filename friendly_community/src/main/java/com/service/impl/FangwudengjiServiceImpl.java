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


import com.dao.FangwudengjiDao;
import com.entity.FangwudengjiEntity;
import com.service.FangwudengjiService;
import com.entity.vo.FangwudengjiVO;
import com.entity.view.FangwudengjiView;

@Service("fangwudengjiService")
public class FangwudengjiServiceImpl extends ServiceImpl<FangwudengjiDao, FangwudengjiEntity> implements FangwudengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwudengjiEntity> page = this.selectPage(
                new Query<FangwudengjiEntity>(params).getPage(),
                new EntityWrapper<FangwudengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwudengjiEntity> wrapper) {
		  Page<FangwudengjiView> page =new Query<FangwudengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangwudengjiVO> selectListVO(Wrapper<FangwudengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangwudengjiVO selectVO(Wrapper<FangwudengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangwudengjiView> selectListView(Wrapper<FangwudengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwudengjiView selectView(Wrapper<FangwudengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<FangwudengjiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<FangwudengjiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<FangwudengjiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
