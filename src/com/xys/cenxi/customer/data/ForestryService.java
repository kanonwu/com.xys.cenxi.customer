package com.xys.cenxi.customer.data;

import java.math.BigDecimal;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.ForestRights;
import com.xys.cenxi.customer.util.OrderGenerator;

public class ForestryService {
	
	private static ForestryService service;
	
	private ForestryService(){
		
	}
	
	public static ForestryService getInstance(){
		if(service == null){
			service = new ForestryService();
		}
		
		return service;
	}
	
	public ForestRights add(ForestRights fa){
		Dao dao = DataSourceManager.getDao();
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
		}
		
		return dao.insert(fa);
	}
	
	public void add(List<ForestRights> fr){
		Dao dao = DataSourceManager.getDao();
		for(ForestRights f : fr){
			dao.insert(f);
		}
	}
	
	public void delete(ForestRights fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<ForestRights> fas){
		Dao dao = DataSourceManager.getDao();
		for(ForestRights f : fas){
			dao.delete(f);
		}
	}
	
	public void update(ForestRights fa){
		Dao dao = DataSourceManager.getDao();
		dao.update(fa);
	}
	
	/**
	 * 根据农户rowID查询林权情况
	 * @param cusomerID
	 * @return
	 */
	public List<ForestRights> getForestry(String cusomerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(ForestRights.class, Cnd.where("ownerID", "=", cusomerID));
	}

	public List<ForestRights> getAllForestRights(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(ForestRights.class, null);
	}
	
	public BigDecimal getTotalCapital(String customerID){
		List<ForestRights> forest = getForestry(customerID);
		float result = 0.0f;
		for(ForestRights f : forest){
			if(f.getPrice() != null){
				result += f.getPrice();
			}
		}
		
		return BigDecimal.valueOf(result);
	}
}
