package com.crm.qa.util;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
     
	
		//generic reusable method
		public String readExcelData(String excelpath, String sheetName, int RowCount, int CellCount) throws Exception
		{
			FileInputStream fis = new FileInputStream(excelpath);
			//new WorkbookFactory();
			Workbook workBook = WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet(sheetName);
			Row row = sheet.getRow( RowCount);
			Cell cell = row.getCell(CellCount);
			String data = cell.getStringCellValue();
			return data;	
		}
		
		//generic reusable method for get row count from Excel file
		public int getRowCount(String excelpath, String sheetName) throws Exception
		{
			FileInputStream fis = new FileInputStream(excelpath);
			//new WorkbookFactory();
			Workbook workBook = WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet( sheetName);
			int rc = sheet.getLastRowNum();
			return rc;	
		}
		
		//generic reusable method for read data from excel file
		public void writeDataExcel(String excelPath, String sheetName, int RowCount, int CellCount, String data) throws Exception
		{
			FileInputStream fis = new FileInputStream(excelPath);
			//new WorkbookFactory();
			Workbook workBook = WorkbookFactory.create(fis);
			Sheet sheet = workBook.getSheet(sheetName);
			Row row = sheet.getRow(RowCount);
			Cell cell = row.getCell(CellCount);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(excelPath);
			workBook.write(fos);
			
		}
	
}


