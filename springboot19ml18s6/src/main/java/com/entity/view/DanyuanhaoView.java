package com.entity.view;

import com.entity.DanyuanhaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 单元号
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@TableName("danyuanhao")
public class DanyuanhaoView  extends DanyuanhaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DanyuanhaoView(){
	}
 
 	public DanyuanhaoView(DanyuanhaoEntity danyuanhaoEntity){
 	try {
			BeanUtils.copyProperties(this, danyuanhaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
