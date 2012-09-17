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
	 * ����ũ��rowID��ѯ��ͥ��Ա
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
			//���쳣��˵����ṹ�����ı�
			log.info("��ṹ���ָı�: {}", e);
			change = true;
		}
		return change;
	}
	
	public  void doStructureChange(){
		if(!isStructureChange()){
			return;
		}
		log.warn("��ṹ�����ı䣬��Ҫ�ؽ���");
		
		//�Ȱ����ݲ�ѯ����
		log.info("���ȫ������");
		List<Family> data = getAllFamily();
		//���½���
		log.info("�ؽ���");
		Dao dao = DataSourceManager.getDao();
		dao.create(Family.class, true);
		//��������
		log.info("���²�������");
		add(data);
		log.warn("��ṹ�޸���ɡ�");
	}
}
