import java.io.FileInputStream;
import java.io.FileOutputStream;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.annotations.*;
public class excel {
    @BeforeClass //@BeforeClass runs once before the entire test.
    public void setUp() throws Exception {}
    @Test
    public void testImportexport1() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\ST AND AUTOLAB\\excel\\Students.xls");
        Workbook w = Workbook.getWorkbook(fi);
        Sheet s = w.getSheet(0);
        String a[][] = new String[s.getRows()][s.getColumns()];
        FileOutputStream fo = new FileOutputStream("C:\\Users \\ST AND AUTOLAB\\excel\\Result.xls");
        WritableWorkbook wwb = Workbook.createWorkbook(fo);
        WritableSheet ws = wwb.createSheet("result1", 0);
        for (int i = 0; i < s.getRows(); i++)
            for (int j = 0; j < s.getColumns(); j++){
                a[i][j] = s.getCell(j, i).getContents();
                Label l2 = new Label(j, i, a[i][j]);
                ws.addCell(l2);
                Label l1 = new Label(6, 0, "Result");
                ws.addCell(l1);
            }
            for (int i = 1; i < s.getRows(); i++) {
                for (int j = 2; j < s.getColumns(); j++){
                    a[i][j] = s.getCell(j, i).getContents();
                    int x=Integer.parseInt(a[i][j]);
                    if(x > 35){
                        Label l1 = new Label(6, i, "pass");
                        ws.addCell(l1);
                    }
                    else{
                        Label l1 = new Label(6, i, "fail");
                        ws.addCell(l1);
                        break;
                    }
                }
                System.out.println("Records sucessfully updated ");
            }
        wwb.write();
        wwb.close();
    }
}
