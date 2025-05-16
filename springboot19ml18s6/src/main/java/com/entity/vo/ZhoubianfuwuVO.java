package com.entity.vo;

import com.entity.ZhoubianfuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 周边服务
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
public class ZhoubianfuwuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 店铺图片
	 */
	
	private String dianputupian;
		
	/**
	 * 占地面积
	 */
	
	private String zhandimianji;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 主销产品
	 */
	
	private String zhuxiaochanpin;
		
	/**
	 * 店铺简介
	 */
	
	private String dianpujianjie;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
		
	/**
	 * 经度
	 */
	
	private Double longitude;
		
	/**
	 * 纬度
	 */
	
	private Double latitude;
		
	/**
	 * 地址
	 */
	
	private String fulladdress;
				
	
	/**
	 * 设置：店铺图片
	 */
	 
	public void setDianputupian(String dianputupian) {
		this.dianputupian = dianputupian;
	}
	
	/**
	 * 获取：店铺图片
	 */
	public String getDianputupian() {
		return dianputupian;
	}
				
	
	/**
	 * 设置：占地面积
	 */
	 
	public void setZhandimianji(String zhandimianji) {
		this.zhandimianji = zhandimianji;
	}
	
	/**
	 * 获取：占地面积
	 */
	public String getZhandimianji() {
		return zhandimianji;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：负责人
	 */
	 
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
				
	
	/**
	 * 设置：主销产品
	 */
	 
	public void setZhuxiaochanpin(String zhuxiaochanpin) {
		this.zhuxiaochanpin = zhuxiaochanpin;
	}
	
	/**
	 * 获取：主销产品
	 */
	public String getZhuxiaochanpin() {
		return zhuxiaochanpin;
	}
				
	
	/**
	 * 设置：店铺简介
	 */
	 
	public void setDianpujianjie(String dianpujianjie) {
		this.dianpujianjie = dianpujianjie;
	}
	
	/**
	 * 获取：店铺简介
	 */
	public String getDianpujianjie() {
		return dianpujianjie;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
				
	
	/**
	 * 设置：经度
	 */
	 
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * 获取：经度
	 */
	public Double getLongitude() {
		return longitude;
	}
				
	
	/**
	 * 设置：纬度
	 */
	 
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * 获取：纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	
	/**
	 * 获取：地址
	 */
	public String getFulladdress() {
		return fulladdress;
	}
			
}
