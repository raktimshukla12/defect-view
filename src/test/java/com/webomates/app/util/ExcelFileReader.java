package com.webomates.app.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelFileReader {
	static List<String> logicalNameList = new ArrayList<String>();
	static List<String> propertyTypeList = new ArrayList<String>();
	static List<String> propertyValueList = new ArrayList<String>();
	static WebDriver driver;

	public static void readXLSFile(String sheet_name) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(
				"E:\\DefectViewSystem\\defect-view\\config\\ObjectRepository.xls");
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet = wb.getSheet(sheet_name);
		HSSFRow row;
		HSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();
		row = (HSSFRow) rows.next();
		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			int i = 0;
			while (cells.hasNext()) {
				cell = (HSSFCell) cells.next();
				if (i == 0) {
					logicalNameList.add(cell.toString());
				} else if (i == 1) {
					propertyTypeList.add(cell.toString());
				} else if (i == 2) {
					propertyValueList.add(cell.toString());
				}
				i++;
			}
		}
	}
	
	public static By findValue(String logical_Name)
	{
		By by = null;
		int index = logicalNameList.indexOf(logical_Name);
		String type = propertyTypeList.get(index);
		String locatorvalue = propertyValueList.get(index);
		if (type.equalsIgnoreCase("id")) {
			by = By.id(locatorvalue);
		} else if (type.equalsIgnoreCase("xpath")) {
			by = By.xpath(locatorvalue);
		} else if (type.equalsIgnoreCase("className")) {
			by = By.className(locatorvalue);
		} else if (type.equalsIgnoreCase("cssSelector")) {
			by = By.cssSelector(locatorvalue);
		}
		return (by);
	}
}
