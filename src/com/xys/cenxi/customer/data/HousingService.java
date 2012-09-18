package com.xys.cenxi.customer.data;

import java.math.BigDecimal;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.Housing;
import com.xys.cenxi.customer.util.OrderGenerator;

public class HousingService {
	
	private static HousingService service;
	
	private HousingService(){
		
	}
	
	public static HousingService getInstance(){
		if(service == null){
			service = new HousingService();
		}
		
		return service;
	}
	
	public Housing add(Housing fa){
		Dao dao = DataSourceManager.getDao();
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
			return dao.insert(fa);
		}else{
			//检查是否主键是否重复
			Housing old = dao.fetch(fa);
			if(old != null){
				dao.update(fa);
				return fa;
			}else{
				return dao.insert(fa);
			}
		}
	}
	
	public void add(List<Housing> houses){
		for(Housing h : houses){
			add(h);
		}
	}
	
	public void delete(Housing fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<Housing> fas){
		Dao dao = DataSourceManager.getDao();
		for(Housing f : fas){
			dao.delete(f);
		}
	}
	
	public void update(Housing fa){
		Dao dao = DataSourceManager.getDao();
		dao.update(fa);
	}
	
	/**
	 * 根据农户rowID查询房产情况
	 * @param cusomerID
	 * @return
	 */
	public List<Housing> getHouse(String cusomerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Housing.class, Cnd.where("ownerID", "=", cusomerID));
	}

	public List<Housing> getAllHouse(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Housing.class, null);
	}
	
	/**
	 * 得到房产总价值
	 * @param customerID
	 * @return
	 */
	public BigDecimal getTotalCapital(String customerID){
		List<Housing> houses = getHouse(customerID);
		float total = 0.0f;
		for(Housing h : houses){
			if(h.getPrice() != null){
				total += h.getPrice();
			}
		}
		
		return BigDecimal.valueOf(total);
	}
}
