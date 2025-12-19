package com.bornfire.xbrl.excelinsert;

import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelManipulation {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private HttpServletResponse response;
    private int rowCount = 0;
    public ExcelManipulation(HttpServletResponse response, List<String> headers) {
        this.response = response;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("011-BRF-085-A");

        XSSFRow headerRow = sheet.createRow(rowCount++);
        for (int i = 0; i < headers.size(); i++) {
            headerRow.createCell(i).setCellValue(headers.get(i));
        }
    }

    public void addRow(List<String> rowData) {
        XSSFRow newRow = sheet.createRow(rowCount++);
        for (int i = 0; i < rowData.size(); i++) {
            newRow.createCell(i).setCellValue(rowData.get(i));
        }
    }

    public void generateExcel(String fileName) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        OutputStream out = response.getOutputStream();
        workbook.write(out);
        workbook.close();
        out.flush();
    }
}