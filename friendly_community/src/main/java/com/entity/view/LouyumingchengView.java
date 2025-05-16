package com.entity.view;

import com.entity.LouyumingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 楼宇名称
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@TableName("louyumingcheng")
public class LouyumingchengView  extends LouyumingchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LouyumingchengView(){
	}
 
 	public LouyumingchengView(LouyumingchengEntity louyumingchengEntity){
 	try {
			BeanUtils.copyProperties(this, louyumingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
