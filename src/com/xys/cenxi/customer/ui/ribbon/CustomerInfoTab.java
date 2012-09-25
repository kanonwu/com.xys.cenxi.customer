package com.xys.cenxi.customer.ui.ribbon;

import org.eclipse.wb.swt.SWTResourceManager;

import com.hexapixel.widgets.ribbon.RibbonButton;
import com.hexapixel.widgets.ribbon.RibbonGroup;
import com.hexapixel.widgets.ribbon.RibbonTab;
import com.hexapixel.widgets.ribbon.RibbonTabFolder;
import com.xys.cenxi.customer.ui.ribbon.action.CustomerMgrAction;
import com.xys.cenxi.customer.ui.ribbon.action.QueryRateAction;

public class CustomerInfoTab {
	
	private final RibbonTabFolder parent;
	
	private final String name = "�ͻ���Ϣ";
	
	private RibbonTab rtCustom;
	
	private RibbonGroup rgFarmerInfo;
	
	private RibbonButton rbFarmerInfo;
	
	private RibbonGroup rgRate;
	
//	private RibbonButtonGroup rbgRate;
	
	private RibbonButton rbRateQuery;
	
	public CustomerInfoTab(RibbonTabFolder parent) {
		this.parent = parent;
	}
	
	public  void createContent(){
		rtCustom = new RibbonTab(parent, name);
		
		rgFarmerInfo = new RibbonGroup(rtCustom, "ũ����Ϣ");
		rbFarmerInfo = new RibbonButton(rgFarmerInfo, SWTResourceManager.getImage(CustomerInfoTab.class, "/icons/customer_info.png"),
				"ũ����Ϣ", RibbonButton.STYLE_NO_DEPRESS);
		
		rgRate = new RibbonGroup(rtCustom, "���ֲ�ѯ");
//		rbgRate = new RibbonButtonGroup(rgRate);
		rbRateQuery = new RibbonButton(rgRate, SWTResourceManager.getImage(CustomerInfoTab.class, "/icons/rate_query.png"),
				"���ֽ����ѯ", RibbonButton.STYLE_NO_DEPRESS);
		
		initAction();
	}

	private void initAction(){
		rbFarmerInfo.addSelectionListener(new CustomerMgrAction());
		rbRateQuery.addSelectionListener(new QueryRateAction());
	}
}
