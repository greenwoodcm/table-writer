package tablewriter.format;

public class RowFormat extends TableWriterFormat{
    
    private int row;
    
    
    public RowFormat(int r)
    {
        super();
        row = r;
    }
    
    public RowFormat(int r, int h)
    {
        super();
        row = r;
        height = h;
    }
    
    public RowFormat(int r, ContentType t)
    {
        super(t);
        row = r;
    }

    public int getRow() {
        return row;
    }

    public int getHeight() {
        return height;
    }

}