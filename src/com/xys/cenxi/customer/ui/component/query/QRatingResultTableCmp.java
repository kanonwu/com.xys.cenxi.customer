package com.xys.cenxi.customer.ui.component.query;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;

import com.xys.cenxi.customer.data.query.QueryRateResultKey;
import com.xys.cenxi.customer.pojo.query.QRateResultInfo;
import com.xys.cenxi.customer.ui.component.provider.QRateResultTableProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

public class QRatingResultTableCmp extends Composite {
	private Table table;
	private TableViewer tableViewer;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public QRatingResultTableCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		TableColumnLayout tcl_composite_1 = new TableColumnLayout();
		composite_1.setLayout(tcl_composite_1);
		
		tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				// 档案号
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.archivesID;
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn = tableViewerColumn.getColumn();
		tableColumn.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn, new ColumnPixelData(62, true, true));
		tableColumn.setText("\u6863\u6848\u53F7");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				//姓名
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.name;
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_1 = tableViewerColumn_1.getColumn();
		tableColumn_1.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_1, new ColumnPixelData(79, true, true));
		tableColumn_1.setText("\u59D3\u540D");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_2.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				// 身份证
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.identify;
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_2 = tableViewerColumn_2.getColumn();
		tableColumn_2.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_2, new ColumnPixelData(150, true, true));
		tableColumn_2.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_3.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				//行政区域
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.regional;
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_3 = tableViewerColumn_3.getColumn();
		tableColumn_3.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_3, new ColumnPixelData(150, true, true));
		tableColumn_3.setText("\u884C\u653F\u533A\u5212");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_4.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				// 初评分值
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.firstValue == null ? "" : info.firstValue.toString();
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_4 = tableViewerColumn_4.getColumn();
		tableColumn_4.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_4, new ColumnPixelData(67, true, true));
		tableColumn_4.setText("\u521D\u8BC4\u5206\u503C");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_5.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				// 复评分值
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.secondValue == null ? "" : info.secondValue.toString();
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_5 = tableViewerColumn_5.getColumn();
		tableColumn_5.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_5, new ColumnPixelData(56, true, true));
		tableColumn_5.setText("\u590D\u8BC4\u5206\u503C");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_6.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				//初评等级
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.firstLevel;
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_6 = tableViewerColumn_6.getColumn();
		tableColumn_6.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_6, new ColumnPixelData(65, true, true));
		tableColumn_6.setText("\u521D\u8BC4\u7B49\u7EA7");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn_7.setLabelProvider(new ColumnLabelProvider() {
			public Image getImage(Object element) {
				return null;
			}
			public String getText(Object element) {
				//复评等级
				if(element instanceof QRateResultInfo){
					QRateResultInfo info = (QRateResultInfo) element;
					return info.secondLevel;
				}else{
					return element == null ? "" : element.toString();
				}
			}
		});
		TableColumn tableColumn_7 = tableViewerColumn_7.getColumn();
		tableColumn_7.setAlignment(SWT.CENTER);
		tcl_composite_1.setColumnData(tableColumn_7, new ColumnPixelData(61, true, true));
		tableColumn_7.setText("\u590D\u8BC4\u7B49\u7EA7");
		tableViewer.setContentProvider(new QRateResultTableProvider());

	}
	

	public void reloadData(QueryRateResultKey key){
		tableViewer.setInput(key);
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
