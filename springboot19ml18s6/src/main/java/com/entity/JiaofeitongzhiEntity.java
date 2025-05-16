package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 缴费通知
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-28 16:38:01
 */
@TableName("jiaofeitongzhi")
public class JiaofeitongzhiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaofeitongzhiEntity() {
		
	}
	
	public JiaofeitongzhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 缴费单号
	 */
					
	private String jiaofeidanhao;
	
	/**
	 * 居民账号
	 */
					
	private String juminzhanghao;
	
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 楼宇名称
	 */
					
	private String louyumingcheng;
	
	/**
	 * 单元号
	 */
					
	private String danyuanhao;
	
	/**
	 * 缴费类型
	 */
					
	private String jiaofeileixing;
	
	/**
	 * 缴费金额
	 */
					
	private Double jiaofeijine;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	/**
	 * 截止日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiezhiriqi;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：缴费单号
	 */
	public void setJiaofeidanhao(String jiaofeidanhao) {
		this.jiaofeidanhao = jiaofeidanhao;
	}
	/**
	 * 获取：缴费单号
	 */
	public String getJiaofeidanhao() {
		return jiaofeidanhao;
	}
	/**
	 * 设置：居民账号
	 */
	public void setJuminzhanghao(String juminzhanghao) {
		this.juminzhanghao = juminzhanghao;
	}
	/**
	 * 获取：居民账号
	 */
	public String getJuminzhanghao() {
		return juminzhanghao;
	}
	/**
	 * 设置：居民姓名
	 */
	public void setJuminxingming(String juminxingming) {
		this.juminxingming = juminxingming;
	}
	/**
	 * 获取：居民姓名
	 */
	public String getJuminxingming() {
		return juminxingming;
	}
	/**
	 * 设置：楼宇名称
	 */
	public void setLouyumingcheng(String louyumingcheng) {
		this.louyumingcheng = louyumingcheng;
	}
	/**
	 * 获取：楼宇名称
	 */
	public String getLouyumingcheng() {
		return louyumingcheng;
	}
	/**
	 * 设置：单元号
	 */
	public void setDanyuanhao(String danyuanhao) {
		this.danyuanhao = danyuanhao;
	}
	/**
	 * 获取：单元号
	 */
	public String getDanyuanhao() {
		return danyuanhao;
	}
	/**
	 * 设置：缴费类型
	 */
	public void setJiaofeileixing(String jiaofeileixing) {
		this.jiaofeileixing = jiaofeileixing;
	}
	/**
	 * 获取：缴费类型
	 */
	public String getJiaofeileixing() {
		return jiaofeileixing;
	}
	/**
	 * 设置：缴费金额
	 */
	public void setJiaofeijine(Double jiaofeijine) {
		this.jiaofeijine = jiaofeijine;
	}
	/**
	 * 获取：缴费金额
	 */
	public Double getJiaofeijine() {
		return jiaofeijine;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
	/**
	 * 设置：截止日期
	 */
	public void setJiezhiriqi(Date jiezhiriqi) {
		this.jiezhiriqi = jiezhiriqi;
	}
	/**
	 * 获取：截止日期
	 */
	public Date getJiezhiriqi() {
		return jiezhiriqi;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
