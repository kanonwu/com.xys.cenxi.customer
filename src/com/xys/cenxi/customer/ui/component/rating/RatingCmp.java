package com.xys.cenxi.customer.ui.component.rating;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import com.xys.cenxi.customer.data.RatingService;
import com.xys.cenxi.customer.pojo.Customer;
import com.xys.cenxi.customer.pojo.RateResult;
import com.xys.cenxi.customer.util.UIUtil;

public class RatingCmp extends Composite {
	private Button btnSave;
	private RatingDetailCmp ratingDetailCmp;
	private BasicInfoCmp basicInfoCmp;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RatingCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		basicInfoCmp = new BasicInfoCmp(composite, SWT.NONE);
		
		ratingDetailCmp = new RatingDetailCmp(composite, SWT.NONE);
		
		btnSave = new Button(composite, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doSave();
			}
		});
		btnSave.setImage(SWTResourceManager.getImage(RatingCmp.class, "/icons/save.gif"));
		GridData gd_btnSave = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnSave.widthHint = 132;
		btnSave.setLayoutData(gd_btnSave);
		btnSave.setText("\u4FDD\u5B58");
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}
	

	private Customer customer;
	
	/**
	 * 保存评分结果
	 */
	protected void doSave() {
		if(customer == null){
			btnSave.setEnabled(false);
			return;
		}
		RateResult result = ratingDetailCmp.getRateResult();
		RatingService.getInstance().updateResult(result);
		UIUtil.showMessage("保存完成。");
	}

	public void setCustomer(Customer cus){
		if(cus == null){
			btnSave.setEnabled(false);
		}else{
			btnSave.setEnabled(true);
		}
		this.customer = cus;
		basicInfoCmp.setCustomer(customer);
		ratingDetailCmp.setCustomer(customer);
	}

	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
