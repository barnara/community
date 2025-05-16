package com.entity.view;

import com.entity.DiscusszhoubianfuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 周边服务评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-28 16:38:04
 */
@TableName("discusszhoubianfuwu")
public class DiscusszhoubianfuwuView  extends DiscusszhoubianfuwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhoubianfuwuView(){
	}
 
 	public DiscusszhoubianfuwuView(DiscusszhoubianfuwuEntity discusszhoubianfuwuEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhoubianfuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
