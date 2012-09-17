package com.xys.cenxi.customer.data;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.util.cri.Like;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.data.query.CustomerQueryKey;
import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.Customer;
import com.xys.cenxi.customer.util.OrderGenerator;
import com.xys.cenxi.customer.util.Util;

public class CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	private static CustomerService service;
	
	private CustomerService(){
	}
	
	public static CustomerService getService(){
		if(service == null){
			service = new CustomerService();
		}
		
		return service;
	}
	
	public Customer addCustomer(Customer customer){
		Dao dao = DataSourceManager.getDao();
		if(customer.getRowID() == null){
			customer.setRowID(OrderGenerator.newOrder());
		}
		customer.setModifyTime(new Date());
		
		return dao.insert(customer);
	}
	
	public void add(List<? extends Customer> cus){
		Dao dao = DataSourceManager.getDao();
		for(Customer c : cus){
			dao.insert(c);
		}
	}
	
	public void updateCustomer(Customer customer){
		customer.setModifyTime(new Date());
		Dao dao = DataSourceManager.getDao();
		dao.update(customer);
	}
	
	public void deleteCustomer(Customer customer){
		Dao dao = DataSourceManager.getDao();
		dao.delete(customer);
	}
	
	public void deleteCustomer(List<Customer> items){
		Dao dao = DataSourceManager.getDao();
		for(Customer cus : items){
			dao.delete(cus);
		}
	}
	
	public List<Customer> getCustomer(CustomerQueryKey key){
		List<Customer> result = null;
		Dao dao = DataSourceManager.getDao();
		Criteria cri = Cnd.cri();
		if(!Util.isEmpty(key.name)){
			cri.where().and("name", "=", key.name);
		}
		if(!Util.isEmpty(key.identify)){
			cri.where().and("identify", "=", key.identify);
		}
		if(!Util.isEmpty(key.gender)){
			cri.where().and("gender", "=", key.gender);
		}
		if(!Util.isEmpty(key.marry)){
			cri.where().and("marry", "=", key.marry);
		}
		if(!Util.isEmpty(key.education)){
			cri.where().and("education", "=", key.education);
		}
		if(!Util.isEmpty(key.regional)){
			//ȥ��ĩβ0����ѯ�Դ��ַ�����ʼ����������
			
//			cri.where().and("regional", "=", key.regional);
			cri.where().andLike("regional", Util.removeRightZero(key.regional));
		}
		if(!Util.isEmpty(key.address)){
			cri.where().andLike("address", key.address);
		}
		
		cri.getOrderBy().asc("archivesID");
		

		if(key.pagerInfo != null){
			result = dao.query(Customer.class, cri, key.pagerInfo);
			key.pagerInfo.setRecordCount(dao.count(Customer.class, cri));
		}else{
			result = dao.query(Customer.class, cri);
		}
		
		return result;
	}
	
	public List<Customer> getAllCustomer(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(Customer.class, null);
	}

	
	private boolean isStructureChange(){
		Dao dao = DataSourceManager.getDao();
		boolean change = false;
		try {
			Customer cus = dao.fetch(Customer.class);
			dao.update(cus);
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
		List<Customer> data = getAllCustomer();
		//���½���
		log.info("�ؽ���");
		Dao dao = DataSourceManager.getDao();
		dao.create(Customer.class, true);
		//��������
		log.info("���²�������");
		add(data);
		log.warn("��ṹ�޸���ɡ�");
	}
}
