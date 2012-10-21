package com.xys.cenxi.customer.data;

import java.math.BigDecimal;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.db.DataSourceManager;
import com.xys.cenxi.customer.pojo.FamilyOutput;
import com.xys.cenxi.customer.pojo.FarmIncome;
import com.xys.cenxi.customer.pojo.OtherIncome;
import com.xys.cenxi.customer.util.OrderGenerator;

public class IncomeService {
	
	private static IncomeService service;
	
	private static final Logger log = LoggerFactory.getLogger(IncomeService.class);
	
	private IncomeService(){
	}
	
	public static IncomeService getInstance(){
		if(service == null){
			service = new IncomeService();
		}
		
		return service;
	}
	
	public FarmIncome add(FarmIncome fa){
		Dao dao = DataSourceManager.getDao();
		if(fa.getRowID() == null){
			fa.setRowID(OrderGenerator.newOrder());
			return dao.insert(fa);
		}else{
			//检查是否主键是否重复
			FarmIncome old = dao.fetch(fa);
			if(old != null){
				dao.update(fa);
				return fa;
			}else{
				return dao.insert(fa);
			}
		}
	}
	
	public void addFarmIncome(List<FarmIncome> income){
		for(FarmIncome in : income){
			add(in);
		}
	}
	
	public void delete(FarmIncome fa){
		Dao dao = DataSourceManager.getDao();
		dao.delete(fa);
	}
	
	public void delete(List<FarmIncome> fas){
		Dao dao = DataSourceManager.getDao();
		for(FarmIncome f : fas){
			dao.delete(f);
		}
	}
	
	public void update(FarmIncome fa){
		Dao dao = DataSourceManager.getDao();
		dao.update(fa);
	}
	
	/**
	 * 根据农户rowID查询种养收入情况
	 * @param cusomerID
	 * @return
	 */
	public List<FarmIncome> getFarmIncome(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.query(FarmIncome.class, Cnd.where("ownerID", "=", customerID));
	}
	
	public List<FarmIncome> getAllFarmIncome(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(FarmIncome.class, null);
	}
	
	public OtherIncome getOtherIncome(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(OtherIncome.class, Cnd.where("ownerID", "=", customerID));
	}
	
	public List<OtherIncome> getAllOtherIncome(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(OtherIncome.class, null);
	}
	
	public BigDecimal getFamilyTotalIncome(String customerID){
		//得到全部收入：种养收入+其他收入
		
		//种养收入
		List<FarmIncome> farmIncomes = getFarmIncome(customerID);
		BigDecimal result = BigDecimal.ZERO;
		for(FarmIncome income : farmIncomes){
			if(income.getIncome() != null){
				result = result.add(BigDecimal.valueOf(income.getIncome())); 
			}
		}
		
		//其他收入
		OtherIncome oi = getOtherIncome(customerID);
		if(oi != null){
			if(oi.getWorkIncome() != null){
				result = result.add(BigDecimal.valueOf(oi.getWorkIncome()));
			}
			if(oi.getOtherIncome() != null){
				result = result.add(BigDecimal.valueOf(oi.getOtherIncome()));
			}
		}
		return result;
	}
	
	public FamilyOutput getFamilyOutput(String customerID){
		Dao dao = DataSourceManager.getDao();
		return dao.fetch(FamilyOutput.class, Cnd.where("ownerID", "=", customerID));
	}
	
	public List<FamilyOutput> getAllFamilyOutput(){
		Dao dao = DataSourceManager.getDao();
		return dao.query(FamilyOutput.class, null);
	}

	public BigDecimal getFamilyNetIncome(String customerID){
		BigDecimal income = getFamilyTotalIncome(customerID);
		FamilyOutput output = getFamilyOutput(customerID);
		
		BigDecimal netIncome = BigDecimal.ZERO;;
		if(income != null){
			netIncome = income;
		}
		BigDecimal totalOut = BigDecimal.ZERO;
		if(output != null){
			if(output.getProductionOutput() != null){
				totalOut = totalOut.add(BigDecimal.valueOf(output.getProductionOutput()));
			}
			if(output.getLiftOutput() != null){
				totalOut = totalOut.add(BigDecimal.valueOf(output.getLiftOutput()));
			}
			if(output.getOtherOutput() != null){
				totalOut = totalOut.add(BigDecimal.valueOf((output.getOtherOutput())));
			}
		}
		
		netIncome = netIncome.subtract(totalOut);
		return netIncome;
	}
	
	public void update(OtherIncome income){
		Dao dao = DataSourceManager.getDao();
		dao.update(income);
	}
	
	public OtherIncome add(OtherIncome income){
		Dao dao = DataSourceManager.getDao();
		if(income.getRowID() == null){
			income.setRowID(OrderGenerator.newOrder());
			return dao.insert(income);
		}else{
			//检查是否主键是否重复
			OtherIncome old = dao.fetch(income);
			if(old != null){
				dao.update(income);
				return income;
			}else{
				return dao.insert(income);
			}
		}
	}
	
	public void addOtherIncome(List<OtherIncome> ois){
		for(OtherIncome oi : ois){
			add(oi);
		}
	}

	/**
	 * 不检查重复
	 * @param ois
	 */
	public void addAllOtherIncome(List<OtherIncome> ois){
		Dao dao = DataSourceManager.getDao();
		for(OtherIncome oi : ois){
			dao.insert(oi);
		}
	}
	
	public FamilyOutput add(FamilyOutput output){
		Dao dao = DataSourceManager.getDao();
		if(output.getRowID() == null){
			output.setRowID(OrderGenerator.newOrder());
			return dao.insert(output);
		}else{
			//检查是否主键是否重复
			FamilyOutput old = dao.fetch(output);
			if(old != null){
				dao.update(output);
				return output;
			}else{
				return dao.insert(output);
			}
		}
	}
	
	public void addFamilyOutput(List<FamilyOutput> out){
		for(FamilyOutput f : out){
			add(f);
		}
	}
	
	public void update(FamilyOutput output){
		Dao dao = DataSourceManager.getDao();
		dao.update(output);
	}
	
	/**
	 * 得到家庭总资产
	 * @param customerID
	 * @return
	 */
	public BigDecimal getTotalCapital(String customerID){
		//总资产=房产+林权+车辆+农机
		BigDecimal house = HousingService.getInstance().getTotalCapital(customerID);
		BigDecimal forestry = ForestryService.getInstance().getTotalCapital(customerID);
		BigDecimal vehicle = VehicleService.getInstance().getTotalCapital(customerID);
		BigDecimal machine = FarmMachineService.getInstance().getTotalCapital(customerID);
		
		BigDecimal total = house.add(forestry).add(vehicle).add(machine);
		
		return total;
	}
	
	/**
	 * 得到家庭年度总支出
	 * @param customerID
	 * @return
	 */
	public BigDecimal getTotalOutput(String customerID){
		FamilyOutput out = getFamilyOutput(customerID);
		float result = 0.0f;
		if(out == null){
			return null;
		}
		if(out.getLiftOutput() != null){
			result += out.getLiftOutput();
		}
		if(out.getOtherOutput() != null){
			result += out.getOtherOutput();
		}
		if(out.getProductionOutput() != null){
			result += out.getProductionOutput();
		}
		
		return BigDecimal.valueOf(result);
	}
	
	public void doOtherIncomeStructureChange(){
		if(!isOtherIncomeStructureChange()){
			return;
		}
		log.warn("表结构发生改变，需要重建表。");
		
		//先把数据查询出来
		log.info("查出全部数据");
		List<OtherIncome> data = getAllOtherIncome();
		//重新建表
		log.info("重建表");
		Dao dao = DataSourceManager.getDao();
		dao.create(OtherIncome.class, true);
		//插入数据
		log.info("重新插入数据");
		addAllOtherIncome(data);
		log.warn("表结构修改完成。");
	}
	
	private boolean isOtherIncomeStructureChange(){
		Dao dao = DataSourceManager.getDao();
		boolean change = false;
		try {
			OtherIncome cus = dao.fetch(OtherIncome.class);
			dao.update(cus);
		} catch (Exception e) {
			//有异常，说明表结构发生改变
			log.info("表结构发现改变: {}", e);
			change = true;
		}
		return change;
	}
}
