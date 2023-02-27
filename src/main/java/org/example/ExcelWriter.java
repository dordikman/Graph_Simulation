package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelWriter {

    public static void writePVals(String fileName, String sheetName, List<Double> data) {
        try {
            File file = new File(fileName);
            XSSFWorkbook workbook;
            if (file.exists() && !file.isDirectory()) {
                // If the file already exists, read it first and create the sheet if it doesn't exist
                FileInputStream inputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(inputStream);
                inputStream.close();
            } else {
                // If the file does not exist, create a new workbook
                workbook = new XSSFWorkbook();
            }

            // Check if the sheet already exists in the workbook
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                // Create a new sheet with the given name if it doesn't exist
                sheet = workbook.createSheet(sheetName);
            }

            // Write the data to the sheet
            int rowCount = sheet.getLastRowNum();
            Row excelRow = sheet.createRow(++rowCount);
            int columnCount = 0;
            for (Double cellData : data) {
                Cell cell = excelRow.createCell(columnCount++);
                cell.setCellValue(cellData);
            }

            // Write the workbook to the Excel file
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeResults(String fileName, String sheetName, List<Integer> data) {
        try {
            File file = new File(fileName);
            XSSFWorkbook workbook;
            if (file.exists() && !file.isDirectory()) {
                // If the file already exists, read it first and create the sheet if it doesn't exist
                FileInputStream inputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(inputStream);
                inputStream.close();
            } else {
                // If the file does not exist, create a new workbook
                workbook = new XSSFWorkbook();
            }

            // Check if the sheet already exists in the workbook
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                // Create a new sheet with the given name if it doesn't exist
                sheet = workbook.createSheet(sheetName);
            }

            // Write the data to the sheet
            int rowCount = sheet.getLastRowNum();
            Row excelRow = sheet.createRow(++rowCount);
            int columnCount = 0;
            for (Integer cellData : data) {
                Cell cell = excelRow.createCell(columnCount++);
                cell.setCellValue(cellData);
            }

            // Write the workbook to the Excel file
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
            System.out.println(fileName + " deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }



}

