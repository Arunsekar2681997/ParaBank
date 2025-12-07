package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

    public static Object[][] readData(String dataFile, String testCaseName) throws IOException {

        FileInputStream fis = new FileInputStream("./dataSheet/" + dataFile + ".xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        List<Object[]> list = new ArrayList<Object[]>();

        int lastRow = sheet.getLastRowNum();

        for (int i = 1; i <= lastRow; i++) {

            Row row = sheet.getRow(i);
            if (row == null) continue;

            Cell tcCell = row.getCell(0);
            if (tcCell == null) continue;

            String tc = tcCell.toString().trim();
            if (!tc.equalsIgnoreCase(testCaseName)) continue;

            int lastCol = row.getLastCellNum();  // includes blank columns

            List<Object> rowValues = new ArrayList<Object>();

            for (int j = 1; j < lastCol; j++) {

                Cell cell = row.getCell(j);
                if (cell == null) continue;   // skip empty

                String value = cell.toString().trim();
                if (!value.isEmpty()) {       // remove blank cells
                    rowValues.add(value);
                }
            }

            list.add(rowValues.toArray(new Object[0]));
        }

        wb.close();
        fis.close();

        return list.toArray(new Object[0][]);
    }
}
