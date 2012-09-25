package com.xys.cenxi.customer.ui.component.query;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.xys.cenxi.customer.data.RatingService;
import com.xys.cenxi.customer.data.query.QueryRateResultKey;
import com.xys.cenxi.customer.pojo.Regional;
import com.xys.cenxi.customer.ui.component.regional.RegionalDialog;
import com.xys.cenxi.customer.util.UIUtil;
import com.xys.cenxi.customer.util.Util;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class QueryRatingResultCndCmp extends Composite {
	private Text textName;
	private Text textArchives;
	private Text textIdentify;
	private Text textRegional;
	private Text textCpValueFrom;
	private Text textCpValueTo;
	private Text textFpValueFrom;
	private Text textFpValueTo;
	private Button btnRegional;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public QueryRatingResultCndCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group group = new Group(this, SWT.NONE);
		group.setText("\u8BC4\u5206\u7ED3\u679C\u67E5\u8BE2\u6761\u4EF6");
		group.setLayout(new GridLayout(5, false));
		
		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("\u59D3\u540D\uFF1A");
		
		textName = new Text(group, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u6863\u6848\u53F7\uFF1A");
		
		textArchives = new Text(group, SWT.BORDER);
		textArchives.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		textIdentify = new Text(group, SWT.BORDER);
		textIdentify.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("\u884C\u653F\u533A\u5212\uFF1A");
		
		textRegional = new Text(group, SWT.BORDER | SWT.READ_ONLY);
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
		textRegional.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		btnRegional = new Button(group, SWT.NONE);
		btnRegional.setImage(SWTResourceManager.getImage(QueryRatingResultCndCmp.class, "/icons/goto.gif"));
		btnRegional.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doRegionalSelect();
			}
		});
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doClearRegional();
			}
		});
		button.setImage(SWTResourceManager.getImage(QueryRatingResultCndCmp.class, "/icons/delete_edit.gif"));
		
		Group group_1 = new Group(group, SWT.NONE);
		group_1.setText("\u8BC4\u5B9A\u7ED3\u679C");
		group_1.setLayout(new GridLayout(4, false));
		GridData gd_group_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1);
		gd_group_1.heightHint = 136;
		group_1.setLayoutData(gd_group_1);
		
		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("\u521D\u8BC4\u5206\u6570\uFF1A");
		
		textCpValueFrom = new Text(group_1, SWT.BORDER);
		textCpValueFrom.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				//校验分值，位数不能超过3位
				String text = textCpValueFrom.getText();
				String newStr = Util.verifyInteger(e, text);
				if(newStr.length() > 3){
					e.doit = false;
				}
			}
		});
		textCpValueFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_5 = new Label(group_1, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label_5.setText("\u5230");
		
		textCpValueTo = new Text(group_1, SWT.BORDER);
		textCpValueTo.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				//校验分值，位数不能超过3位
				String text = textCpValueTo.getText();
				String newStr = Util.verifyInteger(e, text);
				if(newStr.length() > 3){
					e.doit = false;
				}
			}
		});
		textCpValueTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_6 = new Label(group_1, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setText("\u590D\u8BC4\u5206\u6570\uFF1A");
		
		textFpValueFrom = new Text(group_1, SWT.BORDER);
		textFpValueFrom.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				//校验分值，位数不能超过3位
				String text = textFpValueFrom.getText();
				String newStr = Util.verifyInteger(e, text);
				if(newStr.length() > 3){
					e.doit = false;
				}
			}
		});
		textFpValueFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_7 = new Label(group_1, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_7.setText("\u5230");
		
		textFpValueTo = new Text(group_1, SWT.BORDER);
		textFpValueTo.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent e) {
				//校验分值，位数不能超过3位
				String text = textFpValueTo.getText();
				String newStr = Util.verifyInteger(e, text);
				if(newStr.length() > 3){
					e.doit = false;
				}
			}
		});
		textFpValueTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_8 = new Label(group_1, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_8.setText("\u521D\u8BC4\u7B49\u7EA7\uFF1A");
		
		Combo cbCpLevel = new Combo(group_1, SWT.READ_ONLY);
		cbCpLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);
		
		Label label_9 = new Label(group_1, SWT.NONE);
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_9.setText("\u590D\u8BC4\u7B49\u7EA7\uFF1A");
		
		Combo cbFpLevel = new Combo(group_1, SWT.READ_ONLY);
		cbFpLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group_1, SWT.NONE);
		new Label(group_1, SWT.NONE);

		initCombo(cbCpLevel);
		initCombo(cbFpLevel);
		cbFpLevel.setData("no use");
	}

	protected void doClearRegional() {
		textRegional.setText("");
		textRegional.setData(null);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void initCombo(Combo cb){
		UIUtil.setData(RatingService.getInstance().getRatingLevels(), cb, true);
		cb.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!(e.getSource() instanceof Combo)){
					return ;
				}
				Combo cb = (Combo) e.getSource();
				String level = cb.getText();
				if(Util.isEmpty(level)){
					if(cb.getData() == null){
						//复评有数据，初平CB没有数据
						textCpValueFrom.setText("");
						textCpValueTo.setText("");
					}else{
						textFpValueFrom.setText("");
						textFpValueTo.setText("");
					}
					return;
				}
				
				int[] range = RatingService.getInstance().getRange(level);
				if(cb.getData() == null){
					//复评有数据，初平CB没有数据
					textCpValueFrom.setText(String.valueOf(range[0]));
					textCpValueTo.setText(String.valueOf(range[1]));
				}else{
					textFpValueFrom.setText(String.valueOf(range[0]));
					textFpValueTo.setText(String.valueOf(range[1]));
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
	
	public QueryRateResultKey getQueryKey(){
		QueryRateResultKey key = new QueryRateResultKey();
		if(!Util.isEmpty(textArchives.getText())){
			key.archivesID = textArchives.getText();
		}
		if(!Util.isEmpty(textCpValueFrom.getText())){
			key.firstValueFrom = Integer.valueOf(textCpValueFrom.getText());
		}
		if(!Util.isEmpty(textCpValueTo.getText())){
			key.firstValueTo = Integer.valueOf(textCpValueTo.getText());
		}
		if(!Util.isEmpty(textIdentify.getText())){
			key.identifyId = textIdentify.getText();
		}
		if(!Util.isEmpty(textFpValueFrom.getText())){
			key.secondValueFrom = Integer.valueOf(textFpValueFrom.getText());
		}
		if(!Util.isEmpty(textFpValueTo.getText())){
			key.secondValueTo = Integer.valueOf(textFpValueTo.getText());
		}
		if(!Util.isEmpty(textName.getText())){
			key.name = textName.getText();
		}
		if(textRegional.getData() != null){
			Regional re = (Regional) textRegional.getData();
			key.regional = re.getRegionalCode();
		}else{
			key.regional = null;
		}
		return key;
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
	
}
