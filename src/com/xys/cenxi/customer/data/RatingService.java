package com.xys.cenxi.customer.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.RateConclusion;
import com.xys.cenxi.customer.pojo.RateResult;
import com.xys.cenxi.customer.pojo.Rating;
import com.xys.cenxi.customer.start.Content;
import com.xys.cenxi.customer.util.OrderGenerator;

public class RatingService {
	
	private static final Logger logger = LoggerFactory.getLogger(RatingService.class);
	
	/**
	 * 初评
	 */
	public static Integer RATE_TYPE_FIRST = 0;
	
	/**
	 * 复评
	 */
	public static Integer RATE_TYPE_SECOND = 1;
	
	public static final String YOU_XIU = "优秀";
	
	public static final String LIANG_HAO = "良好";
	
	public static final String YI_BAN = "一般";
	
	public static final String JIAO_CHA = "较差";
	
	private static RatingService service;
	
	/**
	 * 评分项目数
	 */
	public static final int ITEM_SIZE = 18;
	
	private RatingService(){
		
	}
	
	public static RatingService getInstance(){
		if(service == null){
			service = new RatingService();
		}
		
		return service;
	}
	
	public Rating add(Rating fa){
		Dao dao = DataSourceManager.getDao();
		fa.setModifyTime(new Date());
		if(Content.getUser() != null){
			fa.setUserID(Content.getUser().getRowID());
		}
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
			return dao.insert(fa);
		}else{
			dao.update(fa);
			return fa;
		}
	}
	
	public void add(List<Rating> cr){
		for(Rating c : cr){
			add(c);
		}
	}
	
	public void delete(Rating fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<Rating> fas){
		Dao dao = DataSourceManager.getDao();
		for(Rating f : fas){
			dao.delete(f);
		}
	}
	
	public void update(Rating fa){
		Dao dao = DataSourceManager.getDao();
		fa.setModifyTime(new Date());
		dao.update(fa);
	}
	
	public List<Rating> getAllRating(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Rating.class, null);
	}
	
	/**
	 * 根据农户rowID查询初评评分结果
	 * @param cusomerID
	 * @return
	 */
	public List<Rating> getFirstRating(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Rating.class, Cnd.where("ownerID", "=", customerID).and("rateType", "=", RATE_TYPE_FIRST).asc("rateOrder"));
	}
	
	/**
	 * 根据农户rowID查询初评评分结果
	 * @param cusomerID
	 * @return
	 */
	public List<Rating> getSecondRating(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Rating.class, Cnd.where("ownerID", "=", customerID).and("rateType", "=", RATE_TYPE_SECOND).asc("rateOrder"));
	}
	
	/**
	 * 删除一个用户的评分结果
	 * @param customerID
	 */
	public void delete(String customerID){
		Dao dao = DataSourceManager.getDao();
		dao.clear(Rating.class, Cnd.where("ownerID", "=", customerID));
		//TODO:删除综合评分结果及评分意见
	}
	
	/**
	 * 返回的结果必须含有18项评分项，当没有评分数据时，评分项内容为空
	 * @param customerID 
	 * @return
	 */
	public RateResult getRateResult(String customerID){
		List<Rating> firstRating = getFirstRating(customerID);
		List<Rating> secondRating = getSecondRating(customerID);
		
		if(firstRating.isEmpty()){
			firstRating = initRating(RATE_TYPE_FIRST, customerID);
		}
		if(secondRating.isEmpty()){
			secondRating = initRating(RATE_TYPE_SECOND, customerID);
		}
		
		RateResult result = new RateResult(firstRating, secondRating);
		
		RateConclusion con = getRateconclusion(customerID);
		result.setConclusion(con);
		return result;
	}
	
	public void updateResult(RateResult result){
		logger.info("更新评分结果");
		add(result.getFirstRating());
		add(result.getSecondRating());
		add(result.getConclusion());
	}
	
	private List<Rating> initRating(int type, String customerID){
		List<Rating> rates = new ArrayList<Rating>(ITEM_SIZE);
		for(int i = 0; i < ITEM_SIZE; i++){
			Rating rate = new Rating();
			rate.setOwnerID(customerID);
			rate.setRateOrder(i + 1);
			rate.setRateType(type);
			rates.add(rate);
		}
		
		return rates;
	}
	
	public RateConclusion getRateconclusion(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(RateConclusion.class, Cnd.where("ownerID", "=", customerID));
	}
	
	public void update(RateConclusion conclusion){
		Dao dao = DataSourceManager.getDao();
		dao.update(conclusion);
	}
	
	public RateConclusion add(RateConclusion conclusion){
		Dao dao = DataSourceManager.getDao();
		if(conclusion.getRowID() == null){
			conclusion.setRowID(OrderGenerator.newOrder());
			return dao.insert(conclusion);
		}else{
			dao.update(conclusion);
			return conclusion;
		}
	}
	
}
