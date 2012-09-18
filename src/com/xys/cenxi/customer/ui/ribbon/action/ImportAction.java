package com.xys.cenxi.customer.ui.ribbon.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xys.cenxi.customer.data.DataService;
import com.xys.cenxi.customer.exception.CusException;
import com.xys.cenxi.customer.util.UIUtil;

public class ImportAction implements SelectionListener {

	private static Logger log = LoggerFactory.getLogger(ImportAction.class);
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		//打开文件对话框
		FileDialog fd = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
		fd.setText("选择导入文件");
		fd.setFilterExtensions(new String[]{"*.nhh"});
		String filePath = fd.open();
		if(filePath == null || filePath.length() < 2){
			return;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			DataService.getInstance().importData(fis);
			UIUtil.showMessage("导入完成，数据已更新，请重新查询数据。");
		} catch (FileNotFoundException e1) {
			log.error("导入数据出错：", e1);
			UIUtil.showMessage("导入数据出错：文件不存在，或者文件类型不对。");
		} catch(CusException e2){
			log.error(e2.getMessage(), e2);
			UIUtil.showMessage(e2.getMessage());
		}finally{
			try {
				fis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
