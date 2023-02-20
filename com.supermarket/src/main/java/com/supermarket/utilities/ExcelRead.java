package com.supermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.supermarket.constants.Constants;

public class ExcelRead {
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	
	XSSFRow row;
	XSSFCell cell;
	
	public void setExcelFiles(String workBookName,String sheetName)
	{
		try {
		String path=Constants.EXCEL_FILE_PATH+workBookName+".xlsx";
		File src = new File(path);
		FileInputStream fi = new FileInputStream(src);
		workbook = new XSSFWorkbook(fi);   //assign to workbook
		sheet = workbook.getSheet(sheetName);   //assign to sheet
		} catch (Exception e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
	}
		
	public String getCellData(int rowNo, int columnNo)
	{
		row = sheet.getRow(rowNo);
		cell = row.getCell(columnNo);
		switch (cell.getCellType()) 
		{
		case STRING: 
		{
			String x;
			x = cell.getStringCellValue();
			return x;
		}
		case NUMERIC: 
		{
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}
		default:
			return null;
	}
		
		
		
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
