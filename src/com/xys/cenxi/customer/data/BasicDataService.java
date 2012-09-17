package com.xys.cenxi.customer.data;

import com.xys.cenxi.customer.pojo.basic.BasicData;

public class BasicDataService {
	
	private static BasicDataService service;
	
	private static final BasicData[] jobs = new BasicData[10];
	
	private static final BasicData[] banks = new BasicData[8];
	
	
	private BasicDataService(){
		jobs[0] = new BasicData("0", "务农");
		jobs[1] = new BasicData("1", "务工");
		jobs[2] = new BasicData("2", "经商");
		jobs[3] = new BasicData("3", "公职");
		jobs[4] = new BasicData("4", "无业");
		jobs[5] = new BasicData("5", "上学");
		jobs[6] = new BasicData("6", "小孩");
		jobs[7] = new BasicData("7", "老人");
		jobs[8] = new BasicData("8", "未知");
		jobs[9] = new BasicData("9", "其他");
		
		banks[0] = new BasicData("0", "农村合作银行");
		banks[1] = new BasicData("1", "农业银行");
		banks[2] = new BasicData("2", "邮政银行");
		banks[3] = new BasicData("3", "工商银行");
		banks[4] = new BasicData("4", "建设银行");
		banks[5] = new BasicData("5", "交通银行");
		banks[6] = new BasicData("6", "中国银行");
		banks[7] = new BasicData("7", "其他");
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
