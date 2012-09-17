package com.xys.cenxi.customer.pojo;

import java.util.List;

/**
 * 封装评分结果对象
 * @author wjl
 *
 */
public class RateResult {
	
	private List<Rating> firstRating;
	
	private List<Rating> secondRating;
	
	private RateConclusion conclusion;
	
	public RateResult(){
	}
	

	public RateResult(List<Rating> firstRating, List<Rating> secondRating){
		this.firstRating = firstRating;
		this.secondRating = secondRating;
	}
	
	/**
	 * 从1开始
	 * @param index
	 * @return
	 */
	public Rating getFirstValue(int index){
		return firstRating.get(index - 1);
	}
	
	/**
	 * 从1开始
	 * @param index
	 * @return
	 */
	public Rating getSecondRating(int index){
		return secondRating.get(index - 1);
	}


	public List<Rating> getFirstRating() {
		return firstRating;
	}


	public void setFirstRating(List<Rating> firstRating) {
		this.firstRating = firstRating;
	}


	public List<Rating> getSecondRating() {
		return secondRating;
	}


	public void setSecondRating(List<Rating> secondRating) {
		this.secondRating = secondRating;
	}


	public RateConclusion getConclusion() {
		return conclusion;
	}


	public void setConclusion(RateConclusion conclusion) {
		this.conclusion = conclusion;
	}
	
	
}
