package tablewriter.format;

public class TableWriterFormat {

    public enum ContentType {
        STRING,
        INT,
        DOUBLE,
        OTHER
    };
    
    private ContentType type;
    protected int height;
    protected int width;
    
    public TableWriterFormat()
    {
        type = ContentType.OTHER;
    }
    
    public TableWriterFormat(ContentType t){ type = t; }
    
    public ContentType getType(){ return type; }
}