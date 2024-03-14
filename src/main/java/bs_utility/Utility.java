package bs_utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookProvider;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Utility{

    public static long PAGE_LOAD_TIMEOUT = 5;
    public static long IMPLICITLY_WAIT = 2;

    public static String TestDataPath = "C:\\Users\\www.abcom.in\\IdeaProjects\\Bookswagon\\src\\main\\java\\bs_testdata\\loginCredentials.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TestDataPath);
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                data[i][j] = row.getCell(j).toString();
            }
        }

        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}