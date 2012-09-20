package com.xys.cenxi.customer.data;

import com.xys.cenxi.customer.pojo.basic.BasicData;

public class BasicDataService {
	
	private static BasicDataService service;
	
	private static final BasicData[] jobs = new BasicData[10];
	
	private static final BasicData[] banks = new BasicData[8];
	
	private static final BasicData[] goodNomalBad = new BasicData[3];
	
	private static final BasicData[] yesNo = new BasicData[2];
	
	private static final BasicData[] publicGood = new BasicData[3];
	
	private static final String checkChar = "☑";
	
	private static final String unCheckChar = "□";
	
	
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
		
		goodNomalBad[0] = new BasicData("0", "好");
		goodNomalBad[1] = new BasicData("1", "一般");
		goodNomalBad[2] = new BasicData("0", "差");
		
		yesNo[0] = new BasicData("0", "是");
		yesNo[1] = new BasicData("1", "否");
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

	public BasicData[] getOldPeople(){
		return goodNomalBad;
	}
	
	public BasicData getGoodNomalBadByCode(String code){
		for(BasicData bd : goodNomalBad){
			if(bd.getCode().equals(code)){
				return bd;
			}
		}
		return null;
	}
	
	public BasicData getGoodNomalBadByName(String name){
		for(BasicData bd : goodNomalBad){
			if(bd.getName().equals(name)){
				return bd;
			}
		}
		return null;
	}
	
	public String getGoodNomalBadText(BasicData bd){
		return getShowText(goodNomalBad, bd);
	}
	
	public String getGNBTextByName(String name){
		return getGoodNomalBadText(getGoodNomalBadByName(name));
	}
	
	public BasicData getYesNoByName(String name){
		for(BasicData bd : yesNo){
			if(bd.getName().equals(name)){
				return bd;
			}
		}
		return null;
	}
	
	public BasicData getYesNoByCode(String code){
		for(BasicData bd : yesNo){
			if(bd.getCode().equals(code)){
				return bd;
			}
		}
		return null;
	}
	
	public String getYesNoText(BasicData bd){
		return getShowText(yesNo, bd);
	}
	
	public String getYesNoTextByName(String name){
		return getYesNoText(getYesNoByName(name));
	}
	
	public String getYesNoTextByCode(String code){
		return getYesNoText(getYesNoByCode(code));
	}
	
	public BasicData getPublicGoodByCode(String code){
		for(BasicData bd : publicGood){
			if(bd.getCode().equals(code)){
				return bd;
			}
		}
		return null;
	}
	
	public BasicData getPublidGoodByName(String name){
		for(BasicData bd : publicGood){
			if(bd.getName().equals(name)){
				return bd;
			}
		}
		return null;
	}
	
	private String getShowText(BasicData[] source, BasicData checkData){
		String result = "";
		for(BasicData b : source){
			if(b == checkData){
				result += checkChar;
			}else{
				result += unCheckChar;
			}
			result += b.getName();
			
			result += "  ";
		}
		
		return result;
	}
	
	public String getPublicGoodText(BasicData bd){
		return getShowText(publicGood, bd);
	}
	
	public String getPublicGoodTextByCode(String code){
		return getPublicGoodText(getPublicGoodByCode(code));
	}
	
	public String getPublicGoodTextByName(String name){
		return getPublicGoodText(getBankByName(name));
	}
}
