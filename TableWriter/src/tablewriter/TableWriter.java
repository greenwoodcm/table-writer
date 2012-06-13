package tablewriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TableWriter extends PrintWriter{
    
    // The default behavior for the table is 10 16-char string columns
    String[] fmtStrings = new String[]{
        "%16s",
        "%16s",
        "%16s",
        "%16s",
        "%16s",
        "%16s",
        "%16s",
        "%16s",
        "%16s",
        "%16s",
    };
    
    private int columnCounter = 0;
    private String columnDelim = " | ";

    public TableWriter(File f) throws FileNotFoundException{ super(f); }
    public TableWriter(OutputStream s){ super(s); }
    
    public void setColumnCount(int c)
    {
        String[] newFmt = new String[c];
        System.arraycopy(fmtStrings, 0, newFmt, 0, 
                Math.min(c,fmtStrings.length));
        fmtStrings = newFmt;
    }
    
    public void setFormatForColumn(int index, String fmt)
    {
        fmtStrings[index] = fmt;
    }
    
    public void setColumnDelimiter(String delim)
    {
        this.columnDelim = delim;
    }
    
    public void printColumn(String s)
    {
        String fmt = fmtStrings[columnCounter++] + columnDelim;
        this.format(fmt, s);
    }
    
    public void endRow()
    {
        this.print("\n");
        columnCounter = 0;
    }
}