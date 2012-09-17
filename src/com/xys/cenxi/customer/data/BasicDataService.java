package com.xys.cenxi.customer.data;

import com.xys.cenxi.customer.pojo.basic.BasicData;

public class BasicDataService {
	
	private static BasicDataService service;
	
	private static final BasicData[] jobs = new BasicData[10];
	
	private static final BasicData[] banks = new BasicData[8];
	
	
	private BasicDataService(){
		jobs[0] = new BasicData("0", "��ũ");
		jobs[1] = new BasicData("1", "��");
		jobs[2] = new BasicData("2", "����");
		jobs[3] = new BasicData("3", "��ְ");
		jobs[4] = new BasicData("4", "��ҵ");
		jobs[5] = new BasicData("5", "��ѧ");
		jobs[6] = new BasicData("6", "С��");
		jobs[7] = new BasicData("7", "����");
		jobs[8] = new BasicData("8", "δ֪");
		jobs[9] = new BasicData("9", "����");
		
		banks[0] = new BasicData("0", "ũ���������");
		banks[1] = new BasicData("1", "ũҵ����");
		banks[2] = new BasicData("2", "��������");
		banks[3] = new BasicData("3", "��������");
		banks[4] = new BasicData("4", "��������");
		banks[5] = new BasicData("5", "��ͨ����");
		banks[6] = new BasicData("6", "�й�����");
		banks[7] = new BasicData("7", "����");
	}
	
	public static BasicDataService getInstant(){
		if(service == null){
			service  = new BasicDataService();
		}
		
		return service;
	}
	
	public BasicData[] getJobs(){
		return jobs;
	}
	
	public BasicData getJobByName(String name){
		for(BasicData bd : jobs){
			if(bd.getName().equals(name)){
				return bd;
			}
		}
		
		return null;
	}
	
	public BasicData getJobByCode(String code){
		for(BasicData bd : jobs){
			if(bd.getCode().equals(code)){
				return bd;
			}
		}
		
		return null;
	}
	
	public BasicData[] getBanks(){
		return banks;
	}
	
	public BasicData getBankByName(String name){
		for(BasicData bd : banks){
			if(bd.getName().equals(name)){
				return bd;
			}
		}
		return null;
	}
	
	public BasicData getBankByCode(String code){
		for(BasicData bd : banks){
			if(bd.getCode().equals(code)){
				return bd;
			}
		}
		return null;
	}

}
