package com.xys.cenxi.customer.ui.component.user;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.xys.cenxi.customer.data.UserService;
import com.xys.cenxi.customer.pojo.User;
import com.xys.cenxi.customer.start.Content;
import com.xys.cenxi.customer.util.UIUtil;
import com.xys.cenxi.customer.util.Util;

public class ModifyUserDialog extends Dialog {
	private Text textOldName;
	private Text textName;
	private Text textPw;
	private Text textPw2;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ModifyUserDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.APPLICATION_MODAL);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		Label label = new Label(container, SWT.NONE);
		label.setBounds(133, 30, 48, 17);
		label.setText("\u65E7\u7528\u6237\uFF1A");
		
		textOldName = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		textOldName.setBounds(186, 27, 157, 23);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setBounds(133, 58, 48, 17);
		label_1.setText("\u65B0\u7528\u6237\uFF1A");
		
		textName = new Text(container, SWT.BORDER);
		textName.setBounds(186, 55, 157, 23);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setBounds(145, 86, 36, 17);
		label_2.setText("\u5BC6\u7801\uFF1A");
		
		textPw = new Text(container, SWT.BORDER | SWT.PASSWORD);
		textPw.setBounds(186, 83, 157, 23);
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setBounds(121, 114, 60, 17);
		label_3.setText("\u518D\u8F93\u4E00\u6B21\uFF1A");
		
		textPw2 = new Text(container, SWT.BORDER | SWT.PASSWORD);
		textPw2.setBounds(186, 111, 157, 23);

		initUser();
		return container;
	}

	private void initUser() {
		user = Content.getUser();
		setUser(user);
		getShell().setText("修改用户名密码");
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "\u786E\u5B9A",
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				"\u53D6\u6D88", false);
	}
	
	private User user;
	
	private void setUser(User user){
		this.user = user;
		if(this.user != null){
			textOldName.setText(user.getName());
		}
		textName.setFocus();
	}
	
	@Override
	protected void okPressed() {
		if(Util.isEmpty(textName.getText())){
			UIUtil.showMessage("请输入用户名。");
			return;
		}
		
		if(Util.isEmpty(textPw.getText())){
			UIUtil.showMessage("请输入密码。");
			textPw.setFocus();
			return;
		}
		if(Util.isEmpty(textPw2.getText())){
			UIUtil.showMessage("请再输入一次密码。");
			textPw.setFocus();
			return;
		}
		
		String pw1 = textPw.getText();
		String pw2 = textPw2.getText();
		if(!pw1.equals(pw2)){
			UIUtil.showMessage("两次输入的密码不一致。");
			textPw.setFocus();
			return;
		}
		
		user.setName(textName.getText());
		user.setPassWord(pw1);
		UserService.getInstance().update(user);
		
		UIUtil.showMessage("修改完成。");
		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 238);
	}

}
