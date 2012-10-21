package com.xys.cenxi.customer.data;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.Credidt;
import com.xys.cenxi.customer.pojo.DebitCnd;
import com.xys.cenxi.customer.pojo.PingYiResult;
import com.xys.cenxi.customer.util.OrderGenerator;

public class CredidtService {
	
	private static CredidtService service;
	
	private static final Logger log = LoggerFactory.getLogger(CredidtService.class);
	
	private CredidtService(){
		
	}
	
	public static CredidtService getInstance(){
		if(service == null){
			service = new CredidtService();
		}
		
		return service;
	}
	
	public Credidt add(Credidt fa){
		Dao dao = DataSourceManager.getDao();
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
			return dao.insert(fa);
		}else{
			//检查是否主键是否重复
			Credidt old = dao.fetch(fa);
			if(old != null){
				dao.update(fa);
				return fa;
			}else{
				return dao.insert(fa);
			}
		}
	}
	
	public void add(List<Credidt> cr){
		for(Credidt c : cr){
			add(c);
		}
	}

	
	private void addAll(List<Credidt> cr){
		Dao dao = DataSourceManager.getDao();
		for(Credidt c : cr){
			dao.insert(c);
		}
	}
	
	public void delete(Credidt fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<Credidt> fas){
		Dao dao = DataSourceManager.getDao();
		for(Credidt f : fas){
			dao.delete(f);
		}
	}
	
	public void update(Credidt fa){
		Dao dao = DataSourceManager.getDao();
		dao.update(fa);
	}
	
	public List<Credidt> getAllCredidt(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Credidt.class, null);
	}
	
	/**
	 * 鏍规嵁鍐滄埛rowID鏌ヨ鍏朵粬閲嶈淇℃伅
	 * @param cusomerID
	 * @return
	 */
	public Credidt getCredidt(String cusomerID){
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(Credidt.class, Cnd.where("ownerID", "=", cusomerID));
	}
	
	public DebitCnd getDebitCnd(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(DebitCnd.class, Cnd.where("ownerID", "=", customerID));
	}
	
	public PingYiResult getPingYiResult(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(PingYiResult.class, Cnd.where("ownerID", "=", customerID));
	}
	
	public List<DebitCnd> getAllDeitCnd(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(DebitCnd.class, null);
	}
	
	public PingYiResult add(PingYiResult pyr){
		Dao dao = DataSourceManager.getDao();
		if(pyr.getRowID() == null){
			pyr.setRowID(OrderGenerator.newOrder());
			return dao.insert(pyr);
		}else{
			//检查主键
			PingYiResult temp = dao.fetch(pyr);
			if(temp != null){
				dao.update(pyr);
				return pyr;
			}else{
				return dao.insert(pyr);
			}
		}
	}
	
	public DebitCnd add(DebitCnd debit){
		Dao dao = DataSourceManager.getDao();
		if(debit.getRowID() == null){
			debit.setRowID(OrderGenerator.newOrder());
			return dao.insert(debit);
		}else{
			//检查主键
			DebitCnd cnd = dao.fetch(debit);
			if(cnd != null){
				dao.update(debit);
				return debit;
			}else{
				return dao.insert(debit);
			}
		}
	}
	
	public void addDebitCnd(List<DebitCnd> deb){
		for(DebitCnd d : deb){
			add(d);
		}
	}
	
	public void update(DebitCnd debit){
		Dao dao = DataSourceManager.getDao();
		dao.update(debit);
	}

	public void delete(DebitCnd debit){
		Dao dao = DataSourceManager.getDao();
		dao.delete(debit);
	}
	
	private boolean isStructureChange(){
		Dao dao = DataSourceManager.getDao();
		boolean change = false;
		try {
			Credidt cus = dao.fetch(Credidt.class);
			dao.update(cus);
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
		List<Credidt> data = getAllCredidt();
		//重新建表
		log.info("重建表");
		Dao dao = DataSourceManager.getDao();
		dao.create(Credidt.class, true);
		//插入数据
		log.info("重新插入数据");
		addAll(data);
		log.warn("表结构修改完成。");
	}
}
