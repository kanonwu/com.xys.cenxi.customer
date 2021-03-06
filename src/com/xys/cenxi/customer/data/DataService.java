package com.xys.cenxi.customer.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.exception.CusException;
import com.xys.cenxi.customer.pojo.Credidt;
import com.xys.cenxi.customer.pojo.Customer;
import com.xys.cenxi.customer.pojo.DebitCnd;
import com.xys.cenxi.customer.pojo.Family;
import com.xys.cenxi.customer.pojo.FamilyOutput;
import com.xys.cenxi.customer.pojo.FarmIncome;
import com.xys.cenxi.customer.pojo.FarmMachine;
import com.xys.cenxi.customer.pojo.ForestRights;
import com.xys.cenxi.customer.pojo.Housing;
import com.xys.cenxi.customer.pojo.OtherIncome;
import com.xys.cenxi.customer.pojo.RateConclusion;
import com.xys.cenxi.customer.pojo.Rating;
import com.xys.cenxi.customer.pojo.Vehicle;

/**
 * 数据导入导出
 * @author wjl
 *
 */
public class DataService {
	
	private static Logger log = LoggerFactory.getLogger(DataService.class);
	
	private static DataService service;
	
	private DataService(){
		
	}
	
	public static DataService getInstance(){
		if(service == null){
			service = new DataService();
		}
		
		return service;
	}
	
	public void exportData(FileOutputStream fis){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fis);
			log.info("开始导出数据。");
			writeCredidt(oos);
			writeCustomer(oos);
			writeDebitCnd(oos);
			writeFamily(oos);
			writeFamilyOutput(oos);
			writeFamilyIncome(oos);
			writeFarmMachine(oos);
			writeForestry(oos);
			writeHouse(oos);
			writeOtherIncome(oos);
			writeVehicle(oos);
			writeRateResult(oos);
			log.info("数据导出完成。");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("导出数据出错：", e);
			throw new CusException("导出数据出错 ", e);
		}
	}
	
	public void importData(FileInputStream fis){
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			log.info("开始导入数据。");
			readCredidt(ois);
			readCustomer(ois);
			readDebitCnd(ois);
			readFamily(ois);
			readFamilyoutput(ois);
			readFamilyIncome(ois);
			readFarmMachine(ois);
			readForestry(ois);
			readHouse(ois);
			readOtherIncome(ois);
			readVehicle(ois);
			readRateResult(ois);
			log.info("导入数据完成。");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("导入数据出错：", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error("导入数据出错：", e);
		}
	}
	
	public void writeCredidt(ObjectOutputStream aoos) throws IOException{
		List<Credidt> credids = CredidtService.getInstance().getAllCredidt();
		aoos.writeObject(credids);
	}
	
	public void writeCustomer(ObjectOutputStream aoos) throws IOException{
		List<Customer> cus = CustomerService.getService().getAllCustomer();
		aoos.writeObject(cus);
	}
	
	public void writeDebitCnd(ObjectOutputStream aoos) throws IOException{
		List<DebitCnd> debit = CredidtService.getInstance().getAllDeitCnd();
		aoos.writeObject(debit);
	}
	
	public void writeFamily(ObjectOutputStream aoos) throws IOException{
		List<Family> fa = FamilyService.getInstance().getAllFamily();
		aoos.writeObject(fa);
	}
	
	public void writeFamilyOutput(ObjectOutputStream oos) throws IOException{
		List<FamilyOutput> out = IncomeService.getInstance().getAllFamilyOutput();
		oos.writeObject(out);
	}
	
	public void writeFamilyIncome(ObjectOutputStream oos) throws IOException{
		List<FarmIncome> in = IncomeService.getInstance().getAllFarmIncome();
		oos.writeObject(in);
	}
	
	public void writeFarmMachine(ObjectOutputStream aoos) throws IOException{
		List<FarmMachine> machines = FarmMachineService.getInstance().getAllFarmMachine();
		aoos.writeObject(machines);
	}
	
	public void writeForestry(ObjectOutputStream aoos) throws IOException{
		List<ForestRights> fores = ForestryService.getInstance().getAllForestRights();
		aoos.writeObject(fores);
	}
	
	public void writeHouse(ObjectOutputStream aoos) throws IOException{
		List<Housing> houses = HousingService.getInstance().getAllHouse();
		aoos.writeObject(houses);
	}
	
	public void writeOtherIncome(ObjectOutputStream aoos) throws IOException{
		List<OtherIncome> ois = IncomeService.getInstance().getAllOtherIncome();
		aoos.writeObject(ois);
	}
	
	public void writeVehicle(ObjectOutputStream aoos) throws IOException{
		List<Vehicle> veh = VehicleService.getInstance().getAllVehicle();
		aoos.writeObject(veh);
	}
	
	public void writeRateResult(ObjectOutputStream oos) throws IOException{
		List<Rating> ratings = RatingService.getInstance().getAllRating();
		oos.writeObject(ratings);
		List<RateConclusion> con = RatingService.getInstance().getAllRateConclution();
		oos.writeObject(con);
	}

	
	@SuppressWarnings("unchecked")
	public void readCredidt(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<Credidt> credidt = ((List<Credidt>) ois.readObject());
		CredidtService.getInstance().add(credidt);
	}
	
	@SuppressWarnings("unchecked")
	public void readCustomer(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<Customer> cus = (List<Customer>) ois.readObject();
		CustomerService.getService().add(cus);
	}
	
	@SuppressWarnings("unchecked")
	public void readDebitCnd(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<DebitCnd> deb = (List<DebitCnd>) ois.readObject();
		CredidtService.getInstance().addDebitCnd(deb);
	}
	
	@SuppressWarnings("unchecked")
	public void readFamily(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<Family> fam = (List<Family>) ois.readObject();
		FamilyService.getInstance().add(fam);
	}
	
	@SuppressWarnings("unchecked")
	public void readFamilyoutput(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<FamilyOutput> out = (List<FamilyOutput>) ois.readObject();
		IncomeService.getInstance().addFamilyOutput(out);
	}
	
	@SuppressWarnings("unchecked")
	public void readFamilyIncome(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<FarmIncome> income = (List<FarmIncome>) ois.readObject();
		IncomeService.getInstance().addFarmIncome(income);
	}
	
	@SuppressWarnings("unchecked")
	public void readFarmMachine(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<FarmMachine> fm = (List<FarmMachine>) ois.readObject();
		FarmMachineService.getInstance().add(fm);
	}
	
	@SuppressWarnings("unchecked")
	public void readForestry(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<ForestRights> fr = (List<ForestRights>) ois.readObject();
		ForestryService.getInstance().add(fr);
	}
	
	@SuppressWarnings("unchecked")
	public void readHouse(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<Housing> houses = (List<Housing>) ois.readObject();
		HousingService.getInstance().add(houses);
	}
	
	@SuppressWarnings("unchecked")
	public void readOtherIncome(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<OtherIncome> oi = (List<OtherIncome>) ois.readObject();
		IncomeService.getInstance().addOtherIncome(oi);
	}
	
	@SuppressWarnings("unchecked")
	public void readVehicle(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		List<Vehicle> ve = (List<Vehicle>) ois.readObject();
		VehicleService.getInstance().add(ve);
	}
	
	@SuppressWarnings("unchecked")
	public void readRateResult(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		//评分结果
		List<Rating> rating = (List<Rating>) ois.readObject();
		List<RateConclusion> con = (List<RateConclusion>) ois.readObject();
		RatingService.getInstance().add(rating);
		RatingService.getInstance().addRateConclusion(con);
	}
	
}
