package tablewriter.format;

public class ColumnFormat extends TableWriterFormat{

    private int col;
    private int width = 10;     // default is 10
    
    public ColumnFormat(int c)
    {
        super();
        col = c;
    }
    
    public ColumnFormat(int c, int w)
    {
        super();
        col = c;
        width = w;
    }
    
    public ColumnFormat(int c, ContentType t)
    {
        super(t);
        col = c;
    }

    public int getCol() {
        return col;
    }

    public int getWith() {
        return width;
    }
}