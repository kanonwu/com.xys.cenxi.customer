package com.xys.cenxi.customer.pojo;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 评定结论、意见
 * @author wjl
 *
 */
@Table("t_rateConclusion")
public class RateConclusion implements Serializable{

	private static final long serialVersionUID = -7296119554054551886L;

	@Name
	private String rowID;
	
	private String ownerID;
	
	private String firstNames;
	
	private String firstConclusions;
	
	private Date firstDate;
	
	private String secondNames;
	
	private String secondConclusions;
	
	private Date secondDate;
	
	private Integer firstValue;
	
	private Integer secondValue;
	
	private Integer firstLevel;
	
	private Integer secondLevel;

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

	public String getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getFirstConclusions() {
		return firstConclusions;
	}

	public void setFirstConclusions(String firstConclusions) {
		this.firstConclusions = firstConclusions;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public String getSecondNames() {
		return secondNames;
	}

	public void setSecondNames(String secondNames) {
		this.secondNames = secondNames;
	}

	public String getSecondConclusions() {
		return secondConclusions;
	}

	public void setSecondConclusions(String secondConclusions) {
		this.secondConclusions = secondConclusions;
	}

	public Date getSecondDate() {
		return secondDate;
	}

	public void setSecondDate(Date secondDate) {
		this.secondDate = secondDate;
	}

	public Integer getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(Integer firstValue) {
		this.firstValue = firstValue;
	}

	public Integer getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Integer secondValue) {
		this.secondValue = secondValue;
	}

	public Integer getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(Integer firstLevel) {
		this.firstLevel = firstLevel;
	}

	public Integer getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(Integer secondLevel) {
		this.secondLevel = secondLevel;
	}
	
}
