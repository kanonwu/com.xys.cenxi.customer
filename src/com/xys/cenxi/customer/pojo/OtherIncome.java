package com.xys.cenxi.customer.pojo;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * ������ͥ���룬����������������������
 * @author wjl
 *
 */
@Table("t_otherIncome")
public class OtherIncome implements Serializable {
	private static final long serialVersionUID = -5592027426140249321L;

	@Name
	private String rowID;
	
	private String ownerID;
	
	private Float workIncome;
	
	private Float otherIncome;
	
	/**
	 * ��Ҫ���µľ�Ӫ��ҵ
	 */
	private String mainBusiness;
	
	private String description;

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

	public Float getWorkIncome() {
		return workIncome;
	}

	public void setWorkIncome(Float workIncome) {
		this.workIncome = workIncome;
	}

	public Float getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(Float otherIncome) {
		this.otherIncome = otherIncome;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
