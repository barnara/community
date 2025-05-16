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
 * 房屋登记
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-28 16:38:02
 */
@TableName("fangwudengji")
public class FangwudengjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FangwudengjiEntity() {
		
	}
	
	public FangwudengjiEntity(T t) {
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
	 * 楼宇名称
	 */
					
	private String louyumingcheng;
	
	/**
	 * 单元号
	 */
					
	private String danyuanhao;
	
	/**
	 * 楼层
	 */
					
	private String louceng;
	
	/**
	 * 房间号
	 */
					
	private String fangjianhao;
	
	/**
	 * 住宅面积
	 */
					
	private String zhuzhaimianji;
	
	/**
	 * 产权
	 */
					
	private String chanquan;
	
	/**
	 * 房屋类型
	 */
					
	private String fangwuleixing;
	
	/**
	 * 房屋状态
	 */
					
	private String fangwuzhuangtai;
	
	/**
	 * 居民账号
	 */
					
	private String juminzhanghao;
	
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 更新时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date gengxinshijian;
	
	
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
	 * 设置：楼层
	 */
	public void setLouceng(String louceng) {
		this.louceng = louceng;
	}
	/**
	 * 获取：楼层
	 */
	public String getLouceng() {
		return louceng;
	}
	/**
	 * 设置：房间号
	 */
	public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
	}
	/**
	 * 获取：房间号
	 */
	public String getFangjianhao() {
		return fangjianhao;
	}
	/**
	 * 设置：住宅面积
	 */
	public void setZhuzhaimianji(String zhuzhaimianji) {
		this.zhuzhaimianji = zhuzhaimianji;
	}
	/**
	 * 获取：住宅面积
	 */
	public String getZhuzhaimianji() {
		return zhuzhaimianji;
	}
	/**
	 * 设置：产权
	 */
	public void setChanquan(String chanquan) {
		this.chanquan = chanquan;
	}
	/**
	 * 获取：产权
	 */
	public String getChanquan() {
		return chanquan;
	}
	/**
	 * 设置：房屋类型
	 */
	public void setFangwuleixing(String fangwuleixing) {
		this.fangwuleixing = fangwuleixing;
	}
	/**
	 * 获取：房屋类型
	 */
	public String getFangwuleixing() {
		return fangwuleixing;
	}
	/**
	 * 设置：房屋状态
	 */
	public void setFangwuzhuangtai(String fangwuzhuangtai) {
		this.fangwuzhuangtai = fangwuzhuangtai;
	}
	/**
	 * 获取：房屋状态
	 */
	public String getFangwuzhuangtai() {
		return fangwuzhuangtai;
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
	 * 设置：更新时间
	 */
	public void setGengxinshijian(Date gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getGengxinshijian() {
		return gengxinshijian;
	}

}
