package com.xys.cenxi.customer.ui.ribbon.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
import com.xys.cenxi.customer.util.Util;

public class ExportAction implements SelectionListener {
	
	private static Logger log = LoggerFactory.getLogger(ExportAction.class);

	@Override
	public void widgetSelected(SelectionEvent e) {
		//打开文件对话框
		FileDialog fd = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
		fd.setText("保存文件");
		Date time = new Date();
		String fileName = Util.DATETIME_SDF2.format(time);
		fileName += Util.EXP_FILE_NAME;
		fd.setFileName(fileName);
		String filePath = fd.open();
		if(filePath == null || filePath.length() < 2){
			return;
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			DataService.getInstance().exportData(fos);
			UIUtil.showMessage("导出完成，文件保存到：" + filePath);
		} catch (FileNotFoundException e1) {
			log.error("导出数据出错：", e1);
			UIUtil.showMessage("导出数据出错：" + e1.getMessage());
//			e1.printStackTrace();
		}catch (CusException e2){
			log.error("导出数据出错：", e2);
			UIUtil.showMessage(e2.getMessage());
		}finally{
			try {
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
