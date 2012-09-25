package com.xys.cenxi.customer.ui.ribbon.action;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.xys.cenxi.customer.start.AppMain;
import com.xys.cenxi.customer.start.Content;
import com.xys.cenxi.customer.ui.component.query.QRatingResultMgrCmp;

public class QueryRateAction implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		//打开评分结果查询界面
		AppMain main = Content.getAppMain();
		CTabFolder folder = main.getTabFolder();
		
		CTabItem tiCustomer = main.getTabItem(QRatingResultMgrCmp.NAME); 
		if(tiCustomer == null){
			tiCustomer = new CTabItem(folder, SWT.CLOSE);
			QRatingResultMgrCmp rateMgr = new QRatingResultMgrCmp(folder, SWT.NONE);
			tiCustomer.setControl(rateMgr);
			tiCustomer.setText(QRatingResultMgrCmp.NAME);
		}
		folder.setSelection(tiCustomer);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
