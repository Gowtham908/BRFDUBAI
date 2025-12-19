package com.bornfire.xbrl.excelinsert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ExcelMacroExample {

    @Autowired
    private Environment env;

    public void applyInsert(String inputFile) {
        String outputPath = env.getProperty("output.exportpath");
        String outputFileInsert = outputPath + File.separator + "insertedOutput.xlsm";

        try (FileInputStream fis = new FileInputStream(new File(inputFile));
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

         
            insertRow(sheet, sheet.getLastRowNum() + 1);

            try (FileOutputStream fos = new FileOutputStream(new File(outputFileInsert))) {
                workbook.write(fos);
            }

            System.out.println("Excel file with macros for insert exported successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void applyDelete(String inputFile) {
        String outputPath = env.getProperty("output.exportpath");
        String outputFileInsert = outputPath + File.separator + "insertedOutput.xlsm";
        String outputFileDelete = outputPath + File.separator + "deletedOutput.xlsm";

        try (FileInputStream fis = new FileInputStream(new File(inputFile));
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            // Delete the last added row
            deleteRow(sheet, sheet.getLastRowNum() - 1);

            try (FileOutputStream fos = new FileOutputStream(new File(outputFileDelete))) {
                workbook.write(fos);
            }

            System.out.println("Excel file with macros for delete exported successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertRow(Sheet sheet, int rowIndex) {
        sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1, true, true);
        Row newRow = sheet.createRow(rowIndex);
        for (int colIndex = 0; colIndex < sheet.getRow(rowIndex + 1).getLastCellNum(); colIndex++) {
            Cell oldCell = sheet.getRow(rowIndex + 1).getCell(colIndex);
            if (oldCell != null) {
                Cell newCell = newRow.createCell(colIndex);
                newCell.setCellValue(oldCell.getStringCellValue());
            }
        }
    }

    private void deleteRow(Sheet sheet, int rowIndex) {
        sheet.shiftRows(rowIndex + 1, sheet.getLastRowNum(), -1, true, true);
    }
}
