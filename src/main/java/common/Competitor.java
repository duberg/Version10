package common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class Competitor extends Workbook {
    int result2;


    public int getRowNum(int sheetNum) {
        int rowCount2 = 0;
        try {
            String excelFilePath = "Competition.xlsx";
            FileInputStream inputStream2 = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook2 = new XSSFWorkbook(inputStream2);
            XSSFSheet getSheetRow = workbook2.getSheetAt(sheetNum);
            rowCount2 = getSheetRow.getLastRowNum();
           inputStream2.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rowCount2);
        return rowCount2;
    }

    public int assignIDToCompetitor(int iD) {
        try {
            String excelFilePath = "Competition.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet firstSheet = workbook.getSheetAt(0);
            int rowCount = firstSheet.getLastRowNum();
            Row row2 = firstSheet.createRow(rowCount);
            int columnCount = 1;
            Cell cell2 = row2.createCell(columnCount);
            cell2.setCellValue(iD);
            firstSheet.autoSizeColumn(columnCount);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
            workbook.write(outputStream);
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iD;
    }

    public String getUserFirstName(String firstName, int sheetNum) {
        try {

            String excelFilePath = "Competition.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet firstSheet = workbook.getSheetAt(sheetNum);
            int rowCount = firstSheet.getLastRowNum();
            Row row2 = firstSheet.getRow(rowCount);
            int columnCount = 2;
            Cell cell2 = row2.createCell(columnCount);
            cell2.setCellValue(firstName);
            firstSheet.autoSizeColumn(columnCount);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
            workbook.write(outputStream);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstName;
    }

    public String getUserLastName(String lastName, int sheetNum) {
        try {
            String excelFilePath = "Competition.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);


            XSSFSheet firstSheet = workbook.getSheetAt(sheetNum);
            int rowCount = firstSheet.getLastRowNum();
            int columnCount = 3;
            Row row2 = firstSheet.getRow(rowCount);
            Cell cell2 = row2.createCell(columnCount);
            cell2.setCellValue(lastName);


            firstSheet.autoSizeColumn(columnCount);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
            workbook.write(outputStream);
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastName;
    }

    public int getUserSsn(int ssn, int sheetNum) {
        try {
            String excelFilePath = "Competition.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet firstSheet = workbook.getSheetAt(sheetNum);
            int rowCount = firstSheet.getLastRowNum();
            int columnCount = 4;
            Row row2 = firstSheet.getRow(rowCount);
            Cell cell2 = row2.createCell(columnCount);
            cell2.setCellValue(ssn);
            firstSheet.autoSizeColumn(columnCount);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
            workbook.write(outputStream);
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ssn;
    }

    public String getUserGender(String gender, int sheetNum) {
        int rowCount = 0;
        try {
            String excelFilePath = "Competition.xlsx";
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet firstSheet = workbook.getSheetAt(sheetNum);
            rowCount = firstSheet.getLastRowNum();
            int columnCount = 0;
            Row row2 = firstSheet.createRow(++rowCount);
            Cell cell2 = row2.createCell(columnCount);
            cell2.setCellValue(gender);
            firstSheet.autoSizeColumn(columnCount);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
            workbook.write(outputStream);
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gender;
    }


}

