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
		//���ļ��Ի���
		FileDialog fd = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
		fd.setText("ѡ�����ļ�");
		fd.setFilterExtensions(new String[]{"*.nhh"});
		String filePath = fd.open();
		if(filePath == null || filePath.length() < 2){
			return;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			DataService.getInstance().importData(fis);
			UIUtil.showMessage("������ɣ������Ѹ��£������²�ѯ���ݡ�");
		} catch (FileNotFoundException e1) {
			log.error("�������ݳ���", e1);
			UIUtil.showMessage("�������ݳ����ļ������ڣ������ļ����Ͳ��ԡ�");
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
