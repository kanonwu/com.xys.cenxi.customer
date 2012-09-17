package com.xys.cenxi.customer.data;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.Family;
import com.xys.cenxi.customer.util.OrderGenerator;

public class FamilyService {
	
	private static Logger log = LoggerFactory.getLogger(FamilyService.class);
	
	private static FamilyService service;
	
	private FamilyService(){
		
	}
	
	public static FamilyService getInstance(){
		if(service == null){
			service = new FamilyService();
		}
		
		return service;
	}
	
	public Family add(Family fa){
		Dao dao = DataSourceManager.getDao();
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
		}
		
		return dao.insert(fa);
	}
	
	public void add(List<? extends Family> fa){
		Dao dao = DataSourceManager.getDao();
		for(Family f : fa){
			dao.insert(f);
		}
	}
	
	public void delete(Family fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<Family> fas){
		Dao dao = DataSourceManager.getDao();
		for(Family f : fas){
			dao.delete(f);
		}
	}
	
	public void update(Family fa){
		Dao dao = DataSourceManager.getDao();
		dao.update(fa);
	}
	
	/**
	 * 根据农户rowID查询家庭成员
	 * @param cusomerID
	 * @return
	 */
	public List<Family> getFamily(String cusomerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Family.class, Cnd.where("ownerID", "=", cusomerID));
	}

	public List<Family> getAllFamily(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Family.class, null);
	}
	
	
	private boolean isStructureChange(){
		Dao dao = DataSourceManager.getDao();
		boolean change = false;
		try {
			Family fmaily = dao.fetch(Family.class);
			dao.update(fmaily);
		} catch (Exception e) {
			//有异常，说明表结构发生改变
			log.info("表结构发现改变: {}", e);
			change = true;
		}
		return change;
	}
	
	public  void doStructureChange(){
		if(!isStructureChange()){
			return;
		}
		log.warn("表结构发生改变，需要重建表。");
		
		//先把数据查询出来
		log.info("查出全部数据");
		List<Family> data = getAllFamily();
		//重新建表
		log.info("重建表");
		Dao dao = DataSourceManager.getDao();
		dao.create(Family.class, true);
		//插入数据
		log.info("重新插入数据");
		add(data);
		log.warn("表结构修改完成。");
	}
}
