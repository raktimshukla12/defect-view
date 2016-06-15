package com.webomates.app.util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Util 
{

	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	public static void login(WebDriver driver) throws IOException {
		ExcelFileReader.readXLSFile("Dashboard");
		ExcelFileReader.readXLSFile("PieChart");
		ExcelFileReader.readXLSFile("DescriptionTable");
		driver.get("http://localhost:8080/DefectView/");
		driver.manage().window().maximize();
		driver.findElement(ExcelFileReader.findValue("txt_email")).sendKeys("raktimshukla@gmail.com");
		driver.findElement(ExcelFileReader.findValue("txt_password")).sendKeys("1245");
		driver.findElement(ExcelFileReader.findValue("submit_btn")).click();
    }
	public static WebDriver getDriver(String browser) throws Exception {
        WebDriver driver;
        if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if(browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "config//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
	public static void dashboard(WebDriver driver) {
        driver.navigate().to("http://localhost:8080/DefectView/template/home.jsp");
    }
	
	public static void dashboardAssertElementExistence(WebDriver driver, String expectedText, String expectedElement){
        Assert.assertTrue(driver.findElement(ExcelFileReader.findValue(expectedElement)).isDisplayed());
        WebElement element1 = driver.findElement(ExcelFileReader.findValue(expectedElement));
        String elementText = element1.getText();
        Assert.assertEquals(expectedText, elementText);
        System.out.println("expected Text :"+expectedText+" Actual text : "+elementText);
    }
	public static void assertElementExistence(WebDriver driver, String elementName,String expectedText, String expectedElement){
        WebElement element = driver.findElement(ExcelFileReader.findValue(elementName));
        boolean elementExistance = element.isDisplayed();
        Assert.assertEquals(elementExistance, true);
        element.click();
        Assert.assertTrue(driver.findElement(ExcelFileReader.findValue(expectedElement)).isDisplayed());
        WebElement element1 = driver.findElement(ExcelFileReader.findValue(expectedElement));
        String elementText = element1.getText();
        Assert.assertEquals(expectedText, elementText);
        System.out.println("expected Text :"+expectedText+" Actual text : "+elementText);
    }
    public static void assertElementText(WebDriver driver, String elementName, String expectedText){
        WebElement element = driver.findElement(ExcelFileReader.findValue(elementName));
        boolean elementExistance = element.isDisplayed();
        System.out.println("existance of "+elementName+" Element on UI is : "+elementExistance);
        Assert.assertEquals(elementExistance, true);
        String elementText = element.getText();
        Assert.assertEquals(expectedText, elementText);
        System.out.println("expected Text :"+expectedText+" Actual text : "+elementText);
    }
    public static void assertGraphElement(WebDriver driver, String elementName, String property, String propertyValue) {
        WebElement element = driver.findElement(ExcelFileReader.findValue(elementName));
        element.click();
        String element1 = element.getAttribute(property);
        System.out.println(element1);
        Assert.assertNotEquals(propertyValue, element1);
    }
    public static void assertGraphLegend(WebDriver driver, String PieElementName, String legendElementName, String property, String propertyValue) {
        WebElement element = driver.findElement(ExcelFileReader.findValue(legendElementName));
        element.click();
        WebElement element1 = driver.findElement(ExcelFileReader.findValue(PieElementName));
        String element11 = element1.getAttribute(property);
        System.out.println(element11);
        Assert.assertEquals(propertyValue, element11);
    }
    public static String getTableData(List<WebElement> data) {
        String tabledata = "";
        for (WebElement obj: data) {
            tabledata = obj.getText();
        } 
        return tabledata;
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
