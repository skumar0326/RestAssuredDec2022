package com.api.com.api.properties;

import org.apache.commons.math3.analysis.function.Add;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PraticeWritingToExcel {

    public static void main(String[] args) {

        //steps to follow
//        Create a workbook
//        Create a sheet in workbook
//        Create a row in sheet
//        Add cells to sheet
//        Repeat steps 3 and 4 to write more data


        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee1 Data");

        //Create data
        Map<Integer, Object[]> data = new TreeMap<>();
        data.put(1, new Object[]{"id", "fName", "lName"});
        data.put(2, new Object[]{"1", "sk", "kumar"});
        data.put(3, new Object[]{"2", "jyo", "Boyapally"});
        data.put(4, new Object[]{"3", "ddd", "kkk"});
        data.put(5, new Object[]{"4", "jjj", "mmmm"});

        Set<Integer> set = data.keySet();
        int rowNum = 0;
        for (Integer key : set) {
            //Create a row in sheet
            XSSFRow row = sheet.createRow(rowNum++);
            int column = 0;
            Object[] value = data.get(key);
            for (Object  obj :value){
                XSSFCell cell = row.createCell(column++);
                if (obj instanceof Integer){
                    cell.setCellValue((Integer)obj);
                }else if (obj instanceof String){
                    cell.setCellValue((String)obj);
                }
          }
        }
         //write workbook in file
        try(FileOutputStream fs = new FileOutputStream(new File("writingtoexcelfile.xlsx"))) {
            workbook.write(fs);

        }  catch (IOException e) {
            e.printStackTrace();
        } ;


    }
}