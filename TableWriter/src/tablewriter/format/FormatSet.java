package tablewriter.format;

import java.util.HashSet;
import java.util.Set;
import tablewriter.format.TableWriterFormat.ContentType;

public class FormatSet {

    Set<RowFormat> rowFormats;
    Set<ColumnFormat> colFormats;
    Set<CellFormat> cellFormats;
    
    public FormatSet()
    {
        rowFormats = new HashSet<RowFormat>();
        colFormats = new HashSet<ColumnFormat>();
        cellFormats = new HashSet<CellFormat>();
    }
    
    public CellFormat formatForCell(int row, int col)
    {
        // order of precedence of formats:
        //  -   cell
        //  -   column
        //  -   row
        
        CellFormat cellFmt  = getCellFmt(row, col);
        ColumnFormat colFmt = getColFmt(col);
        RowFormat rowFmt    = getRowFmt(row);
        
        ContentType type;
        if(cellFmt != null)
            type = cellFmt.getType();
        else if(colFmt != null)
            type = colFmt.getType();
        else if(rowFmt != null)
            type = rowFmt.getType();
        else
            type = ContentType.STRING;
        
        CellFormat toRet = new CellFormat(row, col, type);
        
        return toRet;
    }
    
    private ColumnFormat getColFmt(int col)
    {
        for(ColumnFormat fmt : colFormats)
        {
            if(fmt.getCol() == col) return fmt;
        }
        return null;
    }
    
    private RowFormat getRowFmt(int row)
    {
        for(RowFormat fmt : rowFormats)
        {
            if(fmt.getRow() == row) return fmt;
        }
        return null;
    }
    
    private CellFormat getCellFmt(int row, int col)
    {
        for(CellFormat fmt : cellFormats)
        {
            if(fmt.getRow() == row && fmt.getCol() == col) return fmt;
        }
        return null;
    }
}