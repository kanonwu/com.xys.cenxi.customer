package com.xys.cenxi.customer.ui.component.rating;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import de.kupzog.ktable.KTableCellEditor;
import de.kupzog.ktable.KTableCellRenderer;
import de.kupzog.ktable.KTableDefaultModel;
import de.kupzog.ktable.SWTX;
import de.kupzog.ktable.editors.KTableCellEditorComboText;
import de.kupzog.ktable.renderers.FixedCellRenderer;
import de.kupzog.ktable.renderers.TextCellRenderer;

public class RatingTableModel extends KTableDefaultModel{
	
	
    private final FixedCellRenderer fixedRenderer =
            new FixedCellRenderer(FixedCellRenderer.STYLE_FLAT  |
                TextCellRenderer.INDICATION_FOCUS_ROW);
        
        private final TextCellRenderer textRenderer = 
            new TextCellRenderer(TextCellRenderer.INDICATION_FOCUS_ROW);
        
        public RatingTableModel() {
        	fixedRenderer.setAlignment(SWTX.ALIGN_HORIZONTAL_CENTER | SWTX.ALIGN_VERTICAL_CENTER);
        	fixedRenderer.setFont(new Font(Display.getDefault(), "宋体", 14, SWT.NONE));
		}

	@Override
	public int getFixedHeaderRowCount() {
		return 2;
	}

	@Override
	public int getFixedSelectableRowCount() {
		return 2;
	}

	@Override
	public int getFixedHeaderColumnCount() {
		return 0;
	}

	@Override
	public int getFixedSelectableColumnCount() {
		return 0;
	}

	@Override
	public boolean isColumnResizable(int col) {
		return true;
	}

	@Override
	public boolean isRowResizable(int row) {
		return true;
	}

	@Override
	public int getRowHeightMinimum() {
		return 20;
	}

	@Override
	public int getInitialColumnWidth(int column) {
		return 40;
	}

	@Override
	public int getInitialRowHeight(int row) {
		return 20;
	}

	@Override
	public Object doGetContentAt(int col, int row) {
		if(col == 0 && row == 0){
			return "标准及评分";
		}
		if(col == 0 && row == 1){
			return "序号";
		}
		if(col == 1 && row == 1){
			return "项目";
		}
		if(col == 2 && row == 1){
			return "计分标准";
		}
		if(col == 3 && row == 1){
			return "分值";
		}
		if(col == 4 && row == 1){
			return "初评";
		}
		if(col == 5 && row == 1){
			return "复评";
		}
		if(col == 6 && row == 1){
			return "复评";
		}
		
		//第1项 户口性质
		if(col == 0 && row == 2){
			return "1";
		}
		if(col == 1 && row == 2){
			return "";
		}
		if(col == 2 && row == 2){
			return "户口性质";
		}
		if(col == 3 && row == 2){
			return "常住人口";
		}
		if(col == 4 && row == 2){
			return "3";
		}
		if(col == 5 && row == 2){
			return "";
		}
		if(col == 0 && row == 2){
			return "";
		}
		if(col == 3 && row == 3){
			return "不是常住人口";
		}
		if(col == 4 && row == 3){
			return "0";
		}
		
		return "";
	}

	@Override
	public KTableCellEditor doGetCellEditor(int col, int row) {
		if(col - 5 >= 0 && row == 2){
            KTableCellEditorComboText e = new KTableCellEditorComboText();
            e.setItems(new String[] { "3", "0" });
            return e;
		}
		return null;
	}

	@Override
	public void doSetContentAt(int col, int row, Object value) {
	}

	@Override
	public KTableCellRenderer doGetCellRenderer(int col, int row) {
        if (isFixedCell(col, row)){
        	return fixedRenderer;
        }
        
        return textRenderer;
	}

	@Override
	public int doGetRowCount() {
		return 10;
	}

	@Override
	public int doGetColumnCount() {
		return 7;
	}
	
	@Override
	public Point doBelongsToCell(int col, int row) {
		if(row == 0){
			return new Point(0, 0);
		}
		
		return super.doBelongsToCell(col, row);
	}

}
