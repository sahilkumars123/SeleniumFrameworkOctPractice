package com.qa.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtil {


    public static Workbook book;
    public static Sheet sheet;

    public static  Object[][] data;


    public static Object[][] getData(String sheetName){

        String SHEET_PATH = "./src/test/resources/testdata/testdata.xlsx";

        try {
            FileInputStream ip = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);

            //int[] arr = new int[5]; 1D
            //int[][] arr = new int[4][5]; 2D

            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            for(int i=0; i <sheet.getLastRowNum(); i++){
                for(int j=0;j <sheet.getRow(i).getLastCellNum(); j++){
                        data[i][j] = sheet.getRow(i+1).getCell(j).toString();
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
            return data;
    }
}
