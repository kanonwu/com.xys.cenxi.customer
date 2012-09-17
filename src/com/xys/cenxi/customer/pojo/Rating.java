package com.xys.cenxi.customer.pojo;

import java.util.Date;

import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 评分项
 * @author wjl
 *
 */
@Table("t_rating")
public class Rating {

	@Name
	private String rowID;
	
	private String ownerID;
	
	/**
	 * 评分类型，0 初评，1 复评
	 */
	private Integer rateType;
	
	/**
	 * 评分项名称，可有可无
	 */
	private String rateName;
	
	/**
	 * 序号,从1开始
	 */
	private Integer rateOrder;
	
	/**
	 * 分值
	 */
	private Integer rateValue;
	
	/**
	 * 用户ID
	 */
	private String userID;
	
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public Integer getRateType() {
		return rateType;
	}

	public void setRateType(Integer rateType) {
		this.rateType = rateType;
	}

	public Integer getRateOrder() {
		return rateOrder;
	}

	public void setRateOrder(Integer rateOrder) {
		this.rateOrder = rateOrder;
	}

	public Integer getRateValue() {
		return rateValue;
	}

	public void setRateValue(Integer rateValue) {
		this.rateValue = rateValue;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}
}
