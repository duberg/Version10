package common;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.*;


//import org.apache.poi.xssf.usermodel.extensions.*;

import java.io.*;
import java.util.Iterator;

public class Workbook {
    XSSFWorkbook workbook = new XSSFWorkbook();
    File tempFile = new File("Competition.xlsx");
    boolean exists = tempFile.exists();
    CellStyle cellStyle = workbook.createCellStyle();


    public void createWorkbook() {
        try {
            XSSFSheet spreadSheet = workbook.createSheet("Men");
            XSSFSheet secondSpreadSheet = workbook.createSheet("Women");
            String[] columnHeadsMen = {"Gender", "ID", "Name:", "Lastname:", "Ssn:"};
            String[] menBranches = {"100m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles", "Discus", "Pole vault", "Javelin", "1500 m"};
            String[] columnHeadsWomen = {"Gender", "ID", "Name:", "Lastname:", "Ssn:"};
            String[] womenBranches = {"100 m hurdles", "High jump", "Shot put", "200 m", "Long jump", "Javelin", "800 m"};

            Row headerRowMen = spreadSheet.createRow(0);
            Row headerRowWomen = secondSpreadSheet.createRow(0);
            Row genderResultsMen = spreadSheet.createRow(1);
            Row genderResultsWomen = secondSpreadSheet.createRow(1);

            //Competitor men loop
            for (int i = 0; i < columnHeadsMen.length; i++) {
                Cell cell = genderResultsMen.createCell(i);
                cell.setCellValue(columnHeadsMen[i]);
                spreadSheet.autoSizeColumn(i);
            }
            //Branches men
            int columnStart = 4;
            Cell cell3 = headerRowMen.createCell(columnStart);
            for (int i = 0; i < menBranches.length; i++) {
                int cellNum = headerRowMen.getLastCellNum();
                Cell cell = headerRowMen.createCell(cellNum);
                Cell cell2 = headerRowMen.createCell(cellNum + 1);
                cell.setCellValue(menBranches[i]);


                XSSFCellStyle style1 = workbook.createCellStyle();
                style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                XSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short) 12);
                font.setFontName("Verdana");
                font.setColor(IndexedColors.RED.getIndex());
                font.setBold(true);
                //font.setItalic(true);  
                //font.setStrikeout(true);
                //font.setUnderline((byte) 1);  // 1=normal or 2=double
                // Applying font to the style
                style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                style1.setFont(font);
                // Applying style to the cell  
                cell.setCellValue(menBranches[i]);
                CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, cellNum, cellNum + 1);
                // Applying border to the cell 
                RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, cellRangeAddress, spreadSheet, workbook);
                RegionUtil.setBorderTop(CellStyle.BORDER_THIN, cellRangeAddress, spreadSheet, workbook);
                RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, cellRangeAddress, spreadSheet, workbook);
                RegionUtil.setBorderRight(CellStyle.BORDER_THIN, cellRangeAddress, spreadSheet, workbook);
                RegionUtil.setBottomBorderColor(2, cellRangeAddress, spreadSheet, workbook);
                cell.setCellStyle(style1);
                spreadSheet.addMergedRegion(cellRangeAddress);


            }
            int rowCount = spreadSheet.getLastRowNum();
            Row row2 = spreadSheet.createRow(++rowCount);


            //Result and points men
            int columnCount = 5;
            for (int i = 0; i < menBranches.length; i++) {
                XSSFCellStyle style2 = workbook.createCellStyle();
                XSSFFont font = workbook.createFont();
                font.setBold(true);
                style2.setFont(font);
                Cell cell = genderResultsMen.createCell(columnCount + i);
                cell.setCellValue("Results");
                Cell cell2 = genderResultsMen.createCell(columnCount + i + 1);
                cell2.setCellValue("Points");
                row2.createCell(columnCount + i + 2);
                cell.setCellStyle(style2);
                cell2.setCellStyle(style2);
                columnCount++;
            }


            //Competitor women loop
            for (int i = 0; i < columnHeadsWomen.length; i++) {
                Cell cell = genderResultsWomen.createCell(i);
                cell.setCellValue(columnHeadsWomen[i]);
                secondSpreadSheet.autoSizeColumn(i);
            }
            //Branches women
            int columnStartWomen = 4;
            Cell cellWomen = headerRowWomen.createCell(columnStart);
            for (int i = 0; i < womenBranches.length; i++) {
                    int cellNum = headerRowWomen.getLastCellNum();
                    Cell cell = headerRowWomen.createCell(cellNum);
                    Cell cell2 = headerRowWomen.createCell(cellNum + 1);
                    cell.setCellValue(womenBranches[i]);


                    XSSFCellStyle style1 = workbook.createCellStyle();
                    style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    XSSFFont font = workbook.createFont();
                    font.setFontHeightInPoints((short) 12);
                    font.setFontName("Verdana");
                    font.setColor(IndexedColors.RED.getIndex());
                    font.setBold(true);
                    //font.setItalic(true);
                    //font.setStrikeout(true);
                    //font.setUnderline((byte) 1);  // 1=normal or 2=double
                    // Applying font to the style
                    style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                    style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    style1.setFont(font);
                    // Applying style to the cell
                    cell.setCellValue(womenBranches[i]);
                    CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, cellNum, cellNum + 1);
                    // Applying border to the cell
                    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, cellRangeAddress, secondSpreadSheet, workbook);
                    RegionUtil.setBorderTop(CellStyle.BORDER_THIN, cellRangeAddress, secondSpreadSheet, workbook);
                    RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, cellRangeAddress, secondSpreadSheet, workbook);
                    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, cellRangeAddress, secondSpreadSheet, workbook);
                    RegionUtil.setBottomBorderColor(2, cellRangeAddress, secondSpreadSheet, workbook);
                    cell.setCellStyle(style1);
                    secondSpreadSheet.addMergedRegion(cellRangeAddress);


                }





            //Result and points women

            int columnCountWomen = 5;
            for (int i = 0; i < womenBranches.length; i++) {
                XSSFCellStyle style2 = workbook.createCellStyle();
                XSSFFont font = workbook.createFont();
                font.setBold(true);
                style2.setFont(font);
                Cell cell = genderResultsWomen.createCell(columnCountWomen + i);
                cell.setCellValue("Results");
                Cell cell2 = genderResultsWomen.createCell(columnCountWomen + i + 1);
                cell2.setCellValue("Points");
                genderResultsWomen.createCell(columnCountWomen + i + 2);
                cell.setCellStyle(style2);
                cell2.setCellStyle(style2);
                columnCountWomen++;
            }


            FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
            workbook.write(outputStream);
            outputStream.close();

            System.out.println("Created new excel");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readExcelMen() {
        if (exists) {
            try {

                //hitta filen
                String excelFilePath = "Competition.xlsx";
                FileInputStream inputStream = new FileInputStream(new File(excelFilePath));


                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

                XSSFSheet firstSheet = workbook.getSheetAt(0);

                firstSheet = workbook.getSheetAt(0);     //creating a Sheet object to retrieve object
                //iterating over excel file
                for (Row row : firstSheet) {
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                                System.out.print(cell.getStringCellValue() + "\t\t\t");
                                break;
                            case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                                System.out.print(cell.getNumericCellValue() + "\t\t\t");
                                break;
                            default:
                        }
                    }
                    System.out.println("");
                }
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
                workbook.write(outputStream);
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Finns inte");
        }
    }

    public void readExcelWomen() {
        if (exists) {
            try {

                //hitta filen
                String excelFilePath = "Competition.xlsx";
                FileInputStream inputStream = new FileInputStream(new File(excelFilePath));


                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

                XSSFSheet secondSheet = workbook.getSheetAt(1);

                secondSheet = workbook.getSheetAt(1);     //creating a Sheet object to retrieve object
                //iterating over excel file
                for (Row row : secondSheet) {
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                                System.out.print(cell.getStringCellValue() + "\t\t\t");
                                break;
                            case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                                System.out.print(cell.getNumericCellValue() + "\t\t\t");
                                break;
                            default:
                        }
                    }
                    System.out.println("");
                }
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream("Competition.xlsx");
                workbook.write(outputStream);
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Doesn't exist");
        }
    }


}
