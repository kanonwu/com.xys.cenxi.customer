package com.xys.cenxi.customer.ui.ribbon.action;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;

import com.xys.cenxi.customer.ui.component.user.ModifyUserDialog;

public class ModifyUserAction implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		//�������޸Ľ���
		ModifyUserDialog dia = new ModifyUserDialog(Display.getDefault().getActiveShell());
//		Window.setDefaultImage(SWTResourceManager.getImage(SettingTab.class, "/icons/nnh_16.png"));
//		TestGrid dia = new TestGrid(Display.getDefault().getActiveShell());
		dia.open();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
