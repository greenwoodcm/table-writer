package tablewriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;

public class TableWriter extends PrintWriter{
    
    // The default behavior for the table is 10 16-char string columns
    int[] columnWidth = new int[]{
        16,
        16,
        16,
        16,
        16,
        16,
        16,
        16,
        16,
        16
    };
    
    private int columnCounter = 0;
    private String columnDelim = " | ";

    public TableWriter(File f) throws FileNotFoundException{ super(f); }
    public TableWriter(OutputStream s){ super(s); }
    
    public void setColumnCount(int c)
    {
        int[] newWidths = new int[c];
        System.arraycopy(columnWidth, 0, newWidths, 0, 
                Math.min(c,columnWidth.length));
        columnWidth = newWidths;
    }
    
    public void setWidthForColumn(int index, int width)
    {
        columnWidth[index] = width;
    }
    
    public void setColumnDelimiter(String delim)
    {
        this.columnDelim = delim;
    }
    
    public void printColumn(String s)
    {
        if(s.length() > columnWidth[columnCounter])
            s = s.substring(0, columnWidth[columnCounter]);
        
        String cell = StringUtils.leftPad(s, columnWidth[columnCounter]);
        this.print(cell + columnDelim);
    }
    
    public void endRow()
    {
        this.print("\n");
        columnCounter = 0;
    }
}