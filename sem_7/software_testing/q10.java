// Check off module-info option while making project
// Add paths correctly to excel sheets and add build path -> selenium and jar files
import java.io.FileInputStream;
import java.io.FileOutputStream;
import jxl.*;
import org.testng.annotations.*;

public class ExcelTest {
    @Test
    public void testImportExport() throws Exception {
        String inputFile = "C:\\Users\\ST AND AUTO LAB\\excel\\Students.xls";
        String outputFile = "C:\\Users\\ST AND AUTO LAB\\excel\\Result.xls";

        FileInputStream fi = new FileInputStream(inputFile);
        Workbook w = Workbook.getWorkbook(fi);
        Sheet s = w.getSheet(0);

        FileOutputStream fo = new FileOutputStream(outputFile);
        WritableWorkbook wwb = Workbook.createWorkbook(fo);
        WritableSheet ws = wwb.createSheet("result1", 0);

        for (int i = 0; i < s.getRows(); i++) {
            for (int j = 0; j < s.getColumns(); j++) {
                String content = s.getCell(j, i).getContents();
                Label label = new Label(j, i, content);
                ws.addCell(label);
            }
        }

        Label res = new Label(6, 0, "Result");
        ws.addCell(res);

        for (int i = 1; i < s.getRows(); i++) {
            for (int j = 2; j < s.getColumns(); j++) {
                int score = Integer.parseInt(s.getCell(j, i).getContents());
                Label resultLabel = new Label(6, i, (score > 35) ? "pass" : "fail");
                ws.addCell(resultLabel);
                if (score <= 35) {
                    break;
                }
            }
        }
        System.out.println("Records successfully updated ");
        wwb.write();
        wwb.close();
    }
}