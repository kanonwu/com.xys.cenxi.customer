package com.xys.cenxi.customer.pojo;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * ������
 * @author wjl
 *
 */
@Table("t_debigCnd")
public class DebitCnd implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3229031590277292121L;

	@Name
	private String rowID;
	
	private String ownerID;
	
	private String bank;
	
	/**
	 * ���
	 */
	private Float balance;

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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
}
