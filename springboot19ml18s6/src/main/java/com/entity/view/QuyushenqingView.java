package com.entity.view;

import com.entity.QuyushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 区域申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
@TableName("quyushenqing")
public class QuyushenqingView  extends QuyushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QuyushenqingView(){
	}
 
 	public QuyushenqingView(QuyushenqingEntity quyushenqingEntity){
 	try {
			BeanUtils.copyProperties(this, quyushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
