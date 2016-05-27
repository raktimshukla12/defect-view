package com.webomates.app.util;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util 
{

	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public static List<List<String>> getTableData(String logicalName, WebDriver driver)
	{
		List<List<String>> tablelist = new LinkedList<List<String>>();
		
		WebElement tableElement = driver.findElement(ExcelFileReader.findValue(logicalName));
		List<WebElement> trElements = tableElement.findElements(By.tagName("tr"));
		for (WebElement trelement : trElements)
		{
			List<String> innerList =  new LinkedList<String>();
			List<WebElement> tdelements = trelement.findElements(By.tagName("td"));
			for (WebElement tdelement : tdelements) {
				innerList.add(tdelement.getText());
			}
			tablelist.add(innerList);
			
		}
		return tablelist;
	}

}
