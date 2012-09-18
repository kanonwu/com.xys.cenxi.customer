package com.xys.cenxi.customer.ui.ribbon;

import org.eclipse.wb.swt.SWTResourceManager;

import com.hexapixel.widgets.ribbon.RibbonButton;
import com.hexapixel.widgets.ribbon.RibbonGroup;
import com.hexapixel.widgets.ribbon.RibbonTab;
import com.hexapixel.widgets.ribbon.RibbonTabFolder;
import com.hexapixel.widgets.ribbon.RibbonTooltip;
import com.xys.cenxi.customer.ui.ribbon.action.ExportAction;
import com.xys.cenxi.customer.ui.ribbon.action.ImportAction;

public class DataTab {
	
	private final RibbonTabFolder parent;
	
	private final String name = "����";
	
	private RibbonTab rtData;
	
	private RibbonGroup rgExpImp;
	
	
	private RibbonButton rbExport;
	
	private RibbonButton rbImport;
	
	
	public DataTab(RibbonTabFolder parent) {
		this.parent = parent;
	}
	
	public  void createContent(){
		rtData = new RibbonTab(parent, name);
		
		rgExpImp = new RibbonGroup(rtData, "����");
		rbExport = new RibbonButton(rgExpImp, null, "����", RibbonButton.STYLE_NO_DEPRESS);
		rbExport.setImage(SWTResourceManager.getImage(SettingTab.class, "/icons/export.png"));
		RibbonTooltip rtt = new RibbonTooltip("����", "����ȫ�����ݣ��������ݺϲ���");
		rbExport.setToolTip(rtt);
		rbImport = new RibbonButton(rgExpImp, null, " ���� ", RibbonButton.STYLE_NO_DEPRESS);
		rbImport.setImage(SWTResourceManager.getImage(SettingTab.class, "/icons/import.png"));
		RibbonTooltip impRtt = new RibbonTooltip("����", "�������ݣ�������ļ���׺Ϊ��.nhh����");
		rbImport.setToolTip(impRtt);
		initAction();
	}

	private void initAction(){
//		rbExport.addSelectionListener();
		rbExport.addSelectionListener(new ExportAction());
		rbImport.addSelectionListener(new ImportAction());
	}
}
