package com.xys.cenxi.customer.data;

import java.math.BigDecimal;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.Vehicle;
import com.xys.cenxi.customer.util.OrderGenerator;

public class VehicleService {
	
	private static VehicleService service;
	
	private VehicleService(){
	}
	
	public static VehicleService getInstance(){
		if(service == null){
			service = new VehicleService();
		}
		
		return service;
	}
	
	public Vehicle add(Vehicle fa){
		Dao dao = DataSourceManager.getDao();
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
			return dao.insert(fa);
		}else{
			//检查是否主键是否重复
			Vehicle old = dao.fetch(fa);
			if(old != null){
				dao.update(fa);
				return fa;
			}else{
				return dao.insert(fa);
			}
		}
	}
	
	public void add(List<Vehicle> ve){
		for(Vehicle v : ve){
			add(v);
		}
	}
	
	public void delete(Vehicle fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<Vehicle> fas){
		Dao dao = DataSourceManager.getDao();
		for(Vehicle f : fas){
			dao.delete(f);
		}
	}
	
	public void update(Vehicle fa){
		Dao dao = DataSourceManager.getDao();
		dao.update(fa);
	}
	
	/**
	 * 根据农户rowID查询车辆情况
	 * @param cusomerID
	 * @return
	 */
	public List<Vehicle> getVehicle(String cusomerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Vehicle.class, Cnd.where("ownerID", "=", cusomerID));
	}
	
	public List<Vehicle> getAllVehicle(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Vehicle.class, null);
	}
	
	public BigDecimal getTotalCapital(String customerID){
		List<Vehicle> veh = getVehicle(customerID);
		float result = 0.0f;
		for(Vehicle v : veh){
			if(v.getPrice() != null){
				result += v.getPrice();
			}
		}
		
		return BigDecimal.valueOf(result);
	}

}
