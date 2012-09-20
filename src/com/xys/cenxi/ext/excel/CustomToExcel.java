package com.xys.cenxi.ext.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.data.BasicDataService;
import com.xys.cenxi.customer.data.CredidtService;
import com.xys.cenxi.customer.data.FamilyService;
import com.xys.cenxi.customer.data.FarmMachineService;
import com.xys.cenxi.customer.data.ForestryService;
import com.xys.cenxi.customer.data.HousingService;
import com.xys.cenxi.customer.data.IncomeService;
import com.xys.cenxi.customer.data.VehicleService;
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
import com.xys.cenxi.customer.pojo.Vehicle;
import com.xys.cenxi.customer.pojo.basic.BasicData;
import com.xys.cenxi.customer.util.Util;

public class CustomToExcel {
	
	private static Logger logger = LoggerFactory.getLogger(CustomToExcel.class);
	
	private Customer customer;
	
	private Workbook readWorkBook;
	
	private WritableWorkbook outWorkBook;
	
//	private Sheet readSheet;
	
	private WritableSheet outSheet;
	
	private OutputStream os;
	
	private static final String OriginalExcel = "originalExcel.xls";
	
	public CustomToExcel(String outPath){
		File outFile = new File(outPath);
		try {
			os = new FileOutputStream(outFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("文件不存在:", e);
			throw new CusException(e);
		}
	}
	
	public void writeExcel(Customer cus){
		readExcel(OriginalExcel);
		this.customer = cus;
		try {
			writeHead();
			addCapital();
			addCredidt();
			addInOut();
		} catch (Exception e) {
			logger.error("严重错误：", e);
			throw new CusException(e);
		}finally{
			try {
				outWorkBook.write();
				outWorkBook.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("关闭文件出错：", e);
			} catch (WriteException e) {
				e.printStackTrace();
				logger.error("写入excel出错：", e);
			}
			
		}
		
	}
	
	private void readExcel(String filePath){
		try {
			readWorkBook = Workbook.getWorkbook(new File(filePath));
			outWorkBook = Workbook.createWorkbook(os, readWorkBook);
		} catch (BiffException e) {
			logger.error("读取excel出错：", e);
			throw new CusException(e);
		} catch (IOException e) {
			logger.error("读取excel出错：", e);
			throw new CusException(e);
		}
//		readSheet = readWorkBook.getSheet(0);
	}
	
	private void writeHead() throws Exception{
		outSheet = outWorkBook.getSheet(0);
		// 档案编号
		WritableCell cellArchive = outSheet.getWritableCell("X1");
		if(cellArchive.getType() == CellType.LABEL){
			Label label = (Label) cellArchive;
			label.setString(label.getString() + customer.getArchivesID());
		}
		
		//户主姓名
		WritableCell cellName = outSheet.getWritableCell("B3");
		if(cellName.getType() == CellType.LABEL){
			Label lblName = (Label) cellName;
			lblName.setString(customer.getName());
		}else{
			Label lblName = new Label(cellName.getColumn(), cellName.getRow(), customer.getName());
			outSheet.addCell(lblName);
		}
		
		//联系电话
		WritableCell cellTell = outSheet.getWritableCell("O3");
		if(cellTell.getType() == CellType.LABEL){
			Label lblTell = (Label) cellTell;
			lblTell.setString(customer.getTelPhone());
		}else{
			Label lblTell = new Label(cellTell.getColumn(), cellTell.getRow(), customer.getTelPhone());
			outSheet.addCell(lblTell);
		}

		//手机号码
		WritableCell cellPhone = outSheet.getWritableCell("X3");
		if(cellPhone.getType() == CellType.LABEL){
			Label lblPhone = (Label) cellPhone;
			lblPhone.setString(customer.getMobilePhone());
		}else{
			Label lblPhone = new Label(cellPhone.getColumn(), cellPhone.getRow(), customer.getMobilePhone());
			outSheet.addCell(lblPhone);
		}

		//通信地址
		WritableCell cellAddress = outSheet.getWritableCell("B4");
		if(cellAddress.getType() == CellType.LABEL){
			Label lblAdd = (Label) cellAddress;
			lblAdd.setString(customer.getAddress());
		}else{
			Label lblAdd = new Label(cellAddress.getColumn(), cellAddress.getRow(), customer.getAddress());
			outSheet.addCell(lblAdd);
		}
		
		//邮政编码
		WritableCell cellPostCode = outSheet.getWritableCell("X4");
		if(cellPostCode.getType() == CellType.LABEL){
			Label lblPostCode = (Label) cellPostCode;
			lblPostCode.setString(customer.getPostCode());
		}else{
			Label lblPostCode = new Label(cellPostCode.getColumn(), cellPostCode.getRow(), customer.getPostCode());
			outSheet.addCell(lblPostCode);
		}
		
		//家庭成员
		//先加入户主
		addFamilyMember(customer);
		
		//其他家庭成员
		List<Family> familys = FamilyService.getInstance().getFamily(customer.getRowID());
		int faRow = 7;
		for(Family fa : familys){
			addFamilyMember(fa, faRow);
			faRow++;
			if(faRow > 11){
				outSheet.insertRow(faRow);
			}
		}
	}
	
	private void addFamilyMember(Family fa, int row) throws Exception{
		//姓名
		WritableCell cusCell = outSheet.getWritableCell(0, row);
		setText(cusCell, fa.getName());
		
		//与户主关系
		cusCell = outSheet.getWritableCell(1, row);
		setText(cusCell, fa.getRelation());
		
		//身份证
		String idStr = fa.getIdentify();
		if(!Util.isEmpty(idStr)){
			int col = 2;
			for(int i = 0; i < idStr.length(); i++){
				String no = String.valueOf(idStr.charAt(i));
				cusCell = outSheet.getWritableCell(col, row);
				setText(cusCell, no);
				col++;
			}
		}
		
		//性别
		cusCell = outSheet.getWritableCell(20, row);
		setText(cusCell, fa.getGender());

		//出生日期
		if(fa.getBirthday() != null){
			cusCell = outSheet.getWritableCell(21, row);
			setText(cusCell, Util.DATE_SDF.format(fa.getBirthday()));
		}
		
		//健康状况
		cusCell = outSheet.getWritableCell(22, row);
		setText(cusCell, fa.getHealthy());

		//文化程度
		cusCell = outSheet.getWritableCell(23, row);
		setText(cusCell, fa.getEducation());
		
		//婚姻状况
		cusCell = outSheet.getWritableCell(24, row);
		setText(cusCell, fa.getMarry());

		
		//联系电话
		String phone = fa.getPhone();
		if(!Util.isEmpty(phone)){
			cusCell = outSheet.getWritableCell(25, row);
			setText(cusCell, phone);
		}
		
		//职业
		String jobCode = fa.getJobCode();
		if(!Util.isEmpty(jobCode)){
			BasicData job = BasicDataService.getInstant().getJobByCode(jobCode);
			if(job != null){
				cusCell = outSheet.getWritableCell(26, row);
				setText(cusCell, job.getName());
			}
		}
		
		//主要存款
		String bankCode = fa.getBankCode();
		if(!Util.isEmpty(bankCode)){
			BasicData bank = BasicDataService.getInstant().getBankByCode(bankCode);
			if(bank != null){
				cusCell = outSheet.getWritableCell(26, row);
				setText(cusCell, bank.getName());
			}
		}
		
		//资产情况
		
		//房产情况

	}
	
	private void addHouseForestry(){
		List<Housing> houses = HousingService.getInstance().getHouse(customer.getRowID());
		int count = 0;
		int row = 14;
		for(Housing h : houses){
			if(count > 1){
				//TODO:暂时只支持2条房产信息
				break;
			}
			WritableCell cell = outSheet.getWritableCell(0, row);
			setText(cell, h.getProperties());
			
			cell = outSheet.getWritableCell(1, row);
			setText(cell, h.getAddress());

			cell = outSheet.getWritableCell(3, row);
			if(h.getArea() != null){
				setText(cell, Util.toPlainString(h.getArea()));
			}
			
			cell = outSheet.getWritableCell(9, row);
			if(h.getPrice() != null){
				setText(cell, Util.toPlainString(h.getPrice()));
			}
			
			count++;
			row++;
		}
		
		List<ForestRights> forestry = ForestryService.getInstance().getForestry(customer.getRowID());
		count = 0;
		row = 14;
		for(ForestRights f : forestry){
			if(count > 1){
				//TODO:暂时只支持2条房产信息
				break;
			}
			WritableCell cell = outSheet.getWritableCell(14, row);
			String forest = "";
			if(Util.isEmpty(f.getDesc())){
				forest += f.getDesc();
				forest += ", ";
			}
			if(f.getArea() != null){
				forest += Util.toPlainString(f.getArea());
				forest += " 亩 ";
			}
			
			setText(cell, forest);
			
			cell = outSheet.getWritableCell(18, row);
			setText(cell, f.getVariety());

			cell = outSheet.getWritableCell(21, row);
			if(f.getPrice() != null){
				setText(cell, Util.toPlainString(f.getPrice()));
			}
			
			count++;
			row++;
		}
	}
	
	private void addVehicleMachine(){
		List<Vehicle> vehicles = VehicleService.getInstance().getVehicle(customer.getRowID());
		int count = 0;
		int row = 17;
		for(Vehicle v : vehicles){
			if(count > 1){
				//TODO:暂时只支持2条房产信息
				break;
			}
			WritableCell cell = outSheet.getWritableCell(0, row);
			String vv = "";
			if(!Util.isEmpty(v.getType())){
				vv += v.getType();
				vv += " ";
			}
			if(!Util.isEmpty(v.getDesc())){
				vv += v.getDesc();
			}
			setText(cell, vv);
			
			cell = outSheet.getWritableCell(1, row);
			setText(cell, v.getLicense());

			cell = outSheet.getWritableCell(3, row);
			setText(cell, v.getDisplacement());
			
			cell = outSheet.getWritableCell(9, row);
			if(v.getPrice() != null){
				setText(cell, Util.toPlainString(v.getPrice()));
			}
			
			count++;
			row++;
		}
		
		List<FarmMachine> machines = FarmMachineService.getInstance().getFarmMachine(customer.getRowID());
		count = 0;
		row = 17;
		for(FarmMachine f : machines){
			if(count > 1){
				//TODO:暂时只支持2条农机信息
				break;
			}
			WritableCell cell = outSheet.getWritableCell(14, row);
			setText(cell, f.getDesc());
			
			cell = outSheet.getWritableCell(18, row);
			setText(cell, f.getName());

			cell = outSheet.getWritableCell(21, row);
			if(f.getPrice() != null){
				setText(cell, Util.toPlainString(f.getPrice()));
			}
			
			count++;
			row++;
		}
		
	}
	
	/**
	 * 资产情况
	 */
	private void addCapital(){
		//房产林权
		addHouseForestry();
		//车辆农机
		addVehicleMachine();
		//借贷情况
		DebitCnd debit = CredidtService.getInstance().getDebitCnd(customer.getRowID());
		addDebitCnd(debit);
		//资产合计
		BigDecimal total = IncomeService.getInstance().getTotalCapital(customer.getRowID());
		if(total.compareTo(BigDecimal.ZERO) > 0){
			WritableCell cell = outSheet.getWritableCell("X15");
			setText(cell, Util.toPlainString(total));
		}
	}
	
	/**
	 * 其他重要信息 ☑ □
	 */
	private void addCredidt(){
		Credidt cre = CredidtService.getInstance().getCredidt(customer.getRowID());
		//贷款需求
		WritableCell cell = outSheet.getWritableCell("K34");
		setText(cell, cre.getLoadFor());
		if(cre.getLoadAmount() != null){
			setText(cell, Util.toPlainString(cre.getLoadAmount()));
		}
		
		//敬老情况 好  一般 差
		if(!Util.isEmpty(cre.getOldPeople())){
			String oldPeople = BasicDataService.getInstant().getGNBTextByName(cre.getOldPeople());
			cell = outSheet.getWritableCell("D21");
			setText(cell, oldPeople);
		}
		
		//商业保险情况： 是  否
		if(!Util.isEmpty(cre.getBusinessInsurance())){
			String yesNo = BasicDataService.getInstant().getYesNoTextByName(cre.getBusinessInsurance());
			cell = outSheet.getWritableCell("S21");
			setText(cell, yesNo);
		}
		
		//保险金额
		if(cre.getBiAmount() != null){
			cell = outSheet.getWritableCell("Z21");
			setText(cell, Util.toPlainString(cre.getBiAmount()));
		}
		
		//邻里关系 好  一般  差
		if(!Util.isEmpty(cre.getNeighbourhood())){
			String nei = BasicDataService.getInstant().getGNBTextByName(cre.getNeighbourhood());
			cell = outSheet.getWritableCell("D22");
			setText(cell, nei);
		}
		
		//养老保险 是  否
		if(!Util.isEmpty(cre.getEndowmentInsurance())){
			String yesNo = BasicDataService.getInstant().getYesNoTextByName(cre.getEndowmentInsurance());
			cell = outSheet.getWritableCell("S22");
			setText(cell, yesNo);
		}
		
		//参加人数
		if(cre.getEiCount() != null){
			cell = outSheet.getWritableCell("Z22");
			setText(cell, cre.getEiCount().toString());
		}
		
		//对公益事业 高  一般  从不关心
		if(!Util.isEmpty(cre.getPublicGood())){
			String pg = BasicDataService.getInstant().getPublicGoodTextByName(cre.getPublicGood());
			cell = outSheet.getWritableCell("D23");
			setText(cell, pg);
		}
		
		//合作医疗 是 否
		if(!Util.isEmpty(cre.getCooperativeMedical())){
			String yesNo = BasicDataService.getInstant().getYesNoTextByName(cre.getEndowmentInsurance());
			cell = outSheet.getWritableCell("S23");
			setText(cell, yesNo);
		}
		
		//参加人数
		if(cre.getCmCount() != null){
			cell = outSheet.getWritableCell("Z23");
			setText(cell, cre.getEiCount().toString());
		}
	}
	
	private void addDebitCnd(DebitCnd debit){
		if(debit == null)
			return;
		
		WritableCell cell = outSheet.getWritableCell("J20");
		setText(cell, debit.getBank());
		if(debit.getBalance() != null){
			cell = outSheet.getWritableCell("S20");
			setText(cell, Util.toPlainString(debit.getBalance()));
		}
	}
	
	/**
	 * 家庭收支情况
	 */
	private void addInOut(){
		//种养产品
		List<FarmIncome> fi = IncomeService.getInstance().getFarmIncome(customer.getRowID());
		int count = 0;
		int row = 26;
		float fiTotal = 0f;
		for(FarmIncome f : fi){
			if(count > 1){
				//TODO:暂时只支持2条种养信息
				break;
			}
			WritableCell cell = outSheet.getWritableCell(1, row);
			setText(cell, f.getVariety());
			
			cell = outSheet.getWritableCell(9, row);
			setText(cell, f.getOutput());

			cell = outSheet.getWritableCell(12, row);
			if(f.getArea() != null){
				setText(cell, Util.toPlainString(f.getArea()));
			}
			
			cell = outSheet.getWritableCell(16, row);
			if(f.getIncome() != null){
				setText(cell, Util.toPlainString(f.getIncome()));
				fiTotal += f.getIncome();
			}
			
			count++;
			row++;
		}
		
		//种养收入合计
		if(fiTotal > 0){
			WritableCell cell = outSheet.getWritableCell("Q29");
			setText(cell, Util.toPlainString(fiTotal));
		}
	
		OtherIncome oi = IncomeService.getInstance().getOtherIncome(customer.getRowID());
		if(oi != null){
			//外出务工收入
			if(oi.getWorkIncome() != null){
				WritableCell cell = outSheet.getWritableCell("U27");
				setText(cell, Util.toPlainString(oi.getWorkIncome()));
			}
			//其他收入
			if(oi.getOtherIncome() != null){
				WritableCell cell = outSheet.getWritableCell("W27");
				setText(cell, Util.toPlainString(oi.getOtherIncome()));
			}
		}
		
		//家庭年度总收入
		BigDecimal totalIncome = IncomeService.getInstance().getFamilyTotalIncome(customer.getRowID());
		if(totalIncome != null && totalIncome.compareTo(BigDecimal.ZERO) > 0){
			WritableCell cell = outSheet.getWritableCell("AA27");
			setText(cell, Util.toPlainString(totalIncome));
		}
		
		//支出情况
		FamilyOutput fo = IncomeService.getInstance().getFamilyOutput(customer.getRowID());
		if(fo != null){
			BigDecimal total = null;
			if(fo.getProductionOutput() != null){
				WritableCell cell = outSheet.getWritableCell("B32");
				setText(cell, Util.toPlainString(fo.getProductionOutput()));
				total = BigDecimal.valueOf(fo.getProductionOutput());
			}
			if(fo.getLiftOutput() != null){
				WritableCell cell = outSheet.getWritableCell("K32");
				setText(cell, Util.toPlainString(fo.getLiftOutput()));
				if(total == null){
					total = new BigDecimal(fo.getLiftOutput());
				}else{
					total.add(BigDecimal.valueOf(fo.getLiftOutput()));
				}
			}
			if(fo.getOtherOutput() != null){
				WritableCell cell = outSheet.getWritableCell("U32");
				setText(cell, Util.toPlainString(fo.getLiftOutput()));
				if(total == null){
					total = new BigDecimal(fo.getLiftOutput());
				}else{
					total.add(BigDecimal.valueOf(fo.getOtherOutput()));
				}
			}
			
			//家庭年度总支出
			if(total != null){
				WritableCell cell = outSheet.getWritableCell("X32");
				setText(cell, Util.toPlainString(total));
			}
		}
		
	}
	
	//
	private void setText(WritableCell cell, String text){
		if(Util.isEmpty(text)){
			return;
		}
		if(cell.getType() == CellType.LABEL){
			Label label = (Label) cell;
			label.setString(text);
		}else{
			Label label = new Label(cell.getColumn(), cell.getRow(), text);
			try {
				outSheet.addCell(label);
			} catch (RowsExceededException e) {
				logger.error("写入文本出错：", e);
				throw new CusException(e);
			} catch (WriteException e) {
				logger.error("写入文本出错：", e);
				throw new CusException(e);
			}
		}
	}
	
	private void addFamilyMember(Customer cus) throws Exception{
		//姓名
		WritableCell cusCell = outSheet.getWritableCell("A7");
		setText(cusCell, cus.getName());
		//与户主关系
		cusCell = outSheet.getWritableCell("B7");
		setText(cusCell, "户主");
		//身份证
		String idStr = cus.getIdentify();
		if(!Util.isEmpty(idStr)){
			int col = 2;
			int row = 6;
			for(int i = 0; i < idStr.length(); i++){
				String no = String.valueOf(idStr.charAt(i));
				cusCell = outSheet.getWritableCell(col, row);
				setText(cusCell, no);
				col++;
			}
		}
		
		//性别
		cusCell = outSheet.getWritableCell("U7");
		setText(cusCell, cus.getGender());

		//出生日期
		if(cus.getBirthday() != null){
			cusCell = outSheet.getWritableCell("V7");
			setText(cusCell, Util.DATE_SDF.format(cus.getBirthday()));
		}

		//文化程度
		cusCell = outSheet.getWritableCell("X7");
		setText(cusCell, cus.getEducation());
		
		//婚姻状况
		cusCell = outSheet.getWritableCell("Y7");
		setText(cusCell, cus.getMarry());
		
		//联系电话
		String phone = cus.getMobilePhone();
		if(Util.isEmpty(phone)){
			phone = cus.getTelPhone();
		}
		cusCell = outSheet.getWritableCell("Z7");
		setText(cusCell, phone);
	}

}
