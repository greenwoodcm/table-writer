package tablewriter.format;

public class CellFormat extends TableWriterFormat{

    private int row;
    private int col;
    
    public CellFormat(int r, int c){ 
        super();
        row = r;
        col = c;
    }
    
    public CellFormat(int r, int c, ContentType t)
    {
        super(t);
        row = r;
        col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}