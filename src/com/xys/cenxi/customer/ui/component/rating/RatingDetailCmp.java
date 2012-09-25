package com.xys.cenxi.customer.ui.component.rating;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.xys.cenxi.customer.data.RatingService;
import com.xys.cenxi.customer.pojo.Customer;
import com.xys.cenxi.customer.pojo.RateConclusion;
import com.xys.cenxi.customer.pojo.RateResult;
import com.xys.cenxi.customer.pojo.Rating;
import com.xys.cenxi.customer.util.UIUtil;
import com.xys.cenxi.customer.util.Util;

public class RatingDetailCmp extends Composite {
	private Text cpTotal;
	private Text fpTotal;
	private Text cpName;
	private Text cpAdvise;
	private Text fpName;
	private Text fpAdvise;
	private Combo cp1;
	private Combo fp1;
	private Combo fp3;
	private Combo cp3;
	private Combo cp2;
	private Combo fp2;
	private Combo cp4;
	private Combo fp4;
	private Combo cp5;
	private Combo fp5;
	private Combo cp6;
	private Combo fp6;
	private Combo fp7;
	private Combo cp7;
	private Combo cp8;
	private Combo fp8;
	private Combo cp9;
	private Combo fp9;
	private Combo cp10;
	private Combo fp10;
	private Combo cp11;
	private Combo fp11;
	private Combo cp12;
	private Combo fp12;
	private Combo cp13;
	private Combo cp14;
	private Combo fp14;
	private Combo cp15;
	private Combo fp15;
	private Combo fp16;
	private Combo cp17;
	private Combo cp18;
	private Combo fp18;
	private DateTime fpDate;
	private DateTime cpDate;
	private Combo cpLevel;
	private Combo fpLevel;
	private Combo fp17;
	private Combo cp16;
	private Combo fp13;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RatingDetailCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		group1 = new Group(composite, SWT.NONE);
		group1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		group1.setText("\u6807\u51C6\u53CA\u8BC4\u5206");
		group1.setLayout(new GridLayout(12, false));
		GridData gd_group1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_group1.heightHint = 1756;
		group1.setLayoutData(gd_group1);
		
		Label label = new Label(group1, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label.setAlignment(SWT.CENTER);
		GridData gd_label = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 54;
		label.setLayoutData(gd_label);
		label.setText("\u5E8F\u53F7");
		new Label(group1, SWT.NONE);
		
		Label label_1 = new Label(group1, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_1.setAlignment(SWT.CENTER);
		label_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u9879\u76EE");
		new Label(group1, SWT.NONE);
		
		Label label_2 = new Label(group1, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_2.setAlignment(SWT.CENTER);
		label_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_2.setText("\u6307\u6807\u540D\u79F0");
		
		Label label_3 = new Label(group1, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_3.setText("\u8BA1\u5206\u6807\u51C6");
		
		Label label_4 = new Label(group1, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_4.setAlignment(SWT.CENTER);
		label_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_4.setText("\u5206\u503C");
		new Label(group1, SWT.NONE);
		
		Label label_5 = new Label(group1, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_5.setAlignment(SWT.CENTER);
		GridData gd_label_5 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_label_5.widthHint = 45;
		label_5.setLayoutData(gd_label_5);
		label_5.setText("\u521D\u8BC4");
		
		Label label_6 = new Label(group1, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_6.setAlignment(SWT.CENTER);
		GridData gd_label_6 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_label_6.widthHint = 44;
		label_6.setLayoutData(gd_label_6);
		label_6.setText("\u590D\u8BC4");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_13 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 12, 1));
		
		Label label_7 = new Label(group1, SWT.NONE);
		label_7.setAlignment(SWT.CENTER);
		label_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		label_7.setText("1");
		
		Label label_70 = new Label(group1, SWT.SEPARATOR | SWT.VERTICAL);
		label_70.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 81));
		new Label(group1, SWT.NONE);
		
		Label label_69 = new Label(group1, SWT.SEPARATOR | SWT.VERTICAL);
		label_69.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 81));
		
		Label label_8 = new Label(group1, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_8.setText("\u6237\u53E3\u6027\u8D28");
		
		Label label_9 = new Label(group1, SWT.NONE);
		label_9.setText("\u5E38\u4F4F\u4EBA\u53E3");
		
		Label label_11 = new Label(group1, SWT.NONE);
		label_11.setText("3");
		new Label(group1, SWT.NONE);
		
		cp1 = new Combo(group1, SWT.READ_ONLY);
		cp1.setItems(new String[] {"", "3", "0"});
		cp1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		cp1.select(0);
		
		fp1 = new Combo(group1, SWT.READ_ONLY);
		fp1.setItems(new String[] {"", "3", "0"});
		fp1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		fp1.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_10 = new Label(group1, SWT.NONE);
		label_10.setText("\u4E0D\u662F\u5E38\u4F4F\u4EBA\u53E3");
		
		Label label_12 = new Label(group1, SWT.NONE);
		label_12.setAlignment(SWT.CENTER);
		label_12.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_110 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_110.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group1, SWT.NONE);
		
		Label label_15 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_14 = new Label(group1, SWT.NONE);
		label_14.setAlignment(SWT.CENTER);
		label_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		label_14.setText("2");
		
		Label label_16 = new Label(group1, SWT.NONE);
		label_16.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 19));
		label_16.setText("\u57FA\u672C\u60C5\u51B520\u5206");
		
		Label label_17 = new Label(group1, SWT.NONE);
		label_17.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_17.setText("\u5E74\u9F84");
		
		Label label_18 = new Label(group1, SWT.NONE);
		label_18.setText("18\u201425\u5C81");
		
		Label label_19 = new Label(group1, SWT.NONE);
		label_19.setText("2");
		new Label(group1, SWT.NONE);
		
		cp2 = new Combo(group1, SWT.READ_ONLY);
		cp2.setItems(new String[] {"", "2", "3", "5"});
		cp2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		cp2.select(0);
		
		fp2 = new Combo(group1, SWT.READ_ONLY);
		fp2.setItems(new String[] {"", "2", "3", "5"});
		fp2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		fp2.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_20 = new Label(group1, SWT.NONE);
		label_20.setText("26\u201430\u5C81");
		
		Label label_21 = new Label(group1, SWT.NONE);
		label_21.setText("3");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_22 = new Label(group1, SWT.NONE);
		label_22.setText("31\u201445\u5C81");
		
		Label label_23 = new Label(group1, SWT.NONE);
		label_23.setText("5");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_24 = new Label(group1, SWT.NONE);
		label_24.setText("46\u201450\u5C81");
		
		Label label_25 = new Label(group1, SWT.NONE);
		label_25.setText("3");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_26 = new Label(group1, SWT.NONE);
		label_26.setText("50\u5C81\u4EE5\u4E0A");
		
		Label label_27 = new Label(group1, SWT.NONE);
		label_27.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_111 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_111.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_28 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_28.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_54 = new Label(group1, SWT.NONE);
		label_54.setAlignment(SWT.CENTER);
		label_54.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_54.setText("3");
		
		Label label_44 = new Label(group1, SWT.NONE);
		label_44.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_44.setText("\u5A5A\u59FB\u72B6\u51B5");
		
		Label label_45 = new Label(group1, SWT.NONE);
		label_45.setText("\u5DF2\u5A5A");
		
		Label label_50 = new Label(group1, SWT.NONE);
		label_50.setText("4");
		new Label(group1, SWT.NONE);
		
		cp3 = new Combo(group1, SWT.READ_ONLY);
		cp3.setItems(new String[] {"", "4", "3", "2", "1"});
		cp3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		cp3.select(0);
		
		fp3 = new Combo(group1, SWT.READ_ONLY);
		fp3.setItems(new String[] {"", "4", "3", "2", "1"});
		fp3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		fp3.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_46 = new Label(group1, SWT.NONE);
		label_46.setText("\u672A\u5A5A");
		
		Label label_51 = new Label(group1, SWT.NONE);
		label_51.setText("3");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_47 = new Label(group1, SWT.NONE);
		label_47.setText("\u4E27\u5076");
		
		Label label_52 = new Label(group1, SWT.NONE);
		label_52.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_48 = new Label(group1, SWT.NONE);
		label_48.setText("\u79BB\u5F02");
		
		Label label_53 = new Label(group1, SWT.NONE);
		label_53.setText("1");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_112 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_112.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_49 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_49.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_55 = new Label(group1, SWT.NONE);
		label_55.setAlignment(SWT.CENTER);
		label_55.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		label_55.setText("4");
		
		Label label_29 = new Label(group1, SWT.NONE);
		label_29.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));
		label_29.setText("\u8EAB\u4F53\u5065\u5EB7\u72B6\u51B5");
		
		Label label_30 = new Label(group1, SWT.NONE);
		label_30.setText("\u826F\u597D");
		
		Label label_31 = new Label(group1, SWT.NONE);
		label_31.setText("3");
		new Label(group1, SWT.NONE);
		
		cp4 = new Combo(group1, SWT.READ_ONLY);
		cp4.setItems(new String[] {"", "3", "2", "0"});
		cp4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		cp4.select(0);
		
		fp4 = new Combo(group1, SWT.READ_ONLY);
		fp4.setItems(new String[] {"", "3", "2", "0"});
		fp4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		fp4.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_32 = new Label(group1, SWT.NONE);
		label_32.setText("\u4E00\u822C");
		
		Label label_33 = new Label(group1, SWT.NONE);
		label_33.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_34 = new Label(group1, SWT.NONE);
		label_34.setText("\u5DEE");
		
		Label label_35 = new Label(group1, SWT.NONE);
		label_35.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_113 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_113.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_36 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_36.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_56 = new Label(group1, SWT.NONE);
		label_56.setAlignment(SWT.CENTER);
		label_56.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		label_56.setText("5");
		
		Label label_37 = new Label(group1, SWT.NONE);
		label_37.setText("\u6587\u5316\u7A0B\u5EA6");
		
		Label label_38 = new Label(group1, SWT.NONE);
		label_38.setText("\u5927\u4E13\u4EE5\u4E0A");
		
		Label label_41 = new Label(group1, SWT.NONE);
		label_41.setText("5");
		new Label(group1, SWT.NONE);
		
		cp5 = new Combo(group1, SWT.READ_ONLY);
		cp5.setItems(new String[] {"", "5", "2", "1"});
		cp5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		cp5.select(0);
		
		fp5 = new Combo(group1, SWT.READ_ONLY);
		fp5.setItems(new String[] {"", "5", "2", "1"});
		fp5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		fp5.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_39 = new Label(group1, SWT.NONE);
		label_39.setText("\u521D\u4E2D\u4EE5\u4E0A");
		
		Label lblNewLabel = new Label(group1, SWT.NONE);
		lblNewLabel.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_40 = new Label(group1, SWT.NONE);
		label_40.setText("\u521D\u4E2D\u4EE5\u4E0B");
		
		Label label_42 = new Label(group1, SWT.NONE);
		label_42.setText("1");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_109 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_109.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_108 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_108.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_43 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_43.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_57 = new Label(group1, SWT.NONE);
		label_57.setAlignment(SWT.CENTER);
		label_57.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		label_57.setText("6");
		
		Label label_58 = new Label(group1, SWT.NONE);
		label_58.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 27));
		label_58.setText("\u507F\u503A\u80FD\u529B40\u5206");
		
		Label label_59 = new Label(group1, SWT.NONE);
		label_59.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_59.setText("\u5BB6\u5EAD\u603B\u8D44\u4EA7");
		
		Label lblNewLabel_1 = new Label(group1, SWT.NONE);
		lblNewLabel_1.setText("20\u4E07\u5143(\u542B)\u4EE5\u4E0A");
		
		Label label_63 = new Label(group1, SWT.NONE);
		label_63.setText("7");
		new Label(group1, SWT.NONE);
		
		cp6 = new Combo(group1, SWT.READ_ONLY);
		cp6.setItems(new String[] {"", "7", "6", "5", "4", "3"});
		cp6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		cp6.select(0);
		
		fp6 = new Combo(group1, SWT.READ_ONLY);
		fp6.setItems(new String[] {"", "7", "6", "5", "4", "3"});
		fp6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		fp6.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_60 = new Label(group1, SWT.NONE);
		label_60.setText("15\u4E07\u5143(\u542B) \u2014 20\u4E07\u5143");
		
		Label label_64 = new Label(group1, SWT.NONE);
		label_64.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_61 = new Label(group1, SWT.NONE);
		label_61.setText("10\u4E07\u5143(\u542B)\u201415\u4E07\u5143");
		
		Label label_65 = new Label(group1, SWT.NONE);
		label_65.setText("5");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(group1, SWT.NONE);
		lblNewLabel_2.setText("5\u4E07\u5143(\u542B) \u2014 10\u4E07\u5143");
		
		Label label_66 = new Label(group1, SWT.NONE);
		label_66.setText("4");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_62 = new Label(group1, SWT.NONE);
		label_62.setText("5\u4E07\u5143\u4EE5\u4E0B");
		
		Label label_67 = new Label(group1, SWT.NONE);
		label_67.setText("3");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_115 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_115.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_68 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_68.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_116 = new Label(group1, SWT.NONE);
		label_116.setAlignment(SWT.CENTER);
		label_116.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		label_116.setText("7");
		
		Label label_71 = new Label(group1, SWT.NONE);
		label_71.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_71.setText("\u5BB6\u5EAD\u603B\u8D1F\u503A");
		
		Label label_72 = new Label(group1, SWT.NONE);
		label_72.setText("1\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_77 = new Label(group1, SWT.NONE);
		label_77.setText("5");
		new Label(group1, SWT.NONE);
		
		cp7 = new Combo(group1, SWT.READ_ONLY);
		cp7.setItems(new String[] {"", "5", "4", "3", "2", "1"});
		cp7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		cp7.select(0);
		
		fp7 = new Combo(group1, SWT.READ_ONLY);
		fp7.setItems(new String[] {"", "5", "4", "3", "2", "1"});
		fp7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		fp7.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_73 = new Label(group1, SWT.NONE);
		label_73.setText("1 \u2014 2\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_78 = new Label(group1, SWT.NONE);
		label_78.setText("4");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_74 = new Label(group1, SWT.NONE);
		label_74.setText("2 \u2014 5\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_79 = new Label(group1, SWT.NONE);
		label_79.setText("3");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_75 = new Label(group1, SWT.NONE);
		label_75.setText("5 \u2014 10\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_80 = new Label(group1, SWT.NONE);
		label_80.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_76 = new Label(group1, SWT.NONE);
		label_76.setText("10\u4E07\u5143\u4EE5\u4E0A");
		
		Label label_81 = new Label(group1, SWT.NONE);
		label_81.setText("1");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_114 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_114.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_82 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_82.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_117 = new Label(group1, SWT.NONE);
		label_117.setAlignment(SWT.CENTER);
		label_117.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_117.setText("8");
		
		Label label_83 = new Label(group1, SWT.NONE);
		label_83.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_83.setText("\u751F\u4EA7\u7ECF\u8425\u89C4\u6A21");
		
		Label label_84 = new Label(group1, SWT.NONE);
		label_84.setText("10\u4E07\u5143(\u542B)\u4EE5\u4E0A");
		
		Label label_87 = new Label(group1, SWT.NONE);
		label_87.setText("8");
		new Label(group1, SWT.NONE);
		
		cp8 = new Combo(group1, SWT.READ_ONLY);
		cp8.setItems(new String[] {"", "8", "7", "6", "5"});
		cp8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		cp8.select(0);
		
		fp8 = new Combo(group1, SWT.READ_ONLY);
		fp8.setItems(new String[] {"", "8", "7", "6", "5"});
		fp8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		fp8.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_85 = new Label(group1, SWT.NONE);
		label_85.setText("5\u4E07\u5143(\u542B) \u2014 10\u4E07\u5143");
		
		Label label_88 = new Label(group1, SWT.NONE);
		label_88.setText("7");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_3 = new Label(group1, SWT.NONE);
		lblNewLabel_3.setText("3\u4E07\u5143(\u542B) \u2014 5\u4E07\u5143");
		
		Label label_89 = new Label(group1, SWT.NONE);
		label_89.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_86 = new Label(group1, SWT.NONE);
		label_86.setText("3\u4E07\u5143\u4EE5\u4E0B");
		
		Label label_90 = new Label(group1, SWT.NONE);
		label_90.setText("5");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_118 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_118.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_91 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_91.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_119 = new Label(group1, SWT.NONE);
		label_119.setAlignment(SWT.CENTER);
		label_119.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_119.setText("9");
		
		Label label_92 = new Label(group1, SWT.WRAP);
		GridData gd_label_92 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4);
		gd_label_92.widthHint = 90;
		label_92.setLayoutData(gd_label_92);
		label_92.setText("\u6700\u8FD13\u5E74\u5BB6\u5EAD\u5E74\u5E73\u5747\u7EAF\u6536\u5165");
		
		Label label_93 = new Label(group1, SWT.NONE);
		label_93.setText("3\u4E07\u5143(\u542B)\u4EE5\u4E0A");
		
		Label label_97 = new Label(group1, SWT.NONE);
		label_97.setText("10");
		new Label(group1, SWT.NONE);
		
		cp9 = new Combo(group1, SWT.READ_ONLY);
		cp9.setItems(new String[] {"", "10", "8", "6", "5"});
		cp9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		cp9.select(0);
		
		fp9 = new Combo(group1, SWT.READ_ONLY);
		fp9.setItems(new String[] {"", "10", "8", "6", "5"});
		fp9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		fp9.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_94 = new Label(group1, SWT.NONE);
		label_94.setText("2\u4E07\u5143(\u542B) \u2014 3\u4E07\u5143");
		
		Label label_98 = new Label(group1, SWT.NONE);
		label_98.setText("8");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_95 = new Label(group1, SWT.NONE);
		label_95.setText("1\u4E07\u5143(\u542B) \u2014 2\u4E07\u5143");
		
		Label label_99 = new Label(group1, SWT.NONE);
		label_99.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_96 = new Label(group1, SWT.NONE);
		label_96.setText("1\u4E07\u5143\u4EE5\u4E0B");
		
		Label label_100 = new Label(group1, SWT.NONE);
		label_100.setText("5");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_120 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_120.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_101 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_101.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_121 = new Label(group1, SWT.NONE);
		label_121.setAlignment(SWT.CENTER);
		label_121.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		label_121.setText("10");
		
		Label label_102 = new Label(group1, SWT.WRAP);
		GridData gd_label_102 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5);
		gd_label_102.widthHint = 91;
		label_102.setLayoutData(gd_label_102);
		label_102.setText("\u751F\u4EA7\u7ECF\u8425\u81EA\u6709\u8D44\u91D1\u6BD4\u4F8B");
		
		Label label_103 = new Label(group1, SWT.NONE);
		label_103.setText("50%(\u542B)\u4EE5\u4E0A");
		
		Label label_122 = new Label(group1, SWT.NONE);
		label_122.setText("10");
		new Label(group1, SWT.NONE);
		
		cp10 = new Combo(group1, SWT.READ_ONLY);
		cp10.setItems(new String[] {"", "10", "8", "6", "3", "0"});
		cp10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		cp10.select(0);
		
		fp10 = new Combo(group1, SWT.READ_ONLY);
		fp10.setItems(new String[] {"", "10", "8", "6", "3", "0"});
		fp10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		fp10.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_104 = new Label(group1, SWT.NONE);
		label_104.setText("40%(\u542B) \u2014 50%");
		
		Label label_123 = new Label(group1, SWT.NONE);
		label_123.setText("8");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_105 = new Label(group1, SWT.NONE);
		label_105.setText("30%(\u542B) \u2014 40%");
		
		Label label_124 = new Label(group1, SWT.NONE);
		label_124.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_106 = new Label(group1, SWT.NONE);
		label_106.setText("0(\u4E0D\u542B) \u2014 30%");
		
		Label label_125 = new Label(group1, SWT.NONE);
		label_125.setText("3");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_107 = new Label(group1, SWT.NONE);
		label_107.setText("\u81EA\u6709\u8D44\u91D1\u4E3A0\u4E07\u5143");
		
		Label label_126 = new Label(group1, SWT.NONE);
		label_126.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_128 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_128.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_130 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_130.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_127 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_127.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_159 = new Label(group1, SWT.NONE);
		label_159.setAlignment(SWT.CENTER);
		label_159.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_159.setText("11");
		
		Label label_129 = new Label(group1, SWT.NONE);
		label_129.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_129.setText("\u54C1\u8D2810\u5206");
		
		Label label_131 = new Label(group1, SWT.NONE);
		label_131.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_131.setText("\u519C\u6237\u7684\u54C1\u8D28");
		
		Label label_132 = new Label(group1, SWT.NONE);
		label_132.setText("\u54C1\u884C\u826F\u597D\uFF0C\u52E4\u52B3\uFF0C\u793E\u4F1A\u53CD\u6620\u597D");
		
		Label label_135 = new Label(group1, SWT.NONE);
		label_135.setText("10");
		new Label(group1, SWT.NONE);
		
		cp11 = new Combo(group1, SWT.READ_ONLY);
		cp11.setItems(new String[] {"", "10", "8", "6", "0"});
		cp11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		cp11.select(0);
		
		fp11 = new Combo(group1, SWT.READ_ONLY);
		fp11.setItems(new String[] {"", "10", "8", "6", "0"});
		fp11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		fp11.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_133 = new Label(group1, SWT.NONE);
		label_133.setText("\u54C1\u884C\u8F83\u597D\uFF0C\u52E4\u52B3\uFF0C\u793E\u4F1A\u53CD\u6620\u8F83\u597D");
		
		Label label_136 = new Label(group1, SWT.NONE);
		label_136.setText("8");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_134 = new Label(group1, SWT.NONE);
		label_134.setText("\u54C1\u884C\u4E00\u822C\uFF0C\u80AF\u52B3\u52A8\uFF0C\u793E\u4F1A\u53CD\u6620\u5C1A\u53EF");
		
		Label label_137 = new Label(group1, SWT.NONE);
		label_137.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(group1, SWT.WRAP);
		GridData gd_lblNewLabel_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_4.widthHint = 201;
		gd_lblNewLabel_4.heightHint = 56;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);
		lblNewLabel_4.setText("\u81EA\u8EAB\u65E0\u4E0D\u826F\u55DC\u597D\u4E60\u60EF\uFF0C\u4F46\u5BB6\u5EAD\u4E3B\u8981\u6210\u5458\u6709\u9EC4\u8D4C\u6BD2\u7B49\u4E0D\u826F\u55DC\u597D\u6216\u597D\u9038\u6076\u52B3\u7B49\u4E0D\u826F\u4E60\u60EF\uFF0C\u793E\u4F1A\u53CD\u6620\u8F83\u5DEE");
		
		Label label_138 = new Label(group1, SWT.NONE);
		label_138.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_160 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_160.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label label_139 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_139.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_140 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_140.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_162 = new Label(group1, SWT.NONE);
		label_162.setAlignment(SWT.CENTER);
		label_162.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		label_162.setText("12");
		
		Label label_141 = new Label(group1, SWT.NONE);
		label_141.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 18));
		label_141.setText("\u4FE1\u7528\u7A0B\u5EA628\u5206");
		
		Label lblNewLabel_5 = new Label(group1, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_5.setText("*\u4E1A\u52A1\u5F80\u6765");
		
		Label label_142 = new Label(group1, SWT.NONE);
		label_142.setText("\u5728\u519C\u5408\u94F6\u884C\u6709\u7ED3\u7B97\u8D26\u6237,\u4E3B\u8981\u5B58\u6B3E\u662F\u5426\u5728\u519C\u5408\u94F6\u884C");
		
		Label label_185 = new Label(group1, SWT.NONE);
		label_185.setText("4");
		new Label(group1, SWT.NONE);
		
		cp12 = new Combo(group1, SWT.READ_ONLY);
		cp12.setItems(new String[] {"", "4", "2"});
		cp12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		cp12.select(0);
		
		fp12 = new Combo(group1, SWT.READ_ONLY);
		fp12.setItems(new String[] {"", "4", "2"});
		fp12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		fp12.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_143 = new Label(group1, SWT.NONE);
		label_143.setText("\u5728\u519C\u5408\u94F6\u884C\u65E0\u7ED3\u7B97\u8D26\u6237");
		
		Label label_186 = new Label(group1, SWT.NONE);
		label_186.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_161 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_161.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_144 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_144.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_163 = new Label(group1, SWT.NONE);
		label_163.setAlignment(SWT.CENTER);
		label_163.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		label_163.setText("13");
		
		Label label_145 = new Label(group1, SWT.NONE);
		label_145.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_145.setText("*\u80A1\u91D1\u72B6\u51B5");
		
		Label label_146 = new Label(group1, SWT.NONE);
		label_146.setText("\u6709\u80A1\u91D1");
		
		Label label_187 = new Label(group1, SWT.NONE);
		label_187.setText("3");
		new Label(group1, SWT.NONE);
		
		cp13 = new Combo(group1, SWT.READ_ONLY);
		cp13.setItems(new String[] {"", "3", "2"});
		cp13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		cp13.select(0);
		
		fp13 = new Combo(group1, SWT.READ_ONLY);
		fp13.setItems(new String[] {"", "3", "2"});
		fp13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		fp13.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_6 = new Label(group1, SWT.NONE);
		lblNewLabel_6.setText("\u65E0\u80A1\u91D1");
		
		Label label_188 = new Label(group1, SWT.NONE);
		label_188.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_164 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_164.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_147 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_147.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_165 = new Label(group1, SWT.NONE);
		label_165.setAlignment(SWT.CENTER);
		label_165.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_165.setText("14");
		
		Label label_148 = new Label(group1, SWT.NONE);
		label_148.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_148.setText("*\u4E2A\u4EBA\u4FE1\u7528\u8BB0\u5F55");
		
		Label label_149 = new Label(group1, SWT.NONE);
		label_149.setText("\u6709\u501F\u6B3E\u65E0\u4E0D\u826F\u8BB0\u5F55");
		
		Label label_189 = new Label(group1, SWT.NONE);
		label_189.setText("10");
		new Label(group1, SWT.NONE);
		
		cp14 = new Combo(group1, SWT.READ_ONLY);
		cp14.setItems(new String[] {"", "10", "8", "6", "0"});
		cp14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		cp14.select(0);
		
		fp14 = new Combo(group1, SWT.READ_ONLY);
		fp14.setItems(new String[] {"", "10", "8", "6", "0"});
		fp14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		fp14.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_150 = new Label(group1, SWT.NONE);
		label_150.setText("\u4ECE\u672A\u501F\u6B3E");
		
		Label label_190 = new Label(group1, SWT.NONE);
		label_190.setText("8");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_7 = new Label(group1, SWT.NONE);
		lblNewLabel_7.setText("\u6709\u4E0D\u826F\u8BB0\u5F55\uFF0C\u65E0\u6076\u610F\u4E0D\u826F\u8BB0\u5F55");
		
		Label label_191 = new Label(group1, SWT.NONE);
		label_191.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_151 = new Label(group1, SWT.NONE);
		label_151.setText("\u6709\u4E0D\u826F\u8BB0\u5F55\uFF0C\u662F\u6076\u610F\u4E0D\u826F\u8BB0\u5F55");
		
		Label label_192 = new Label(group1, SWT.NONE);
		label_192.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_166 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Label label_152 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_152.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_167 = new Label(group1, SWT.NONE);
		label_167.setAlignment(SWT.CENTER);
		label_167.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_167.setText("15");
		
		Label lblNewLabel_8 = new Label(group1, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		lblNewLabel_8.setText("\u793E\u4F1A\u4FE1\u7528");
		
		Label lblNewLabel_9 = new Label(group1, SWT.NONE);
		lblNewLabel_9.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u826F\u597D");
		
		Label label_193 = new Label(group1, SWT.NONE);
		label_193.setText("8");
		new Label(group1, SWT.NONE);
		
		cp15 = new Combo(group1, SWT.READ_ONLY);
		cp15.setItems(new String[] {"", "8", "6", "4", "0"});
		cp15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		cp15.select(0);
		
		fp15 = new Combo(group1, SWT.READ_ONLY);
		fp15.setItems(new String[] {"", "8", "6", "4", "0"});
		fp15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		fp15.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_10 = new Label(group1, SWT.NONE);
		lblNewLabel_10.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u8F83\u597D");
		
		Label label_194 = new Label(group1, SWT.NONE);
		label_194.setText("6");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_11 = new Label(group1, SWT.NONE);
		lblNewLabel_11.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u4E00\u822C");
		
		Label label_195 = new Label(group1, SWT.NONE);
		label_195.setText("4");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_12 = new Label(group1, SWT.NONE);
		lblNewLabel_12.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u8F83\u5DEE");
		
		Label label_196 = new Label(group1, SWT.NONE);
		label_196.setText("0");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_168 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Label label_153 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_153.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_169 = new Label(group1, SWT.NONE);
		label_169.setAlignment(SWT.CENTER);
		label_169.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_169.setText("16");
		
		Label lblNewLabel_13 = new Label(group1, SWT.NONE);
		lblNewLabel_13.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_13.setText("*\u662F\u5426\u662F\u4FE1\u7528\u6751\u6751\u6C11");
		
		Label lblNewLabel_14 = new Label(group1, SWT.NONE);
		lblNewLabel_14.setText("\u662F");
		
		Label label_197 = new Label(group1, SWT.NONE);
		label_197.setText("3");
		new Label(group1, SWT.NONE);
		
		cp16 = new Combo(group1, SWT.READ_ONLY);
		cp16.setItems(new String[] {"", "3", "2"});
		cp16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		cp16.select(0);
		
		fp16 = new Combo(group1, SWT.READ_ONLY);
		fp16.setItems(new String[] {"", "3", "2"});
		fp16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		fp16.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_154 = new Label(group1, SWT.NONE);
		label_154.setText("\u5426");
		
		Label label_198 = new Label(group1, SWT.NONE);
		label_198.setText("2");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_170 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_170.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_171 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_171.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_155 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_155.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_174 = new Label(group1, SWT.NONE);
		label_174.setAlignment(SWT.CENTER);
		label_174.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		label_174.setText("17");
		
		Label lblNewLabel_16 = new Label(group1, SWT.NONE);
		lblNewLabel_16.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_16.setText("\u5176\u4ED6");
		
		Label lblNewLabel_15 = new Label(group1, SWT.NONE);
		lblNewLabel_15.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_15.setText("\u53C2\u52A0\u4FDD\u9669");
		
		Label lblNewLabel_17 = new Label(group1, SWT.NONE);
		lblNewLabel_17.setText("\u53C2\u52A0");
		
		Label label_199 = new Label(group1, SWT.NONE);
		label_199.setText("2");
		new Label(group1, SWT.NONE);
		
		cp17 = new Combo(group1, SWT.READ_ONLY);
		cp17.setItems(new String[] {"", "2", "1"});
		cp17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		cp17.select(0);
		
		fp17 = new Combo(group1, SWT.READ_ONLY);
		fp17.setItems(new String[] {"", "2", "1"});
		fp17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		fp17.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_18 = new Label(group1, SWT.NONE);
		lblNewLabel_18.setText("\u4E0D\u53C2\u52A0");
		
		Label label_200 = new Label(group1, SWT.NONE);
		label_200.setText("1");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_173 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_173.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_172 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_172.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_156 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_156.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_175 = new Label(group1, SWT.NONE);
		label_175.setAlignment(SWT.CENTER);
		label_175.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_175.setText("18");
		
		Label lblNewLabel_19 = new Label(group1, SWT.NONE);
		lblNewLabel_19.setText("\u8C03\u6574\u8D4B\u5206\uFF08\u00B13\uFF09");
		new Label(group1, SWT.NONE);
		
		Label lblNewLabel_20 = new Label(group1, SWT.NONE);
		lblNewLabel_20.setText("\u8C03\u6574\u5206(\u662F\u5426\u662F\u4E00\u76F4\u652F\u6301\u6211\u4EEC\u519C\u5408\u94F6\u884C\u5404\u9879\u5DE5\u4F5C)");
		
		Label lblNewLabel_21 = new Label(group1, SWT.NONE);
		lblNewLabel_21.setText("\u00B13");
		new Label(group1, SWT.NONE);
		
		cp18 = new Combo(group1, SWT.READ_ONLY);
		cp18.setItems(new String[] {"", "3", "-3"});
		cp18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		cp18.select(0);
		
		fp18 = new Combo(group1, SWT.READ_ONLY);
		fp18.setItems(new String[] {"", "3", "-3"});
		fp18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		fp18.select(0);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_176 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_176.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_157 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_157.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_158 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_158.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 8, 1));
		
		Label label_177 = new Label(group1, SWT.NONE);
		label_177.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_177.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_177.setText("\u7EFC\u5408\u8BC4\u5206");
		
		Label label_178 = new Label(group1, SWT.NONE);
		label_178.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_178.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_178.setText("100");
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_213 = new Label(group1, SWT.SEPARATOR | SWT.VERTICAL);
		GridData gd_label_213 = new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1);
		gd_label_213.heightHint = 30;
		label_213.setLayoutData(gd_label_213);
		
		cpTotal = new Text(group1, SWT.BORDER);
		GridData gd_cpTotal = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_cpTotal.widthHint = 45;
		cpTotal.setLayoutData(gd_cpTotal);
		
		fpTotal = new Text(group1, SWT.BORDER);
		GridData gd_fpTotal = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_fpTotal.widthHint = 45;
		fpTotal.setLayoutData(gd_fpTotal);
		new Label(group1, SWT.NONE);
		new Label(group1, SWT.NONE);
		
		Label label_180 = new Label(group1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_180.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 12, 1));
		
		Composite composite_1 = new Composite(group1, SWT.NONE);
		composite_1.setLayout(new GridLayout(18, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 12, 1);
		gd_composite_1.heightHint = 79;
		composite_1.setLayoutData(gd_composite_1);
		
		Label label_179 = new Label(composite_1, SWT.NONE);
		label_179.setAlignment(SWT.CENTER);
		label_179.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		GridData gd_label_179 = new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
		gd_label_179.widthHint = 159;
		label_179.setLayoutData(gd_label_179);
		label_179.setText("\u4FE1\u7528\u7B49\u7EA7");
		
		Label label_206 = new Label(composite_1, SWT.SEPARATOR | SWT.VERTICAL);
		label_206.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 3));
		
		Label lblNewLabel_22 = new Label(composite_1, SWT.NONE);
		lblNewLabel_22.setAlignment(SWT.CENTER);
		lblNewLabel_22.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		GridData gd_lblNewLabel_22 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_22.widthHint = 73;
		lblNewLabel_22.setLayoutData(gd_lblNewLabel_22);
		lblNewLabel_22.setText("80(\u542B)\u4EE5\u4E0A");
		
		Label label_207 = new Label(composite_1, SWT.SEPARATOR | SWT.VERTICAL);
		label_207.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 3));
		
		Label label_181 = new Label(composite_1, SWT.NONE);
		label_181.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_181.setAlignment(SWT.CENTER);
		GridData gd_label_181 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_181.widthHint = 81;
		label_181.setLayoutData(gd_label_181);
		label_181.setText("70\uFF08\u542B\uFF09-80\u5206");
		
		Label label_208 = new Label(composite_1, SWT.SEPARATOR | SWT.VERTICAL);
		label_208.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));
		
		Label label_182 = new Label(composite_1, SWT.NONE);
		label_182.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_182.setAlignment(SWT.CENTER);
		GridData gd_label_182 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_182.widthHint = 88;
		label_182.setLayoutData(gd_label_182);
		label_182.setText("60\uFF08\u542B\uFF09-70\u5206");
		
		Label label_209 = new Label(composite_1, SWT.SEPARATOR | SWT.VERTICAL);
		label_209.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));
		
		Label label_183 = new Label(composite_1, SWT.NONE);
		label_183.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_183.setAlignment(SWT.CENTER);
		label_183.setText("60\u5206\u4EE5\u4E0B");
		
		Label label_210 = new Label(composite_1, SWT.SEPARATOR | SWT.VERTICAL);
		label_210.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));
		
		Label label_184 = new Label(composite_1, SWT.NONE);
		label_184.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_184.setAlignment(SWT.CENTER);
		label_184.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));
		label_184.setText("\u5F97\u5206\u7B49\u7EA7");
		
		Label label_211 = new Label(composite_1, SWT.SEPARATOR | SWT.VERTICAL);
		label_211.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 3));
		
		cpLevel = new Combo(composite_1, SWT.READ_ONLY);
		cpLevel.setItems(new String[] {"", "\u4F18\u79C0", "\u826F\u597D", "\u4E00\u822C", "\u8F83\u5DEE"});
		cpLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		cpLevel.select(0);
		
		fpLevel = new Combo(composite_1, SWT.READ_ONLY);
		fpLevel.setItems(new String[] {"", "\u4F18\u79C0", "\u826F\u597D", "\u4E00\u822C", "\u8F83\u5DEE"});
		fpLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		fpLevel.select(0);
		
		Label label_212 = new Label(composite_1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_212.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		
		Label label_201 = new Label(composite_1, SWT.NONE);
		label_201.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_201.setAlignment(SWT.CENTER);
		label_201.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		label_201.setText("\u6807\u51C6");
		
		Label label_202 = new Label(composite_1, SWT.NONE);
		label_202.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_202.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_202.setText("\u4F18\u79C0");
		
		Label label_203 = new Label(composite_1, SWT.NONE);
		label_203.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_203.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_203.setText("\u826F\u597D");
		
		Label label_204 = new Label(composite_1, SWT.NONE);
		label_204.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_204.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_204.setText("\u4E00\u822C");
		
		Label label_205 = new Label(composite_1, SWT.NONE);
		label_205.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_205.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_205.setText("\u8F83\u5DEE");
		
		group2 = new Group(composite, SWT.NONE);
		group2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		group2.setLayout(new GridLayout(4, false));
		GridData gd_group2 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_group2.heightHint = 139;
		group2.setLayoutData(gd_group2);
		group2.setText("\u8BC4\u7EA7\u610F\u89C1");
		
		Label label_214 = new Label(group2, SWT.NONE);
		label_214.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_214.setText("\u521D\u8BC4\u4EBA\uFF1A");
		
		cpName = new Text(group2, SWT.BORDER);
		GridData gd_cpName = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_cpName.widthHint = 364;
		cpName.setLayoutData(gd_cpName);
		
		Label label_216 = new Label(group2, SWT.NONE);
		label_216.setText("\u65E5\u671F\uFF1A");
		
		cpDate = new DateTime(group2, SWT.BORDER | SWT.DROP_DOWN | SWT.LONG);
		
		Label label_215 = new Label(group2, SWT.NONE);
		label_215.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_215.setText("\u521D\u8BC4\u4EBA\u610F\u89C1\uFF1A");
		
		cpAdvise = new Text(group2, SWT.BORDER);
		GridData gd_cpAdvise = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_cpAdvise.widthHint = 631;
		cpAdvise.setLayoutData(gd_cpAdvise);
		
		Label label_217 = new Label(group2, SWT.NONE);
		label_217.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_217.setText("\u590D\u8BC4\u4EBA\uFF1A");
		
		fpName = new Text(group2, SWT.BORDER);
		fpName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_218 = new Label(group2, SWT.NONE);
		label_218.setText("\u65E5\u671F\uFF1A");
		
		fpDate = new DateTime(group2, SWT.BORDER | SWT.DROP_DOWN | SWT.LONG);
		
		Label label_219 = new Label(group2, SWT.NONE);
		label_219.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_219.setText("\u590D\u8BC4\u4EBA\u610F\u89C1\uFF1A");
		
		fpAdvise = new Text(group2, SWT.BORDER);
		fpAdvise.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		addSelectListener();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private Customer customer;
	private Group group1;
	private Group group2;
	
	private RateResult rateResult;
	
	
	private FirstRatingSelectionListener frs = new FirstRatingSelectionListener();
	
	private SecondRatingSelectionListener srs = new SecondRatingSelectionListener();
	
	private void setRating(Rating rate , Combo cb){
		cb.setData(rate);
		if(rate != null && rate.getRateValue() != null){
			cb.setText(rate.getRateValue().toString());
		}else{
			cb.select(-1);
		}
	}
	
	public void setCustomer(Customer cus){
		clearData();
		this.customer = cus;
		if(this.customer != null){
			rateResult = RatingService.getInstance().getRateResult(customer.getRowID());
			setFirstRating(rateResult);
			setSecondRating(rateResult);
			int total = calFirstTotalValue();
			cpTotal.setText(String.valueOf(total));
			total = calSecondTotalValue();
			fpTotal.setText(String.valueOf(total));
			
			//ÆÀ¼¶Òâ¼û
			RateConclusion rateConclu = rateResult.getConclusion();
			setRateConclution(rateConclu);
		}
	}
	
	private void setRateConclution(RateConclusion conclu){
		if(conclu == null)
			return;
		if(!Util.isEmpty(conclu.getFirstNames())){
			cpName.setText(conclu.getFirstNames());
		}else{
			cpName.setText("");
		}
		if(!Util.isEmpty(conclu.getFirstConclusions())){
			cpAdvise.setText(conclu.getFirstConclusions());
		}else{
			cpAdvise.setText("");
		}
		if(conclu.getFirstDate() != null){
			UIUtil.setDate(cpDate, conclu.getFirstDate());
		}
		
		if(!Util.isEmpty(conclu.getSecondNames())){
			fpName.setText(conclu.getSecondNames());
		}else{
			fpName.setText("");
		}
		if(!Util.isEmpty(conclu.getSecondConclusions())){
			fpAdvise.setText(conclu.getSecondConclusions());
		}else{
			fpAdvise.setText("");
		}
		
		if(conclu.getSecondDate() != null){
			UIUtil.setDate(fpDate, conclu.getSecondDate());
		}
	}
	
	private void setFirstRating(RateResult rateResult){
		Rating rate = rateResult.getFirstValue(1);
		setRating(rate, cp1);
		rate = rateResult.getFirstValue(2);
		setRating(rate, cp2);
		rate = rateResult.getFirstValue(3);
		setRating(rate, cp3);
		rate = rateResult.getFirstValue(4);
		setRating(rate, cp4);
		rate = rateResult.getFirstValue(5);
		setRating(rate, cp5);
		rate = rateResult.getFirstValue(6);
		setRating(rate, cp6);
		rate = rateResult.getFirstValue(7);
		setRating(rate, cp7);
		rate = rateResult.getFirstValue(8);
		setRating(rate, cp8);
		rate = rateResult.getFirstValue(9);
		setRating(rate, cp9);
		rate = rateResult.getFirstValue(10);
		setRating(rate, cp10);
		rate = rateResult.getFirstValue(11);
		setRating(rate, cp11);
		rate = rateResult.getFirstValue(12);
		setRating(rate, cp12);
		rate = rateResult.getFirstValue(13);
		setRating(rate, cp13);
		rate = rateResult.getFirstValue(14);
		setRating(rate, cp14);
		rate = rateResult.getFirstValue(15);
		setRating(rate, cp15);
		rate = rateResult.getFirstValue(16);
		setRating(rate, cp16);
		rate = rateResult.getFirstValue(17);
		setRating(rate, cp17);
		rate = rateResult.getFirstValue(18);
		setRating(rate, cp18);
	}
	
	public RateResult getRateResult(){
		rateResult.setConclusion(getRateConclusion());
		return this.rateResult;
	}
	
	private RateConclusion getRateConclusion(){
		RateConclusion con = rateResult.getConclusion();
		if(con == null){
			con = new RateConclusion();
			con.setOwnerID(customer.getRowID());
		}
		
		if(!Util.isEmpty(cpName.getText())){
			con.setFirstNames(cpName.getText());
		}else{
			con.setFirstNames(null);
		}
		if(!Util.isEmpty(cpAdvise.getText())){
			con.setFirstConclusions(cpAdvise.getText());
		}else{
			con.setFirstConclusions(null);
		}
		con.setFirstDate(UIUtil.getDate(cpDate));

		if(!Util.isEmpty(fpName.getText())){
			con.setSecondNames(fpName.getText());
		}else{
			con.setSecondNames(null);
		}
		if(!Util.isEmpty(fpAdvise.getText())){
			con.setSecondConclusions(fpAdvise.getText());
		}else{
			con.setSecondConclusions(null);
		}
		con.setSecondDate(UIUtil.getDate(fpDate));
		
		if(!Util.isEmpty(cpTotal.getText())){
			con.setFirstValue(Integer.valueOf(cpTotal.getText()));
		}else{
			con.setFirstValue(null);
		}
		if(!Util.isEmpty(fpTotal.getText())){
			con.setSecondValue(Integer.valueOf(fpTotal.getText()));
		}else{
			con.setSecondValue(null);
		}
		
		return con;
	}

	private void setSecondRating(RateResult rateResult){
		Rating rate = rateResult.getSecondRating(1);
		setRating(rate, fp1);
		rate = rateResult.getSecondRating(2);
		setRating(rate, fp2);
		rate = rateResult.getSecondRating(3);
		setRating(rate, fp3);
		rate = rateResult.getSecondRating(4);
		setRating(rate, fp4);
		rate = rateResult.getSecondRating(5);
		setRating(rate, fp5);
		rate = rateResult.getSecondRating(6);
		setRating(rate, fp6);
		rate = rateResult.getSecondRating(7);
		setRating(rate, fp7);
		rate = rateResult.getSecondRating(8);
		setRating(rate, fp8);
		rate = rateResult.getSecondRating(9);
		setRating(rate, fp9);
		rate = rateResult.getSecondRating(10);
		setRating(rate, fp10);
		rate = rateResult.getSecondRating(11);
		setRating(rate, fp11);
		rate = rateResult.getSecondRating(12);
		setRating(rate, fp12);
		rate = rateResult.getSecondRating(13);
		setRating(rate, fp13);
		rate = rateResult.getSecondRating(14);
		setRating(rate, fp14);
		rate = rateResult.getSecondRating(15);
		setRating(rate, fp15);
		rate = rateResult.getSecondRating(16);
		setRating(rate, fp16);
		rate = rateResult.getSecondRating(17);
		setRating(rate, fp17);
		rate = rateResult.getSecondRating(18);
		setRating(rate, fp18);
	}
	
	private void clearData() {
		Control[] ctrl = group1.getChildren();
		clearData(ctrl);
		ctrl = group2.getChildren();
		clearData(ctrl);
	}
	
	private void clearData(Control[] ctrls){
		for(Control c : ctrls){
			if(c instanceof Combo){
				Combo combo = (Combo) c;
				combo.setText("");
			}else if(c instanceof Text){
				Text t = (Text) c;
				t.setText("");
			}
		}
	}
	
	private int getValue(Combo cb){
		String str = cb.getText();
		if(!Util.isEmpty(str)){
			return Integer.valueOf(str);
		}
		return 0;
	}
	
	private void setFirstLevel(int value){
		String level = RatingService.getInstance().getLevelLabel(value);
		cpLevel.setText(level);
	}
	
	private void setSecondLevel(int value){
		String level = RatingService.getInstance().getLevelLabel(value);
		fpLevel.setText(level);
	}
	
	private int calFirstTotalValue(){
		int total = 0;
		total += getValue(cp1);
		total += getValue(cp2);
		total += getValue(cp3);
		total += getValue(cp4);
		total += getValue(cp5);
		total += getValue(cp6);
		total += getValue(cp7);
		total += getValue(cp8);
		total += getValue(cp9);
		total += getValue(cp10);
		total += getValue(cp11);
		total += getValue(cp12);
		total += getValue(cp13);
		total += getValue(cp14);
		total += getValue(cp15);
		total += getValue(cp16);
		total += getValue(cp17);
		total += getValue(cp18);

		setFirstLevel(total);
		return total;
	}
	
	private int calSecondTotalValue(){
		int total = 0;
		total += getValue(fp1);
		total += getValue(fp2);
		total += getValue(fp3);
		total += getValue(fp4);
		total += getValue(fp5);
		total += getValue(fp6);
		total += getValue(fp7);
		total += getValue(fp8);
		total += getValue(fp9);
		total += getValue(fp10);
		total += getValue(fp11);
		total += getValue(fp12);
		total += getValue(fp13);
		total += getValue(fp14);
		total += getValue(fp15);
		total += getValue(fp16);
		total += getValue(fp17);
		total += getValue(fp18);

		setSecondLevel(total);
		return total;
	}
	
	private void addSelectListener(){
		cp1.addSelectionListener(frs);
		cp2.addSelectionListener(frs);
		cp3.addSelectionListener(frs);
		cp4.addSelectionListener(frs);
		cp5.addSelectionListener(frs);
		cp6.addSelectionListener(frs);
		cp7.addSelectionListener(frs);
		cp8.addSelectionListener(frs);
		cp9.addSelectionListener(frs);
		cp10.addSelectionListener(frs);
		cp11.addSelectionListener(frs);
		cp12.addSelectionListener(frs);
		cp13.addSelectionListener(frs);
		cp14.addSelectionListener(frs);
		cp15.addSelectionListener(frs);
		cp16.addSelectionListener(frs);
		cp17.addSelectionListener(frs);
		cp18.addSelectionListener(frs);

		fp1.addSelectionListener(srs);
		fp2.addSelectionListener(srs);
		fp3.addSelectionListener(srs);
		fp4.addSelectionListener(srs);
		fp5.addSelectionListener(srs);
		fp6.addSelectionListener(srs);
		fp7.addSelectionListener(srs);
		fp8.addSelectionListener(srs);
		fp9.addSelectionListener(srs);
		fp10.addSelectionListener(srs);
		fp11.addSelectionListener(srs);
		fp12.addSelectionListener(srs);
		fp13.addSelectionListener(srs);
		fp14.addSelectionListener(srs);
		fp15.addSelectionListener(srs);
		fp16.addSelectionListener(srs);
		fp17.addSelectionListener(srs);
		fp18.addSelectionListener(srs);

	}

	/**
	 * ¼àÌý³õÆÀ·ÖÊý±ä»¯£¬¸üÐÂ×ÛºÏÆÀ·Ö¼°µÃ·ÖµÈ¼¶
	 * @author wjl
	 *
	 */
	class FirstRatingSelectionListener implements SelectionListener{
		@Override
		public void widgetSelected(SelectionEvent e) {
			Rating rate = (Rating) e.widget.getData();
			Combo cb = (Combo) e.widget;
			if(Util.isEmpty(cb.getText())){
				rate.setRateValue(null);
			}else{
				int newValue = getValue(cb);
				rate.setRateValue(newValue);
			}
			int total = calFirstTotalValue();
			cpTotal.setText(String.valueOf(total));
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
	
	/**
	 * ¼àÌý¸´ÆÀ·ÖÊý±ä»¯£¬¸üÐÂ×ÛºÏÆÀ·Ö¼°µÃ·ÖµÈ¼¶
	 * @author wjl
	 *
	 */
	class SecondRatingSelectionListener implements SelectionListener{
		@Override
		public void widgetSelected(SelectionEvent e) {
			Rating rate = (Rating) e.widget.getData();
			Combo cb = (Combo) e.widget;
			if(Util.isEmpty(cb.getText())){
				rate.setRateValue(null);
			}else{
				int newValue = getValue(cb);
				rate.setRateValue(newValue);
			}
			int total = calSecondTotalValue();
			fpTotal.setText(String.valueOf(total));
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
}
