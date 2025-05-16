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


import com.dao.DiscusszhoubianfuwuDao;
import com.entity.DiscusszhoubianfuwuEntity;
import com.service.DiscusszhoubianfuwuService;
import com.entity.vo.DiscusszhoubianfuwuVO;
import com.entity.view.DiscusszhoubianfuwuView;

@Service("discusszhoubianfuwuService")
public class DiscusszhoubianfuwuServiceImpl extends ServiceImpl<DiscusszhoubianfuwuDao, DiscusszhoubianfuwuEntity> implements DiscusszhoubianfuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhoubianfuwuEntity> page = this.selectPage(
                new Query<DiscusszhoubianfuwuEntity>(params).getPage(),
                new EntityWrapper<DiscusszhoubianfuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhoubianfuwuEntity> wrapper) {
		  Page<DiscusszhoubianfuwuView> page =new Query<DiscusszhoubianfuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusszhoubianfuwuVO> selectListVO(Wrapper<DiscusszhoubianfuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhoubianfuwuVO selectVO(Wrapper<DiscusszhoubianfuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhoubianfuwuView> selectListView(Wrapper<DiscusszhoubianfuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhoubianfuwuView selectView(Wrapper<DiscusszhoubianfuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
