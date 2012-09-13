package com.xys.cenxi.customer.ui.component.rating;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.widgets.grid.GridCellRenderer;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridColumnGroup;
import org.eclipse.nebula.widgets.grid.GridEditor;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.nebula.jface.gridviewer.GridViewerColumn;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import de.kupzog.ktable.KTable;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;

public class RatingCmp extends Composite {
	private KTable table;
	private Table table_1;
	private static class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RatingCmp(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group group = new Group(this, SWT.NONE);
		group.setText("\u6807\u51C6\u53CA\u8BC4\u5206");
		group.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new KTable(group, SWT.NONE);
		
		Composite composite = new Composite(table, SWT.NONE);
		composite.setBounds(349, 101, 64, 64);
		composite.setLayout(new TableColumnLayout());
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer.getTable();
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		createTable();
	}
	
	private void createTable(){
		table.setModel(new RatingTableModel());
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
