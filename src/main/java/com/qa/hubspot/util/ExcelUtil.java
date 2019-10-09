package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Workbook book;
	
	public static Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH ="C:\\Users\\tarun.kumar\\eclipse-workspace\\SeptPomSeries\\src\\main\\java\\com\\qa\\hubspot\\testdata\\appTestData.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		// to fetch the data from excel sheet
		// from which sheet u want to fetch the data		

		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet= book.getSheet(sheetName);
		
		Object data[][] = new Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k =0; k<sheet.getRow(0).getLastCellNum(); k++) {
				if (null!=sheet.getRow(i+1) && null!=sheet.getRow(i+1).getCell(k)) 
				data[i][k]=sheet.getRow(i+1).getCell(k).toString( );	
				
			}
		}
		return data;		
	}
}
