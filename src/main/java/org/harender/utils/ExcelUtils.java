package org.harender.utils;



import com.google.common.collect.Table;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static List<Object[]> readTestData(String sheetName) {
        List<Object[]> data = new ArrayList<>();

        try (InputStream input = ExcelUtils.class.getClassLoader().getResourceAsStream("testdata.xlsx")) {
            if (input == null) {
                System.out.println("Sorry, unable to find testdata.xlsx");
                return data;
            }



            XSSFWorkbook workbook = new XSSFWorkbook(input);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //Iterator<Table.Cell> cellIterator = row.cellIterator();
                Iterator<Cell> cellIterator = row.cellIterator();

                List<Object> rowData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowData.add(cell.toString());
                }
                data.add(rowData.toArray());
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}
