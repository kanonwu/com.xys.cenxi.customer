package com.xys.cenxi.customer.ui.component.rating;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import de.kupzog.ktable.KTable;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class BasicInfoCmp extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public BasicInfoCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group group = new Group(this, SWT.NONE);
		group.setText("\u88AB\u8BC4\u519C\u6237\u57FA\u672C\u4FE1\u606F");
		group.setLayout(new GridLayout(10, false));
		
		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("\u59D3\u540D\uFF1A");
		
		text = new Text(group, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_text.widthHint = 116;
		text.setLayoutData(gd_text);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u5730\u5740\uFF1A");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setText("\u5C91\u6EAA\u7B4B\u7AF9\u9547\u9EC4\u9675\u6751\u4E8C\u7EC4112\u53F7");
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_text_1.widthHint = 222;
		text_1.setLayoutData(gd_text_1);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		text_2 = new Text(group, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_2.widthHint = 136;
		text_2.setLayoutData(gd_text_2);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("\u662F\u5426\u793E\u5458\uFF1A");
		
		Combo combo = new Combo(group, SWT.READ_ONLY);
		combo.setItems(new String[] {"\u662F", "\u5426"});
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 13;
		combo.setLayoutData(gd_combo);
		combo.select(0);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1));
		label_4.setText("\u4E2A\u4EBA\u53CA\u5BB6\u5EAD\u6210\u5458\u6709\u65E0\u4E0D\u826F\u55DC\u597D\u6216\u4E60\u60EF\uFF1A");
		
		Combo combo_1 = new Combo(group, SWT.NONE);
		combo_1.setItems(new String[] {"\u6709", "\u65E0"});
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 23;
		combo_1.setLayoutData(gd_combo_1);
		combo_1.select(1);
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_5.setText("\u4E2A\u4EBA\u4FE1\u7528\u72B6\u51B5\uFF1A");
		
		Combo combo_2 = new Combo(group, SWT.NONE);
		GridData gd_combo_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_2.widthHint = 56;
		combo_2.setLayoutData(gd_combo_2);
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setAlignment(SWT.RIGHT);
		label_6.setText("\u5BF9\u5916\u62C5\u4FDD\u4F59\u989D(\u4E07\u5143)\uFF1A");
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		label_7.setText("\u5BB6\u5EAD\u603B\u8D44\u4EA7(\u4E07\u5143)\uFF1A");
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_8 = new Label(group, SWT.NONE);
		GridData gd_label_8 = new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1);
		gd_label_8.heightHint = 22;
		label_8.setLayoutData(gd_label_8);
		label_8.setText("\u5BB6\u5EAD\u603B\u8D1F\u503A(\u4E07\u5143)\uFF1A");
		
		text_5 = new Text(group, SWT.BORDER);
		GridData gd_text_5 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_5.widthHint = 87;
		text_5.setLayoutData(gd_text_5);
		
		Label label_9 = new Label(group, SWT.NONE);
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_9.setText("\u5BB6\u5EAD\u51C0\u8D44\u4EA7(\u4E07\u5143):");
		
		text_6 = new Text(group, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_10 = new Label(group, SWT.NONE);
		label_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		label_10.setText("\u5BB6\u5EAD\u5E74\u6536\u5165(\u4E07\u5143)\uFF1A");
		
		text_7 = new Text(group, SWT.BORDER);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_11.setText("\u5BB6\u5EAD\u5E74\u652F\u51FA(\u4E07\u5143)\uFF1A");
		
		text_8 = new Text(group, SWT.BORDER);
		text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_12 = new Label(group, SWT.NONE);
		label_12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_12.setText("\u5BB6\u5EAD\u5E74\u7EAF\u6536\u5165(\u4E07\u5143):");
		
		text_9 = new Text(group, SWT.BORDER);
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_13 = new Label(group, SWT.NONE);
		label_13.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label_13.setText("\u751F\u4EA7\u7ECF\u8425\u670D\u52A1\u5185\u5BB9\uFF1A");
		
		text_10 = new Text(group, SWT.BORDER);
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_14 = new Label(group, SWT.WRAP);
		GridData gd_label_14 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label_14.widthHint = 74;
		gd_label_14.heightHint = 37;
		label_14.setLayoutData(gd_label_14);
		label_14.setText("\u751F\u4EA7\u7ECF\u8425\u8D44\u91D1\u89C4\u6A21(\u4E07\u5143)\uFF1A");
		
		text_11 = new Text(group, SWT.BORDER);
		text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_15 = new Label(group, SWT.NONE);
		label_15.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_15.setText("\u751F\u4EA7\u81EA\u6709\u8D44\u91D1(\u4E07\u5143):");
		
		text_12 = new Text(group, SWT.BORDER);
		text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
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
		
		text_13 = new Text(group, SWT.BORDER);
		text_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_17 = new Label(group, SWT.WRAP);
		GridData gd_label_17 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_label_17.widthHint = 102;
		label_17.setLayoutData(gd_label_17);
		label_17.setText("\u81EA\u6709\u8D44\u91D1\u5360\u751F\u4EA7\u6240\u9700\u8D44\u91D1\u6BD4\u4F8B(%):");
		
		text_14 = new Text(group, SWT.BORDER);
		text_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
