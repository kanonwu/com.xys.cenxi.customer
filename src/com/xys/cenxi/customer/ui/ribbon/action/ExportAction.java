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

import com.xys.cenxi.customer.data.DataService;
import com.xys.cenxi.customer.util.UIUtil;
import com.xys.cenxi.customer.util.Util;

public class ExportAction implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		//���ļ��Ի���
		FileDialog fd = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
		fd.setText("�����ļ�");
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
			UIUtil.showMessage("������ɣ��ļ����浽��" + filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
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
