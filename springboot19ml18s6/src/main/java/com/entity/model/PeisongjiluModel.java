package com.entity.model;

import com.entity.PeisongjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 配送记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-28 16:38:03
 */
public class PeisongjiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 骑手姓名
	 */
	
	private String qishouxingming;
		
	/**
	 * 联系方式
	 */
	
	private String dianhua;
		
	/**
	 * 订单编号
	 */
	
	private String dingdanbianhao;
		
	/**
	 * 时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shijian;
		
	/**
	 * 社区
	 */
	
	private String shequ;
		
	/**
	 * 订单数量
	 */
	
	private String dingdanshuliang;
		
	/**
	 * 图片
	 */
	
	private String tupian;
				
	
	/**
	 * 设置：骑手姓名
	 */
	 
	public void setQishouxingming(String qishouxingming) {
		this.qishouxingming = qishouxingming;
	}
	
	/**
	 * 获取：骑手姓名
	 */
	public String getQishouxingming() {
		return qishouxingming;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getDianhua() {
		return dianhua;
	}
				
	
	/**
	 * 设置：订单编号
	 */
	 
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
				
	
	/**
	 * 设置：时间
	 */
	 
	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}
	
	/**
	 * 获取：时间
	 */
	public Date getShijian() {
		return shijian;
	}
				
	
	/**
	 * 设置：社区
	 */
	 
	public void setShequ(String shequ) {
		this.shequ = shequ;
	}
	
	/**
	 * 获取：社区
	 */
	public String getShequ() {
		return shequ;
	}
				
	
	/**
	 * 设置：订单数量
	 */
	 
	public void setDingdanshuliang(String dingdanshuliang) {
		this.dingdanshuliang = dingdanshuliang;
	}
	
	/**
	 * 获取：订单数量
	 */
	public String getDingdanshuliang() {
		return dingdanshuliang;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
			
}
