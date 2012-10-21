package com.xys.cenxi.customer.ui.component.infomgr;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.xys.cenxi.customer.data.EducationService;
import com.xys.cenxi.customer.data.GenderService;
import com.xys.cenxi.customer.data.HealthyService;
import com.xys.cenxi.customer.data.BasicDataService;
import com.xys.cenxi.customer.data.MarryService;
import com.xys.cenxi.customer.data.RegionalService;
import com.xys.cenxi.customer.pojo.Customer;
import com.xys.cenxi.customer.pojo.Regional;
import com.xys.cenxi.customer.pojo.basic.BasicData;
import com.xys.cenxi.customer.ui.component.regional.RegionalDialog;
import com.xys.cenxi.customer.util.UIUtil;
import com.xys.cenxi.customer.util.Util;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class CustomerCmp extends Composite {
	private Text textArchivesID;
	private Text textIdentify;
	private Text textName;
	private Text textAge;
	private Text textPhone;
	private Text textTell;
	private Text textPostcode;
	private Text textAddress;
	private Text textDesc;
	private Combo comboGender;
	private DateTime dtBirthday;
	private Combo comboMarry;
	private Combo comboHealthy;
	private Combo comboEducation;
	

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CustomerCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(13, false));
		
		Label label = new Label(this, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("\u6863\u6848\u7F16\u53F7\uFF1A");
		
		textArchivesID = new Text(this, SWT.BORDER);
		GridData gd_textArchivesID = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_textArchivesID.widthHint = 70;
		textArchivesID.setLayoutData(gd_textArchivesID);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setText("*");
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u8EAB\u4EFD\u8BC1\uFF1A");
		
		textIdentify = new Text(this, SWT.BORDER);
		textIdentify.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				Util.verifyID(e, textIdentify.getText());
			}
		});
		textIdentify.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				int length = textIdentify.getText().length();
				String str = "*";
				if(length > 0){
					str += length;
				}
				lblIdentify.setText(str);
				
				if(length > 15){
					idCardProcess(textIdentify.getText());
				}
			}
		});
		GridData gd_textIdentify = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_textIdentify.widthHint = 134;
		textIdentify.setLayoutData(gd_textIdentify);
		
		lblIdentify = new Label(this, SWT.NONE);
		lblIdentify.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblIdentify.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIdentify.setText("*");
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("\u6237\u4E3B\u59D3\u540D\uFF1A");
		
		textName = new Text(this, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setText("*");
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("\u6027\u522B\uFF1A");
		
		comboGender = new Combo(this, SWT.READ_ONLY);
		GridData gd_comboGender = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_comboGender.widthHint = 35;
		comboGender.setLayoutData(gd_comboGender);
		
		Label label_17 = new Label(this, SWT.NONE);
		label_17.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_17.setText("\u4ECE\u4E8B\u884C\u4E1A\uFF1A");
		
		cbJob = new Combo(this, SWT.READ_ONLY);
		GridData gd_cbJob = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_cbJob.widthHint = 50;
		cbJob.setLayoutData(gd_cbJob);
		new Label(this, SWT.NONE);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("\u751F\u65E5\uFF1A");
		
		dtBirthday = new DateTime(this, SWT.BORDER | SWT.DROP_DOWN | SWT.LONG);
		dtBirthday.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doCalAge();
			}
		});
		GridData gd_dtBirthday = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_dtBirthday.widthHint = 111;
		dtBirthday.setLayoutData(gd_dtBirthday);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_5 = new Label(this, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_5.setText("\u5E74\u9F84\uFF1A");
		
		textAge = new Text(this, SWT.BORDER);
		textAge.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		textAge.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				//校验购建年份：位数不能超过2位
				String text = textAge.getText();
				String newStr = Util.verifyInteger(e, text);

				if(newStr.length() > 2){
					e.doit = false;
				}
			}
		});
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_6 = new Label(this, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setText("\u5A5A\u59FB\u72B6\u51B5\uFF1A");
		
		comboMarry = new Combo(this, SWT.READ_ONLY);
		comboMarry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		
		Label label_7 = new Label(this, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_7.setText("\u5065\u5EB7\u72B6\u51B5\uFF1A");
		
		comboHealthy = new Combo(this, SWT.READ_ONLY);
		GridData gd_comboHealthy = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_comboHealthy.widthHint = 100;
		comboHealthy.setLayoutData(gd_comboHealthy);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_8.setText("\u6587\u5316\u7A0B\u5EA6\uFF1A");
		
		comboEducation = new Combo(this, SWT.READ_ONLY);
		comboEducation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_10 = new Label(this, SWT.NONE);
		label_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_10.setText("\u624B\u673A\u53F7\u7801\uFF1A");
		
		textPhone = new Text(this, SWT.BORDER);
		textPhone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		
		Label label_11 = new Label(this, SWT.NONE);
		label_11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_11.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		textTell = new Text(this, SWT.BORDER);
		textTell.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_12 = new Label(this, SWT.NONE);
		label_12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_12.setAlignment(SWT.RIGHT);
		label_12.setText("\u90AE\u653F\u7F16\u7801\uFF1A");
		
		textPostcode = new Text(this, SWT.BORDER);
		textPostcode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_14 = new Label(this, SWT.NONE);
		label_14.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_14.setText("\u901A\u8BAF\u5730\u5740\uFF1A");
		
		textAddress = new Text(this, SWT.BORDER);
		textAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		
		Label label_16 = new Label(this, SWT.NONE);
		label_16.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_16.setText("*");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_9 = new Label(this, SWT.NONE);
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_9.setText("\u884C\u653F\u533A\u5212\uFF1A");
		
		textRegional = new Text(this, SWT.BORDER | SWT.READ_ONLY);
		textRegional.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.DEL || e.keyCode == SWT.BS){
					//监听删除和回退按键
					doClearRegional();
					e.doit = false;
				}
			}
		});
		GridData gd_textRegional = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_textRegional.widthHint = 112;
		textRegional.setLayoutData(gd_textRegional);
		
		Label lblNewLabel_6 = new Label(this, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_6.setText("*");
		
		Button btnOpenRegional = new Button(this, SWT.NONE);
		btnOpenRegional.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doRegionalSelect();
			}
		});
		btnOpenRegional.setText("...");
		new Label(this, SWT.NONE);
		
		Label label_18 = new Label(this, SWT.NONE);
		label_18.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1));
		label_18.setText("\u5B58\u6B3E\u3001\u6C47\u6B3E\u7B49\u91D1\u878D\u670D\u52A1\u662F\u5426\u4EE5\u6211\u884C\u4F4D\u4E3B\u8981\u884C\uFF1A");
		
		cbMainBank = new Combo(this, SWT.READ_ONLY);
		cbMainBank.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		cbMainBank.select(0);
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_3.setText("*");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label_15 = new Label(this, SWT.WRAP);
		label_15.setAlignment(SWT.CENTER);
		GridData gd_label_15 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label_15.widthHint = 62;
		label_15.setLayoutData(gd_label_15);
		label_15.setText("\u5176\u4ED6\u9700\u8981\u8BF4\u660E\u4E8B\u9879\uFF1A");
		
		textDesc = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textDesc.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				//不超过50个字
				String str = textDesc.getText();
				str += e.text;
				if(str.length() > 50){
					e.doit = false;
				}
			}
		});
		GridData gd_textDesc = new GridData(SWT.FILL, SWT.CENTER, false, false, 9, 1);
		gd_textDesc.heightHint = 43;
		textDesc.setLayoutData(gd_textDesc);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		initInput();
	}
	
	private void idCardProcess(String idCard){
		if(idCard == null || idCard.length() < 15){
			return;
		}
		Calendar birthday = Util.idCardVlidator.getBirthday(idCard);
		if(birthday != null){
			dtBirthday.setYear(birthday.get(Calendar.YEAR));
			dtBirthday.setDay(birthday.get(Calendar.DAY_OF_MONTH));
			dtBirthday.setMonth(birthday.get(Calendar.MONTH));
			
			Calendar cal =  Calendar.getInstance();
			int age = cal.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
			textAge.setText(String.valueOf(age));
		}else{
			textAge.setText("");
		}
	}

	protected void doCalAge() {
		//计算年龄
		Calendar cal = Calendar.getInstance();
		int curryear = cal.get(Calendar.YEAR);
		int year = dtBirthday.getYear();
		if(year > curryear){
			textAge.setText("");
		}else{
			textAge.setText(String.valueOf(curryear - year));
		}
	}

	protected void doClearRegional() {
		textRegional.setText("");
		textRegional.setData(null);
	}

	protected void doRegionalSelect() {
		RegionalDialog rd = new RegionalDialog(getShell());
		rd.setCheck(false);
		rd.open();
		Object result = rd.getResult();
		if(result instanceof Regional){
			Regional re = (Regional) result;
			textRegional.setText(re.getName());
			textRegional.setData(re);
		}
	}

	private void initInput(){
		String[] genders = GenderService.getInstant().getGenders();
		comboGender.setItems(genders);
		if(genders.length > 0){
			comboGender.select(0);
		}
		
		String[] marry = MarryService.getInstant().getMarrys();
		comboMarry.setItems(marry);
		if(marry.length > 0){
			comboMarry.select(0);
		}
		
		String[] edu = EducationService.getInstant().getEducations();
		comboEducation.setItems(edu);
		if(edu.length > 0){
			comboEducation.select(0);
		}
		
		String[] healthy = HealthyService.getInstant().getHealthy();
		comboHealthy.setItems(healthy);
		if(healthy.length  > 0){
			comboHealthy.select(0);
		}
		
		//职业
		BasicData[] jobs = BasicDataService.getInstant().getJobs();
		cbJob.add("");
		for(BasicData bd : jobs){
			cbJob.add(bd.getName());
		}
		cbJob.select(0);
		//主要存款
		BasicData[] banks = BasicDataService.getInstant().getBanks();
		cbMainBank.add("");
		for(BasicData bd : banks){
			cbMainBank.add(bd.getName());
		}
		cbMainBank.select(0);
	}
	
	private Customer customer;
	private Label lblIdentify;
	private Text textRegional;
	private Combo cbJob;
	private Combo cbMainBank;
	
	/**
	 * 校验输入数据，返回错误信息，如果没有错误，返回null
	 * @return
	 */
	public String validateData(){
		String code = textArchivesID.getText();
		if(code == null || code.trim().length() == 0){
			textArchivesID.setText("");
			textArchivesID.setFocus();
			return "请输入档案号。";
		}
		
		textArchivesID.setText(code.trim());
		
		String id = textIdentify.getText();
		if(id == null || id.trim().length() == 0){
			textIdentify.setText("");
			textIdentify.setFocus();
			return "请输入身份证号。";
		}
		
		//身份证号15位或者18位
		id = id.trim();
		if(!(id.length() == 15 || id.length() == 18)){
			return "身份证号不正确，身份证号必须是15位或18位。";
		}
		textIdentify.setText(id.trim());
		
		
		String name = textName.getText();
		if(name == null || name.trim().length() == 0){
			textName.setText("");
			textName.setFocus();
			return "请输入姓名。";
		}
		textName.setText(name.trim());
		
//		int year = dtBirthday.getYear();
//		if(year > 2000){
//			dtBirthday.setFocus();
//			return "请输入生日。";
//		}
		
		String age = textAge.getText();
		if(age == null || age.length() < 2){
			textAddress.setFocus();
			return "请输入年龄。";
		}
		
		if(textRegional.getData() == null){
			return "请选择行政区划。";
		}
		
		String address = textAddress.getText();
		if(address == null || address.trim().length() < 1){
			textAddress.setText("");
			textAddress.setFocus();
			return "请输入地址。";
		}
		
		//全部校验通过，返回null
		return null;
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public Customer getModifingCustomer(){
		return this.customer;
	}
	
	public Customer getCustomer(){
		if(this.customer == null){
			customer = new Customer();
		}
		
		customer.setAddress(textAddress.getText());
		customer.setAge(Integer.valueOf(textAge.getText()));
		customer.setArchivesID(textArchivesID.getText());
		Calendar cal = Calendar.getInstance();
		cal.set(dtBirthday.getYear(), dtBirthday.getMonth(), dtBirthday.getDay());
		customer.setBirthday(cal.getTime());
		//TODO:长度校验
		customer.setDesc(textDesc.getText());
		if(comboEducation.getSelectionIndex() > 0){
			customer.setEducation(comboEducation.getText());
		}else{
			customer.setEducation(null);
		}
		
//		customer.setEmail(textEmail.getText());
		customer.setGender(comboGender.getText());
		if(comboHealthy.getSelectionIndex() > 0){
			customer.setHealthy(comboHealthy.getText());
		}else{
			customer.setHealthy(null);
		}
		
		if(!Util.isEmpty(cbJob.getText())){
			BasicData job = BasicDataService.getInstant().getJobByName(cbJob.getText());
			customer.setJobCode(job.getCode());
		}else{
			customer.setJobCode(null);
		}
		
		if(!Util.isEmpty(cbMainBank.getText())){
			BasicData bank = BasicDataService.getInstant().getBankByName(cbMainBank.getText());
			customer.setBankCode(bank.getCode());
		}else{
			customer.setBankCode(null);
		}
		
		customer.setIdentify(textIdentify.getText());
		customer.setMarry(comboMarry.getText());
		customer.setMobilePhone(textPhone.getText());
		customer.setName(textName.getText());
		customer.setPostCode(textPostcode.getText());
		if(!Util.isEmpty(textRegional.getText()) && textRegional.getData() != null){
			Regional re = (Regional)textRegional.getData();
			customer.setRegional(re.getRegionalCode());
		}else{
			customer.setRegional(null);
		}
		customer.setTelPhone(textTell.getText());
		return customer;
	}
	
	public void setCustomer(Customer cus){
		this.customer = cus;
		if(cus == null){
			clearData();
			return;
		}
		if(!Util.isEmpty(customer.getArchivesID())){
			textArchivesID.setText(customer.getArchivesID());
		}else{
			textArchivesID.setText("");
		}
		if(!Util.isEmpty(customer.getIdentify())){
			textIdentify.setText(customer.getIdentify());
		}else{
			textIdentify.setText("");
		}
		if(!Util.isEmpty(customer.getName())){
			textName.setText(customer.getName());
		}else{
			textName.setText("");
		}
		if(customer.getAge() != null){
			textAge.setText(customer.getAge().toString());
		}else{
			textAge.setText("");
		}
		if(!Util.isEmpty(customer.getMobilePhone())){
			textPhone.setText(customer.getMobilePhone());
		}else{
			textPhone.setText("");
		}
		if(!Util.isEmpty(customer.getTelPhone())){
			textTell.setText(customer.getTelPhone());
		}else{
			textTell.setText("");
		}
//		if(!Util.isEmpty(customer.getEmail())){
//			textEmail.setText(customer.getEmail());
//		}else{
//			textEmail.setText("");
//		}
		if(!Util.isEmpty(customer.getPostCode())){
			textPostcode.setText(customer.getPostCode());
		}else{
			textPostcode.setText("");
		}
		if(!Util.isEmpty(customer.getAddress())){
			textAddress.setText(customer.getAddress());
		}else{
			textAddress.setText("");
		}
		if(!Util.isEmpty(customer.getDesc())){
			textDesc.setText(customer.getDesc());
		}else{
			textDesc.setText("");
		}
		if(!Util.isEmpty(customer.getGender())){
			comboGender.setText(customer.getGender());
		}else{
			comboGender.setText("");
		}
		if(customer.getBirthday() != null){
			UIUtil.setDate(dtBirthday, customer.getBirthday());
		}else{
			UIUtil.setDate(dtBirthday, new Date());
		}
		if(!Util.isEmpty(customer.getMarry())){
			comboMarry.setText(customer.getMarry());
		}else{
			comboMarry.setText("");
		}
		if(!Util.isEmpty(customer.getHealthy())){
			comboHealthy.setText(customer.getHealthy());
		}else{
			comboHealthy.setText("");
		}
		if(!Util.isEmpty(customer.getEducation())){
			comboEducation.setText(customer.getEducation());
		}else{
			comboEducation.setText("");
		}
		if(!Util.isEmpty(customer.getRegional())){
			Regional re = RegionalService.getInstance().getRegionalByCode(customer.getRegional());
			if(re != null){
				textRegional.setText(re.getName());
				textRegional.setData(re);
			}else{
				textRegional.setText("");
			}
		}else{
			textRegional.setText("");
		}
		
		if(!Util.isEmpty(customer.getJobCode())){
			BasicData job = BasicDataService.getInstant().getJobByCode(customer.getJobCode());
			if(job != null){
				cbJob.setText(job.getName());
			}else{
				cbJob.setText("");
			}
		}else{
			cbJob.setText("");
		}
		
		if(!Util.isEmpty(customer.getBankCode())){
			BasicData bank = BasicDataService.getInstant().getBankByCode(customer.getBankCode());
			if(bank != null){
				cbMainBank.setText(bank.getName());
			}else{
				cbMainBank.setText("");
			}
		}else{
			cbMainBank.setText("");
		}
	}
	
	private void clearData(){
		textArchivesID.setText("");
		textIdentify.setText("");
		textName.setText("");
		textAge.setText("");
		textPhone.setText("");
		textTell.setText("");
//		textEmail.setText("");
		textPostcode.setText("");
		textAddress.setText("");
		textDesc.setText("");
		Point selPoint = new Point(0, 0);
		comboGender.setSelection(selPoint);
		Calendar cal = Calendar.getInstance();
		dtBirthday.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		comboMarry.setSelection(selPoint);
		comboHealthy.setSelection(selPoint);
		comboEducation.setSelection(selPoint);
		cbJob.setText("");
		cbMainBank.setText("");
		
		textArchivesID.setFocus();
	}
}
