package com.xys.cenxi.customer.data;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.Credidt;
import com.xys.cenxi.customer.pojo.DebitCnd;
import com.xys.cenxi.customer.util.OrderGenerator;

public class CredidtService {
	
	private static CredidtService service;
	
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
	
	public List<DebitCnd> getAllDeitCnd(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(DebitCnd.class, null);
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
}
