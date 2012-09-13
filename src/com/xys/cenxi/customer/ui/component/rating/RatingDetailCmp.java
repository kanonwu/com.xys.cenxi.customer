package com.xys.cenxi.customer.ui.component.rating;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;

public class RatingDetailCmp extends Composite {
	private Text text;
	private Text text_1;

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
		
		Group group = new Group(composite, SWT.NONE);
		group.setText("\u6807\u51C6\u53CA\u8BC4\u5206");
		group.setLayout(new GridLayout(11, false));
		GridData gd_group = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_group.heightHint = 1842;
		group.setLayoutData(gd_group);
		
		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		label.setText("\u5E8F\u53F7");
		new Label(group, SWT.NONE);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("\u9879\u76EE");
		new Label(group, SWT.NONE);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setText("\u6307\u6807\u540D\u79F0");
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setText("\u8BA1\u5206\u6807\u51C6");
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setText("\u5206\u503C");
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setAlignment(SWT.CENTER);
		GridData gd_label_5 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_label_5.widthHint = 45;
		label_5.setLayoutData(gd_label_5);
		label_5.setText("\u521D\u8BC4");
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setAlignment(SWT.CENTER);
		GridData gd_label_6 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label_6.widthHint = 44;
		label_6.setLayoutData(gd_label_6);
		label_6.setText("\u590D\u8BC4");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_13 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 11, 1));
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		label_7.setText("1");
		
		Label label_70 = new Label(group, SWT.SEPARATOR | SWT.VERTICAL);
		label_70.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 81));
		new Label(group, SWT.NONE);
		
		Label label_69 = new Label(group, SWT.SEPARATOR | SWT.VERTICAL);
		label_69.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 81));
		
		Label label_8 = new Label(group, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_8.setText("\u6237\u53E3\u6027\u8D28");
		
		Label label_9 = new Label(group, SWT.NONE);
		label_9.setText("\u5E38\u4F4F\u4EBA\u53E3");
		
		Label label_11 = new Label(group, SWT.NONE);
		label_11.setText("3");
		
		Combo combo = new Combo(group, SWT.READ_ONLY);
		combo.setItems(new String[] {"3", "0"});
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		
		Combo combo_1 = new Combo(group, SWT.READ_ONLY);
		combo_1.setItems(new String[] {"3", "0"});
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_10 = new Label(group, SWT.NONE);
		label_10.setText("\u4E0D\u662F\u5E38\u4F4F\u4EBA\u53E3");
		
		Label label_12 = new Label(group, SWT.NONE);
		label_12.setAlignment(SWT.CENTER);
		label_12.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_110 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_110.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		
		Label label_15 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_14 = new Label(group, SWT.NONE);
		label_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		label_14.setText("2");
		
		Label label_16 = new Label(group, SWT.NONE);
		label_16.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 19));
		label_16.setText("\u57FA\u672C\u60C5\u51B520\u5206");
		
		Label label_17 = new Label(group, SWT.NONE);
		label_17.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_17.setText("\u5E74\u9F84");
		
		Label label_18 = new Label(group, SWT.NONE);
		label_18.setText("18\u201425\u5C81");
		
		Label label_19 = new Label(group, SWT.NONE);
		label_19.setText("2");
		
		Combo combo_3 = new Combo(group, SWT.READ_ONLY);
		combo_3.setItems(new String[] {"2", "3", "5"});
		combo_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		
		Combo combo_2 = new Combo(group, SWT.READ_ONLY);
		combo_2.setItems(new String[] {"2", "3", "5"});
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_20 = new Label(group, SWT.NONE);
		label_20.setText("26\u201430\u5C81");
		
		Label label_21 = new Label(group, SWT.NONE);
		label_21.setText("3");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_22 = new Label(group, SWT.NONE);
		label_22.setText("31\u201445\u5C81");
		
		Label label_23 = new Label(group, SWT.NONE);
		label_23.setText("5");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_24 = new Label(group, SWT.NONE);
		label_24.setText("46\u201450\u5C81");
		
		Label label_25 = new Label(group, SWT.NONE);
		label_25.setText("3");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_26 = new Label(group, SWT.NONE);
		label_26.setText("50\u5C81\u4EE5\u4E0A");
		
		Label label_27 = new Label(group, SWT.NONE);
		label_27.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_111 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_111.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_28 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_28.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_54 = new Label(group, SWT.NONE);
		label_54.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_54.setText("3");
		
		Label label_44 = new Label(group, SWT.NONE);
		label_44.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_44.setText("\u5A5A\u59FB\u72B6\u51B5");
		
		Label label_45 = new Label(group, SWT.NONE);
		label_45.setText("\u5DF2\u5A5A");
		
		Label label_50 = new Label(group, SWT.NONE);
		label_50.setText("4");
		
		Combo combo_4 = new Combo(group, SWT.READ_ONLY);
		combo_4.setItems(new String[] {"4", "3", "2", "1"});
		combo_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		
		Combo combo_5 = new Combo(group, SWT.READ_ONLY);
		combo_5.setItems(new String[] {"4", "3", "2", "1"});
		combo_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_46 = new Label(group, SWT.NONE);
		label_46.setText("\u672A\u5A5A");
		
		Label label_51 = new Label(group, SWT.NONE);
		label_51.setText("3");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_47 = new Label(group, SWT.NONE);
		label_47.setText("\u4E27\u5076");
		
		Label label_52 = new Label(group, SWT.NONE);
		label_52.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_48 = new Label(group, SWT.NONE);
		label_48.setText("\u79BB\u5F02");
		
		Label label_53 = new Label(group, SWT.NONE);
		label_53.setText("1");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_112 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_112.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_49 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_49.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_55 = new Label(group, SWT.NONE);
		label_55.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		label_55.setText("4");
		
		Label label_29 = new Label(group, SWT.NONE);
		label_29.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 3));
		label_29.setText("\u8EAB\u4F53\u5065\u5EB7\u72B6\u51B5");
		
		Label label_30 = new Label(group, SWT.NONE);
		label_30.setText("\u826F\u597D");
		
		Label label_31 = new Label(group, SWT.NONE);
		label_31.setText("3");
		
		Combo combo_6 = new Combo(group, SWT.READ_ONLY);
		combo_6.setItems(new String[] {"3", "2", "0"});
		combo_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		
		Combo combo_7 = new Combo(group, SWT.READ_ONLY);
		combo_7.setItems(new String[] {"3", "2", "0"});
		combo_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_32 = new Label(group, SWT.NONE);
		label_32.setText("\u4E00\u822C");
		
		Label label_33 = new Label(group, SWT.NONE);
		label_33.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_34 = new Label(group, SWT.NONE);
		label_34.setText("\u5DEE");
		
		Label label_35 = new Label(group, SWT.NONE);
		label_35.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_113 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_113.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_36 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_36.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_56 = new Label(group, SWT.NONE);
		label_56.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		label_56.setText("5");
		
		Label label_37 = new Label(group, SWT.NONE);
		label_37.setText("\u6587\u5316\u7A0B\u5EA6");
		
		Label label_38 = new Label(group, SWT.NONE);
		label_38.setText("\u5927\u4E13\u4EE5\u4E0A");
		
		Label label_41 = new Label(group, SWT.NONE);
		label_41.setText("5");
		
		Combo combo_8 = new Combo(group, SWT.READ_ONLY);
		combo_8.setItems(new String[] {"5", "2", "1"});
		combo_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		
		Combo combo_9 = new Combo(group, SWT.READ_ONLY);
		combo_9.setItems(new String[] {"5", "2", "1"});
		combo_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 3));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_39 = new Label(group, SWT.NONE);
		label_39.setText("\u521D\u4E2D\u4EE5\u4E0A");
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_40 = new Label(group, SWT.NONE);
		label_40.setText("\u521D\u4E2D\u4EE5\u4E0B");
		
		Label label_42 = new Label(group, SWT.NONE);
		label_42.setText("1");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_109 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_109.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_108 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_108.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_43 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_43.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_57 = new Label(group, SWT.NONE);
		label_57.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		label_57.setText("6");
		
		Label label_58 = new Label(group, SWT.NONE);
		label_58.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 27));
		label_58.setText("\u507F\u503A\u80FD\u529B40\u5206");
		
		Label label_59 = new Label(group, SWT.NONE);
		label_59.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_59.setText("\u5BB6\u5EAD\u603B\u8D44\u4EA7");
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setText("20\u4E07\u5143(\u542B)\u4EE5\u4E0A");
		
		Label label_63 = new Label(group, SWT.NONE);
		label_63.setText("7");
		
		Combo combo_10 = new Combo(group, SWT.READ_ONLY);
		combo_10.setItems(new String[] {"7", "6", "5", "4", "3"});
		combo_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		
		Combo combo_11 = new Combo(group, SWT.READ_ONLY);
		combo_11.setItems(new String[] {"7", "6", "5", "4", "3"});
		combo_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_60 = new Label(group, SWT.NONE);
		label_60.setText("15\u4E07\u5143(\u542B) \u2014 20\u4E07\u5143");
		
		Label label_64 = new Label(group, SWT.NONE);
		label_64.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_61 = new Label(group, SWT.NONE);
		label_61.setText("10\u4E07\u5143(\u542B)\u201415\u4E07\u5143");
		
		Label label_65 = new Label(group, SWT.NONE);
		label_65.setText("5");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setText("5\u4E07\u5143(\u542B) \u2014 10\u4E07\u5143");
		
		Label label_66 = new Label(group, SWT.NONE);
		label_66.setText("4");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_62 = new Label(group, SWT.NONE);
		label_62.setText("5\u4E07\u5143\u4EE5\u4E0B");
		
		Label label_67 = new Label(group, SWT.NONE);
		label_67.setText("3");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_115 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_115.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_68 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_68.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_116 = new Label(group, SWT.NONE);
		label_116.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_116.setText("7");
		
		Label label_71 = new Label(group, SWT.NONE);
		label_71.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_71.setText("\u5BB6\u5EAD\u603B\u8D1F\u503A");
		
		Label label_72 = new Label(group, SWT.NONE);
		label_72.setText("1\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_77 = new Label(group, SWT.NONE);
		label_77.setText("5");
		
		Combo combo_12 = new Combo(group, SWT.READ_ONLY);
		combo_12.setItems(new String[] {"5", "4", "3", "2", "1"});
		combo_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		
		Combo combo_13 = new Combo(group, SWT.READ_ONLY);
		combo_13.setItems(new String[] {"5", "4", "3", "2", "1"});
		combo_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_73 = new Label(group, SWT.NONE);
		label_73.setText("1 \u2014 2\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_78 = new Label(group, SWT.NONE);
		label_78.setText("4");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_74 = new Label(group, SWT.NONE);
		label_74.setText("2 \u2014 5\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_79 = new Label(group, SWT.NONE);
		label_79.setText("3");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_75 = new Label(group, SWT.NONE);
		label_75.setText("5 \u2014 10\u4E07\u5143(\u542B)\u4EE5\u5185");
		
		Label label_80 = new Label(group, SWT.NONE);
		label_80.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_76 = new Label(group, SWT.NONE);
		label_76.setText("10\u4E07\u5143\u4EE5\u4E0A");
		
		Label label_81 = new Label(group, SWT.NONE);
		label_81.setText("1");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_114 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_114.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_82 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_82.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_117 = new Label(group, SWT.NONE);
		label_117.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		label_117.setText("8");
		
		Label label_83 = new Label(group, SWT.NONE);
		label_83.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_83.setText("\u751F\u4EA7\u7ECF\u8425\u89C4\u6A21");
		
		Label label_84 = new Label(group, SWT.NONE);
		label_84.setText("10\u4E07\u5143(\u542B)\u4EE5\u4E0A");
		
		Label label_87 = new Label(group, SWT.NONE);
		label_87.setText("8");
		
		Combo combo_14 = new Combo(group, SWT.READ_ONLY);
		combo_14.setItems(new String[] {"8", "7", "6", "5"});
		combo_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		
		Combo combo_15 = new Combo(group, SWT.READ_ONLY);
		combo_15.setItems(new String[] {"8", "7", "6", "5"});
		combo_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_85 = new Label(group, SWT.NONE);
		label_85.setText("5\u4E07\u5143(\u542B) \u2014 10\u4E07\u5143");
		
		Label label_88 = new Label(group, SWT.NONE);
		label_88.setText("7");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_3 = new Label(group, SWT.NONE);
		lblNewLabel_3.setText("3\u4E07\u5143(\u542B) \u2014 5\u4E07\u5143");
		
		Label label_89 = new Label(group, SWT.NONE);
		label_89.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_86 = new Label(group, SWT.NONE);
		label_86.setText("3\u4E07\u5143\u4EE5\u4E0B");
		
		Label label_90 = new Label(group, SWT.NONE);
		label_90.setText("5");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_118 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_118.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_91 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_91.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_119 = new Label(group, SWT.NONE);
		label_119.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_119.setText("9");
		
		Label label_92 = new Label(group, SWT.WRAP);
		GridData gd_label_92 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4);
		gd_label_92.widthHint = 90;
		label_92.setLayoutData(gd_label_92);
		label_92.setText("\u6700\u8FD13\u5E74\u5BB6\u5EAD\u5E74\u5E73\u5747\u7EAF\u6536\u5165");
		
		Label label_93 = new Label(group, SWT.NONE);
		label_93.setText("3\u4E07\u5143(\u542B)\u4EE5\u4E0A");
		
		Label label_97 = new Label(group, SWT.NONE);
		label_97.setText("10");
		
		Combo combo_16 = new Combo(group, SWT.READ_ONLY);
		combo_16.setItems(new String[] {"10", "8", "6", "5"});
		combo_16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		
		Combo combo_17 = new Combo(group, SWT.READ_ONLY);
		combo_17.setItems(new String[] {"10", "8", "6", "5"});
		combo_17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_94 = new Label(group, SWT.NONE);
		label_94.setText("2\u4E07\u5143(\u542B) \u2014 3\u4E07\u5143");
		
		Label label_98 = new Label(group, SWT.NONE);
		label_98.setText("8");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_95 = new Label(group, SWT.NONE);
		label_95.setText("1\u4E07\u5143(\u542B) \u2014 2\u4E07\u5143");
		
		Label label_99 = new Label(group, SWT.NONE);
		label_99.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_96 = new Label(group, SWT.NONE);
		label_96.setText("1\u4E07\u5143\u4EE5\u4E0B");
		
		Label label_100 = new Label(group, SWT.NONE);
		label_100.setText("5");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_120 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_120.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_101 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_101.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_121 = new Label(group, SWT.NONE);
		label_121.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5));
		label_121.setText("10");
		
		Label label_102 = new Label(group, SWT.WRAP);
		GridData gd_label_102 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 5);
		gd_label_102.widthHint = 91;
		label_102.setLayoutData(gd_label_102);
		label_102.setText("\u751F\u4EA7\u7ECF\u8425\u81EA\u6709\u8D44\u91D1\u6BD4\u4F8B");
		
		Label label_103 = new Label(group, SWT.NONE);
		label_103.setText("50%(\u542B)\u4EE5\u4E0A");
		
		Label label_122 = new Label(group, SWT.NONE);
		label_122.setText("10");
		
		Combo combo_18 = new Combo(group, SWT.READ_ONLY);
		combo_18.setItems(new String[] {"10", "8", "6", "3", "0"});
		combo_18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		
		Combo combo_19 = new Combo(group, SWT.READ_ONLY);
		combo_19.setItems(new String[] {"10", "8", "6", "3", "0"});
		combo_19.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_104 = new Label(group, SWT.NONE);
		label_104.setText("40%(\u542B) \u2014 50%");
		
		Label label_123 = new Label(group, SWT.NONE);
		label_123.setText("8");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_105 = new Label(group, SWT.NONE);
		label_105.setText("30%(\u542B) \u2014 40%");
		
		Label label_124 = new Label(group, SWT.NONE);
		label_124.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_106 = new Label(group, SWT.NONE);
		label_106.setText("0(\u4E0D\u542B) \u2014 30%");
		
		Label label_125 = new Label(group, SWT.NONE);
		label_125.setText("3");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_107 = new Label(group, SWT.NONE);
		label_107.setText("\u81EA\u6709\u8D44\u91D1\u4E3A0\u4E07\u5143");
		
		Label label_126 = new Label(group, SWT.NONE);
		label_126.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_128 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_128.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_130 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_130.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_127 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_127.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_159 = new Label(group, SWT.NONE);
		label_159.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_159.setText("11");
		
		Label label_129 = new Label(group, SWT.NONE);
		label_129.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_129.setText("\u54C1\u8D2810\u5206");
		
		Label label_131 = new Label(group, SWT.NONE);
		label_131.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_131.setText("\u519C\u6237\u7684\u54C1\u8D28");
		
		Label label_132 = new Label(group, SWT.NONE);
		label_132.setText("\u54C1\u884C\u826F\u597D\uFF0C\u52E4\u52B3\uFF0C\u793E\u4F1A\u53CD\u6620\u597D");
		
		Label label_135 = new Label(group, SWT.NONE);
		label_135.setText("10");
		
		Combo combo_20 = new Combo(group, SWT.READ_ONLY);
		combo_20.setItems(new String[] {"10", "8", "6", "0"});
		combo_20.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		
		Combo combo_21 = new Combo(group, SWT.READ_ONLY);
		combo_21.setItems(new String[] {"10", "8", "6", "0"});
		combo_21.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_133 = new Label(group, SWT.NONE);
		label_133.setText("\u54C1\u884C\u8F83\u597D\uFF0C\u52E4\u52B3\uFF0C\u793E\u4F1A\u53CD\u6620\u8F83\u597D");
		
		Label label_136 = new Label(group, SWT.NONE);
		label_136.setText("8");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_134 = new Label(group, SWT.NONE);
		label_134.setText("\u54C1\u884C\u4E00\u822C\uFF0C\u80AF\u52B3\u52A8\uFF0C\u793E\u4F1A\u53CD\u6620\u5C1A\u53EF");
		
		Label label_137 = new Label(group, SWT.NONE);
		label_137.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(group, SWT.WRAP);
		GridData gd_lblNewLabel_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_4.widthHint = 201;
		gd_lblNewLabel_4.heightHint = 56;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);
		lblNewLabel_4.setText("\u81EA\u8EAB\u65E0\u4E0D\u826F\u55DC\u597D\u4E60\u60EF\uFF0C\u4F46\u5BB6\u5EAD\u4E3B\u8981\u6210\u5458\u6709\u9EC4\u8D4C\u6BD2\u7B49\u4E0D\u826F\u55DC\u597D\u6216\u597D\u9038\u6076\u52B3\u7B49\u4E0D\u826F\u4E60\u60EF\uFF0C\u793E\u4F1A\u53CD\u6620\u8F83\u5DEE");
		
		Label label_138 = new Label(group, SWT.NONE);
		label_138.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_160 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_160.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		Label label_139 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_139.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_140 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_140.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_162 = new Label(group, SWT.NONE);
		label_162.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_162.setText("12");
		
		Label label_141 = new Label(group, SWT.NONE);
		label_141.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 18));
		label_141.setText("\u4FE1\u7528\u7A0B\u5EA628\u5206");
		
		Label lblNewLabel_5 = new Label(group, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_5.setText("*\u4E1A\u52A1\u5F80\u6765");
		
		Label label_142 = new Label(group, SWT.NONE);
		label_142.setText("\u5728\u519C\u5408\u94F6\u884C\u6709\u7ED3\u7B97\u8D26\u6237,\u4E3B\u8981\u5B58\u6B3E\u662F\u5426\u5728\u519C\u5408\u94F6\u884C");
		
		Label label_185 = new Label(group, SWT.NONE);
		label_185.setText("4");
		
		Combo combo_22 = new Combo(group, SWT.READ_ONLY);
		combo_22.setItems(new String[] {"4", "2"});
		combo_22.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		
		Combo combo_23 = new Combo(group, SWT.READ_ONLY);
		combo_23.setItems(new String[] {"4", "2"});
		combo_23.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_143 = new Label(group, SWT.NONE);
		label_143.setText("\u5728\u519C\u5408\u94F6\u884C\u65E0\u7ED3\u7B97\u8D26\u6237");
		
		Label label_186 = new Label(group, SWT.NONE);
		label_186.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_161 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_161.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_144 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_144.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_163 = new Label(group, SWT.NONE);
		label_163.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_163.setText("13");
		
		Label label_145 = new Label(group, SWT.NONE);
		label_145.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_145.setText("*\u80A1\u91D1\u72B6\u51B5");
		
		Label label_146 = new Label(group, SWT.NONE);
		label_146.setText("\u6709\u80A1\u91D1");
		
		Label label_187 = new Label(group, SWT.NONE);
		label_187.setText("3");
		
		Combo combo_24 = new Combo(group, SWT.READ_ONLY);
		combo_24.setItems(new String[] {"3", "2"});
		combo_24.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		
		Combo combo_25 = new Combo(group, SWT.READ_ONLY);
		combo_25.setItems(new String[] {"3", "2"});
		combo_25.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_6 = new Label(group, SWT.NONE);
		lblNewLabel_6.setText("\u65E0\u80A1\u91D1");
		
		Label label_188 = new Label(group, SWT.NONE);
		label_188.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_164 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_164.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_147 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_147.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_165 = new Label(group, SWT.NONE);
		label_165.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_165.setText("14");
		
		Label label_148 = new Label(group, SWT.NONE);
		label_148.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_148.setText("*\u4E2A\u4EBA\u4FE1\u7528\u8BB0\u5F55");
		
		Label label_149 = new Label(group, SWT.NONE);
		label_149.setText("\u6709\u501F\u6B3E\u65E0\u4E0D\u826F\u8BB0\u5F55");
		
		Label label_189 = new Label(group, SWT.NONE);
		label_189.setText("10");
		
		Combo combo_26 = new Combo(group, SWT.READ_ONLY);
		combo_26.setItems(new String[] {"10", "8", "6", "0"});
		combo_26.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		
		Combo combo_27 = new Combo(group, SWT.READ_ONLY);
		combo_27.setItems(new String[] {"10", "8", "6", "0"});
		combo_27.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_150 = new Label(group, SWT.NONE);
		label_150.setText("\u4ECE\u672A\u501F\u6B3E");
		
		Label label_190 = new Label(group, SWT.NONE);
		label_190.setText("8");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_7 = new Label(group, SWT.NONE);
		lblNewLabel_7.setText("\u6709\u4E0D\u826F\u8BB0\u5F55\uFF0C\u65E0\u6076\u610F\u4E0D\u826F\u8BB0\u5F55");
		
		Label label_191 = new Label(group, SWT.NONE);
		label_191.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_151 = new Label(group, SWT.NONE);
		label_151.setText("\u6709\u4E0D\u826F\u8BB0\u5F55\uFF0C\u662F\u6076\u610F\u4E0D\u826F\u8BB0\u5F55");
		
		Label label_192 = new Label(group, SWT.NONE);
		label_192.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_166 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Label label_152 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_152.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_167 = new Label(group, SWT.NONE);
		label_167.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		label_167.setText("15");
		
		Label lblNewLabel_8 = new Label(group, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 4));
		lblNewLabel_8.setText("\u793E\u4F1A\u4FE1\u7528");
		
		Label lblNewLabel_9 = new Label(group, SWT.NONE);
		lblNewLabel_9.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u826F\u597D");
		
		Label label_193 = new Label(group, SWT.NONE);
		label_193.setText("8");
		
		Combo combo_28 = new Combo(group, SWT.READ_ONLY);
		combo_28.setItems(new String[] {"8", "6", "4", "0"});
		combo_28.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		
		Combo combo_29 = new Combo(group, SWT.READ_ONLY);
		combo_29.setItems(new String[] {"8", "6", "4", "0"});
		combo_29.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 4));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_10 = new Label(group, SWT.NONE);
		lblNewLabel_10.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u8F83\u597D");
		
		Label label_194 = new Label(group, SWT.NONE);
		label_194.setText("6");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_11 = new Label(group, SWT.NONE);
		lblNewLabel_11.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u4E00\u822C");
		
		Label label_195 = new Label(group, SWT.NONE);
		label_195.setText("4");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_12 = new Label(group, SWT.NONE);
		lblNewLabel_12.setText("\u793E\u4F1A\u53CD\u6620\u4FE1\u7528\u8F83\u5DEE");
		
		Label label_196 = new Label(group, SWT.NONE);
		label_196.setText("0");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_168 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Label label_153 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_153.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_169 = new Label(group, SWT.NONE);
		label_169.setText("16");
		
		Label lblNewLabel_13 = new Label(group, SWT.NONE);
		lblNewLabel_13.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_13.setText("*\u662F\u5426\u662F\u4FE1\u7528\u6751\u6751\u6C11");
		
		Label lblNewLabel_14 = new Label(group, SWT.NONE);
		lblNewLabel_14.setText("\u662F");
		
		Label label_197 = new Label(group, SWT.NONE);
		label_197.setText("3");
		
		Combo combo_30 = new Combo(group, SWT.READ_ONLY);
		combo_30.setItems(new String[] {"3", "2"});
		combo_30.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		
		Combo combo_31 = new Combo(group, SWT.READ_ONLY);
		combo_31.setItems(new String[] {"3", "2"});
		combo_31.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_154 = new Label(group, SWT.NONE);
		label_154.setText("\u5426");
		
		Label label_198 = new Label(group, SWT.NONE);
		label_198.setText("2");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_170 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_170.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_171 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_171.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_155 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_155.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_174 = new Label(group, SWT.NONE);
		label_174.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		label_174.setText("17");
		
		Label lblNewLabel_16 = new Label(group, SWT.NONE);
		lblNewLabel_16.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_16.setText("\u5176\u4ED6");
		
		Label lblNewLabel_15 = new Label(group, SWT.NONE);
		lblNewLabel_15.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
		lblNewLabel_15.setText("\u53C2\u52A0\u4FDD\u9669");
		
		Label lblNewLabel_17 = new Label(group, SWT.NONE);
		lblNewLabel_17.setText("\u53C2\u52A0");
		
		Label label_199 = new Label(group, SWT.NONE);
		label_199.setText("2");
		
		Combo combo_32 = new Combo(group, SWT.READ_ONLY);
		combo_32.setItems(new String[] {"2", "1"});
		combo_32.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		
		Combo combo_33 = new Combo(group, SWT.READ_ONLY);
		combo_33.setItems(new String[] {"2", "1"});
		combo_33.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_18 = new Label(group, SWT.NONE);
		lblNewLabel_18.setText("\u4E0D\u53C2\u52A0");
		
		Label label_200 = new Label(group, SWT.NONE);
		label_200.setText("1");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_173 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_173.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_172 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_172.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_156 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_156.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_175 = new Label(group, SWT.NONE);
		label_175.setText("18");
		
		Label lblNewLabel_19 = new Label(group, SWT.NONE);
		lblNewLabel_19.setText("\u8C03\u6574\u8D4B\u5206\uFF08\u00B13\uFF09");
		new Label(group, SWT.NONE);
		
		Label lblNewLabel_20 = new Label(group, SWT.NONE);
		lblNewLabel_20.setText("\u8C03\u6574\u5206(\u662F\u5426\u662F\u4E00\u76F4\u652F\u6301\u6211\u4EEC\u519C\u5408\u94F6\u884C\u5404\u9879\u5DE5\u4F5C)");
		
		Label lblNewLabel_21 = new Label(group, SWT.NONE);
		lblNewLabel_21.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_21.setText("\u00B13");
		
		Combo combo_34 = new Combo(group, SWT.READ_ONLY);
		combo_34.setItems(new String[] {"+3", "-3"});
		combo_34.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Combo combo_35 = new Combo(group, SWT.READ_ONLY);
		combo_35.setItems(new String[] {"+3", "-3"});
		combo_35.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_176 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_176.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_157 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_157.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_158 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_158.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		
		Label label_177 = new Label(group, SWT.NONE);
		label_177.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_177.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_177.setText("\u7EFC\u5408\u8BC4\u5206");
		
		Label label_178 = new Label(group, SWT.NONE);
		label_178.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		label_178.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		label_178.setText("100");
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		text = new Text(group, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 45;
		text.setLayoutData(gd_text);
		
		text_1 = new Text(group, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 45;
		text_1.setLayoutData(gd_text_1);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		
		Label label_180 = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_180.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 11, 1));
		
		Composite composite_1 = new Composite(group, SWT.NONE);
		composite_1.setLayout(new GridLayout(10, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 11, 1);
		gd_composite_1.heightHint = 52;
		composite_1.setLayoutData(gd_composite_1);
		
		Label label_179 = new Label(composite_1, SWT.NONE);
		label_179.setText("\u4FE1\u7528\u7B49\u7EA7");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		
		Label lblNewLabel_22 = new Label(composite_1, SWT.NONE);
		lblNewLabel_22.setText("80(\u542B)\u4EE5\u4E0A");
		
		Label label_181 = new Label(composite_1, SWT.NONE);
		label_181.setText("70\uFF08\u542B\uFF09-80\u5206");
		
		Label label_182 = new Label(composite_1, SWT.NONE);
		label_182.setText("60\uFF08\u542B\uFF09-70\u5206");
		
		Label label_183 = new Label(composite_1, SWT.NONE);
		label_183.setText("60\u5206\u4EE5\u4E0B");
		
		Label label_184 = new Label(composite_1, SWT.NONE);
		label_184.setText("\u5F97\u5206\u7B49\u7EA7");
		
		Label label_201 = new Label(composite_1, SWT.NONE);
		label_201.setText("\u6807\u51C6");
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
		
		Label label_202 = new Label(composite_1, SWT.NONE);
		label_202.setText("\u4F18\u79C0");
		
		Label label_203 = new Label(composite_1, SWT.NONE);
		label_203.setText("\u826F\u597D");
		
		Label label_204 = new Label(composite_1, SWT.NONE);
		label_204.setText("\u4E00\u822C");
		
		Label label_205 = new Label(composite_1, SWT.NONE);
		label_205.setText("\u8F83\u5DEE");
		new Label(composite_1, SWT.NONE);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
