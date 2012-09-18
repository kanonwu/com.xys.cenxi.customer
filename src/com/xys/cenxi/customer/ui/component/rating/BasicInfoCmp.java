package com.xys.cenxi.customer.ui.component.rating;

import java.math.BigDecimal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.xys.cenxi.customer.data.IncomeService;
import com.xys.cenxi.customer.pojo.Customer;
import com.xys.cenxi.customer.util.Util;

public class BasicInfoCmp extends Composite {
	private Text textName;
	private Text textAddress;
	private Text textIdentify;
	private Text textGuarantee;
	private Text textTotalMoney;
	private Text textLoadMoney;
	private Text textNetAsset;
	private Text textYearIncome;
	private Text textYearOutput;
	private Text textYearNetIncome;
	private Text textProduction;
	private Text textScale;
	private Text textOwnFund;
	private Text textLoadScale;
	private Text textOwnScale;
	private Combo cpIsMember;
	private Combo cbHabit;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public BasicInfoCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		group = new Group(this, SWT.NONE);
		group.setText("\u88AB\u8BC4\u519C\u6237\u57FA\u672C\u4FE1\u606F");
		group.setLayout(new GridLayout(10, false));
		
		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("\u59D3\u540D\uFF1A");
		
		textName = new Text(group, SWT.BORDER);
		GridData gd_textName = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_textName.widthHint = 116;
		textName.setLayoutData(gd_textName);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u5730\u5740\uFF1A");
		
		textAddress = new Text(group, SWT.BORDER);
		GridData gd_textAddress = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_textAddress.widthHint = 222;
		textAddress.setLayoutData(gd_textAddress);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		textIdentify = new Text(group, SWT.BORDER);
		GridData gd_textIdentify = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_textIdentify.widthHint = 136;
		textIdentify.setLayoutData(gd_textIdentify);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("\u662F\u5426\u793E\u5458\uFF1A");
		
		cpIsMember = new Combo(group, SWT.READ_ONLY);
		cpIsMember.setItems(new String[] {"", "\u662F", "\u5426"});
		GridData gd_cpIsMember = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_cpIsMember.widthHint = 13;
		cpIsMember.setLayoutData(gd_cpIsMember);
		cpIsMember.select(0);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1));
		label_4.setText("\u4E2A\u4EBA\u53CA\u5BB6\u5EAD\u6210\u5458\u6709\u65E0\u4E0D\u826F\u55DC\u597D\u6216\u4E60\u60EF\uFF1A");
		
		cbHabit = new Combo(group, SWT.READ_ONLY);
		cbHabit.setItems(new String[] {"", "\u6709", "\u65E0"});
		GridData gd_cbHabit = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_cbHabit.widthHint = 23;
		cbHabit.setLayoutData(gd_cbHabit);
		cbHabit.select(0);
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_5.setText("\u4E2A\u4EBA\u4FE1\u7528\u72B6\u51B5\uFF1A");
		
		Combo cbCreditCnd = new Combo(group, SWT.READ_ONLY);
		cbCreditCnd.setItems(new String[] {"", "\u826F\u597D", "\u4E00\u822C", "\u8F83\u5DEE"});
		GridData gd_cbCreditCnd = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_cbCreditCnd.widthHint = 56;
		cbCreditCnd.setLayoutData(gd_cbCreditCnd);
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setAlignment(SWT.RIGHT);
		label_6.setText("\u5BF9\u5916\u62C5\u4FDD\u4F59\u989D(\u4E07\u5143)\uFF1A");
		
		textGuarantee = new Text(group, SWT.BORDER);
		textGuarantee.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		label_7.setText("\u5BB6\u5EAD\u603B\u8D44\u4EA7(\u4E07\u5143)\uFF1A");
		
		textTotalMoney = new Text(group, SWT.BORDER);
		textTotalMoney.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_8 = new Label(group, SWT.NONE);
		GridData gd_label_8 = new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1);
		gd_label_8.heightHint = 22;
		label_8.setLayoutData(gd_label_8);
		label_8.setText("\u5BB6\u5EAD\u603B\u8D1F\u503A(\u4E07\u5143)\uFF1A");
		
		textLoadMoney = new Text(group, SWT.BORDER);
		GridData gd_textLoadMoney = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_textLoadMoney.widthHint = 87;
		textLoadMoney.setLayoutData(gd_textLoadMoney);
		
		Label label_9 = new Label(group, SWT.NONE);
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_9.setText("\u5BB6\u5EAD\u51C0\u8D44\u4EA7(\u4E07\u5143):");
		
		textNetAsset = new Text(group, SWT.BORDER);
		textNetAsset.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_10 = new Label(group, SWT.NONE);
		label_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		label_10.setText("\u5BB6\u5EAD\u5E74\u6536\u5165(\u4E07\u5143)\uFF1A");
		
		textYearIncome = new Text(group, SWT.BORDER);
		textYearIncome.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_11.setText("\u5BB6\u5EAD\u5E74\u652F\u51FA(\u4E07\u5143)\uFF1A");
		
		textYearOutput = new Text(group, SWT.BORDER);
		textYearOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_12 = new Label(group, SWT.NONE);
		label_12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_12.setText("\u5BB6\u5EAD\u5E74\u7EAF\u6536\u5165(\u4E07\u5143):");
		
		textYearNetIncome = new Text(group, SWT.BORDER);
		textYearNetIncome.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_13 = new Label(group, SWT.NONE);
		label_13.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label_13.setText("\u751F\u4EA7\u7ECF\u8425\u670D\u52A1\u5185\u5BB9\uFF1A");
		
		textProduction = new Text(group, SWT.BORDER);
		textProduction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_14 = new Label(group, SWT.WRAP);
		GridData gd_label_14 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label_14.widthHint = 74;
		gd_label_14.heightHint = 37;
		label_14.setLayoutData(gd_label_14);
		label_14.setText("\u751F\u4EA7\u7ECF\u8425\u8D44\u91D1\u89C4\u6A21(\u4E07\u5143)\uFF1A");
		
		textScale = new Text(group, SWT.BORDER);
		textScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_15 = new Label(group, SWT.NONE);
		label_15.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_15.setText("\u751F\u4EA7\u81EA\u6709\u8D44\u91D1(\u4E07\u5143):");
		
		textOwnFund = new Text(group, SWT.BORDER);
		textOwnFund.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_16 = new Label(group, SWT.WRAP);
		GridData gd_label_16 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label_16.widthHint = 95;
		gd_label_16.heightHint = 38;
		label_16.setLayoutData(gd_label_16);
		label_16.setText("\u5BB6\u5EAD\u8D1F\u503A\u5360\u5BB6\u5EAD\u5E74\u7EAF\u6536\u5165\u6BD4\u4F8B(%):");
		
		textLoadScale = new Text(group, SWT.BORDER);
		textLoadScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_17 = new Label(group, SWT.WRAP);
		GridData gd_label_17 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label_17.widthHint = 102;
		label_17.setLayoutData(gd_label_17);
		label_17.setText("\u81EA\u6709\u8D44\u91D1\u5360\u751F\u4EA7\u6240\u9700\u8D44\u91D1\u6BD4\u4F8B(%):");
		
		textOwnScale = new Text(group, SWT.BORDER);
		textOwnScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private Customer customer;
	private Group group;
	
	public void setCustomer(Customer cus){
		this.customer = cus;
		
		if(this.customer == null){
			clearData();
			return;
		}else{
			setData(customer);
		}
	}
	
	private void setText(Text text, String str){
		if(Util.isEmpty(str)){
			text.setText("");
		}else{
			text.setText(str);
		}
	}
	
	private void setData(Customer cus){
		setText(textName, cus.getName());
		setText(textAddress, cus.getAddress());
		setText(textIdentify, cus.getIdentify());
		//家庭总资产
		BigDecimal total = IncomeService.getInstance().getTotalCapital(cus.getRowID());
		textTotalMoney.setText(Util.toPlainString(total));
		//TODO:家庭总负债没有数据,家庭净资产没有数据
		textLoadMoney.setText("");
		textNetAsset.setText("");
		//家庭年收入
		BigDecimal yearIncome = IncomeService.getInstance().getFamilyTotalIncome(cus.getRowID());
		textYearIncome.setText(Util.toPlainString(yearIncome));
		BigDecimal yearOutput = IncomeService.getInstance().getTotalOutput(cus.getRowID());
		textYearOutput.setText(Util.toPlainString(yearOutput));
		//纯收入
		BigDecimal netIncome = IncomeService.getInstance().getFamilyNetIncome(cus.getRowID());
		textYearNetIncome.setText(Util.toPlainString(netIncome));
		
		//TODO:生产经营的数据还没有
		
	}

	private void clearData() {
		Control[] ctrls = group.getChildren();
		for(Control c : ctrls){
			if(c instanceof Text){
				Text text = (Text) c;
				text.setText("");
			}else if(c instanceof Combo){
				Combo co = (Combo) c;
				co.setText("");
			}
		}
	}
}
