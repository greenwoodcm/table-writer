
package tablewriter.main;

import tablewriter.TableWriter;

/**
 *
 * @author greenwoodcm
 */
public class Main {


    public static void main(String[] args) {
        
        TableWriter writer = new TableWriter(System.out);
        
        writer.setColumnCount(5);
        
        writer.printColumn("Column a");
        writer.printColumn("Column b");
        writer.printColumn("Column b");
        writer.printColumn("Column d");
        writer.printColumn("Column e");
        
        writer.endRow();
        
        writer.printColumn("Other a");
        writer.printColumn("Other b");
        writer.printColumn("Other c");
        writer.printColumn("Other d");
        writer.printColumn("Other e");
        
        writer.flush();
    }
}
