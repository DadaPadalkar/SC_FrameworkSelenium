package com.MystoreV3.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
public class ReadExcelFile 
{
 public static FileInputStream inputstream;
 public static XSSFWorkbook workBook;
 public static XSSFSheet exceLSheet;
 public static XSSFRow row;
 public static XSSFCell cell;
 
 //get value from excel file
 public static String getCellValue(String fileName,String sheetName,int rowNo,int cellNo)
 {
	 try {
		inputstream=new FileInputStream(fileName);
		workBook=new XSSFWorkbook(inputstream);
		exceLSheet=workBook.getSheet(sheetName);
		 cell=workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
		 workBook.close();
		 return cell.getStringCellValue();
	     } 
	 
	 catch (Exception e) 
	 {
			return "";
		
	 }
 }
 public static int getRowCount(String fileName,String sheetName)
 {
	 try {
	 inputstream=new FileInputStream(fileName);
	 //create XSSF class object for excel file manipulation..
	 workBook=new XSSFWorkbook(inputstream);
	 exceLSheet=workBook.getSheet(sheetName);
	 //get total no.of rows 
	 int ttlRows=exceLSheet.getLastRowNum()+1;
	 workBook.close();
	 return ttlRows;
	 }
	 catch (Exception e) 
	 {
			return 0;
		
	 }
 }
 public static int getcolCount(String fileName,String sheetName)
 {
	 try {
	 inputstream=new FileInputStream(fileName);
	 //create XSSF class object for excel file manipulation..
	 workBook=new XSSFWorkbook(inputstream);
	 exceLSheet=workBook.getSheet(sheetName);
	 //get total no.of columns 
	 int ttlcells=exceLSheet.getRow(0).getLastCellNum();
	 workBook.close();
	 return ttlcells;
	 }
	 catch (Exception e) 
	 {
			return 0;
		
	 }
 }
 
}
