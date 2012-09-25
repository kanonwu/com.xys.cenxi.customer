package com.xys.cenxi.customer.ui.component.query;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

import com.xys.cenxi.customer.data.query.PagerInfo;
import com.xys.cenxi.customer.data.query.QueryRateResultKey;
import com.xys.cenxi.customer.ui.pagination.PageChangedEvent;
import com.xys.cenxi.customer.ui.pagination.PageChangedListener;
import com.xys.cenxi.customer.ui.pagination.PagerBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class QRatingResultMgrCmp extends Composite {
	
	public static final String NAME = "评分结果查询";
	private QRatingResultTableCmp ratingResultTableCmp;
	private PagerBar pagerBar;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public QRatingResultMgrCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.BORDER | SWT.SMOOTH);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		queryRatingResultCndCmp = new QueryRatingResultCndCmp(composite, SWT.NONE);
		GridData gd_queryRatingResultCndCmp = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_queryRatingResultCndCmp.widthHint = 193;
		queryRatingResultCndCmp.setLayoutData(gd_queryRatingResultCndCmp);
		
		btnQuery = new Button(composite, SWT.NONE);
		btnQuery.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doQuery();
			}
		});
		btnQuery.setImage(SWTResourceManager.getImage(QRatingResultMgrCmp.class, "/icons/photo.gif"));
		btnQuery.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnQuery.setText("\u67E5\u8BE2");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite_1 = new Composite(scrolledComposite, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		
		ratingResultTableCmp = new QRatingResultTableCmp(composite_1, SWT.NONE);
		ratingResultTableCmp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group group = new Group(composite_1, SWT.NONE);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		pagerBar = new PagerBar(group, PagerBar.GOOGLE_STYLE, 0, 30, 1);
		pagerBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		pagerBar.addPageChangedListener(new PageChangedListener() {
			public void pageChanged(PageChangedEvent e) {
				pageChange(e.getPager().getPageIndex());
			}
		});
		pagerBar.setRecordCount(0);
		scrolledComposite.setContent(composite_1);
		scrolledComposite.setMinSize(composite_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		sashForm.setWeights(new int[] {1, 3});

	}
	
	protected void doQuery() {
		PagerInfo info = new PagerInfo();
		info.setPageNumber(1);
		info.setPageSize(PAGE_SIZE);
		query(info);
		refreshPager(info);
	}

	private void refreshPager(PagerInfo info) {
		pagerBar.reset(info.getRecordCount(), info.getPageSize(), info.getPageNumber());
	}

	private QueryRateResultKey queryKey;
	private QueryRatingResultCndCmp queryRatingResultCndCmp;
	private Button btnQuery;
	
	private static int PAGE_SIZE = 30;

	protected void pageChange(int pageIndex) {
		if(queryKey == null || queryKey.pagerInfo == null){
			return;
		}
		
		queryKey.pagerInfo.setPageNumber(pageIndex);
		query(queryKey.pagerInfo);
	}

	private void query(PagerInfo pagerInfo) {
		queryKey = queryRatingResultCndCmp.getQueryKey();
		queryKey.pagerInfo = pagerInfo;

		ratingResultTableCmp.reloadData(queryKey);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
