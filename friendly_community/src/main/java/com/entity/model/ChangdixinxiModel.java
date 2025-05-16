package com.entity.model;

import com.entity.ChangdixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 场地信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
public class ChangdixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 占地面积
	 */
	
	private String zhandimianji;
		
	/**
	 * 容纳人数
	 */
	
	private Integer rongnarenshu;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 联系热线
	 */
	
	private String lianxirexian;
		
	/**
	 * 场地介绍
	 */
	
	private String changdijieshao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：容纳人数
	 */
	 
	public void setRongnarenshu(Integer rongnarenshu) {
		this.rongnarenshu = rongnarenshu;
	}
	
	/**
	 * 获取：容纳人数
	 */
	public Integer getRongnarenshu() {
		return rongnarenshu;
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
				
	
	/**
	 * 设置：联系热线
	 */
	 
	public void setLianxirexian(String lianxirexian) {
		this.lianxirexian = lianxirexian;
	}
	
	/**
	 * 获取：联系热线
	 */
	public String getLianxirexian() {
		return lianxirexian;
	}
				
	
	/**
	 * 设置：场地介绍
	 */
	 
	public void setChangdijieshao(String changdijieshao) {
		this.changdijieshao = changdijieshao;
	}
	
	/**
	 * 获取：场地介绍
	 */
	public String getChangdijieshao() {
		return changdijieshao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
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
			
}
