package com.xys.cenxi.customer.pojo;

import java.util.Date;

import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * ����С�����
 * @author wjl
 *
 */
@Table("t_pingYiResult")
public class PingYiResult {

	@Name
	private String rowID;
	
	private String ownerID;
	
	/**
	 * �Ƿ�ͨ�����󣬴���
	 */
	private String passResultCode;
	
	/**
	 * ����С���Աǩ��
	 */
	private String theNames;
	
	/**
	 * ����ʱ��
	 */
	private Date pingYiDate;

	public String getRowID() {
		return rowID;
	}

	public void setRowID(String rowID) {
		this.rowID = rowID;
	}

	public String getPassResultCode() {
		return passResultCode;
	}

	public void setPassResultCode(String passResultCode) {
		this.passResultCode = passResultCode;
	}

	public String getTheNames() {
		return theNames;
	}

	public void setTheNames(String theNames) {
		this.theNames = theNames;
	}

	public Date getPingYiDate() {
		return pingYiDate;
	}

	public void setPingYiDate(Date pingYiDate) {
		this.pingYiDate = pingYiDate;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	
	
}
