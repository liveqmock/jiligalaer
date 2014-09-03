package sy.ext.extreme.cell;

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.cell.AbstractCell;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.limit.Limit;

/**
 *
 * @author lidongbo
 *
 */
public class RowNumberCell extends AbstractCell{
	
	@Override
	protected String getCellValue(TableModel model, Column column) {
		Limit limit = model.getLimit();
        int rowcount = ((limit.getPage() - 1) 
                * limit.getCurrentRowsDisplayed()) 
                + model.getRowHandler().getRow().getRowCount();
        return String.valueOf(rowcount);
    }


}
