package com.webomates.app.testcases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webomates.app.util.ExcelFileReader;
import com.webomates.app.util.MySqlMethods;
import com.webomates.app.util.Util;

public class Dashboard {
	
	static WebDriver driver = new FirefoxDriver();	
	@BeforeClass
	public void read () throws InterruptedException, IOException 
	{
		ExcelFileReader.readXLSFile("Dashboard");
		driver.get("http://localhost:8080/DefectView/");
		driver.manage().window().maximize();
		driver.findElement(ExcelFileReader.findValue("txt_email")).sendKeys("raktimshukla@gmail.com");
		driver.findElement(ExcelFileReader.findValue("txt_password")).sendKeys("1245");
		driver.findElement(ExcelFileReader.findValue("submit_btn")).click();		
	}
	
	@Test
	public void Dashboard_Header_Verify_UI ()
	{
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("main_logo")).isDisplayed(), "Logo is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("logout_btn")).isDisplayed(), "Logout Button is not displayed");
	}
	
	@Test
	public void Dashboard_Sidebar_Verify_UI () 
	{
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("home_tab")).isDisplayed(), "Home Tab is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("pie_chart_tab")).isDisplayed(), "Pie Chart Tab is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("priority_bar_tab")).isDisplayed(), "Priority Bar Tab is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("details_table_tab")).isDisplayed(), "Details Table Tab is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("about_us_tab")).isDisplayed(), "About Us Tab is not displayed");
	}
	
	@Test
	public void Dashboard_Pie_Chart_Panel_Verify_UI () 
	{
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("pie_chart_panel_title")).isDisplayed(), "Pie Chart Panel Heading is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("pie_chart")).isDisplayed(), "Pie Chart is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("pie_chart_legends")).isDisplayed(), "Pie Chart legends are not displayed");
	}
	
	@Test
	public void Dashboard_Priority_Bar_Panel_Verify_UI ()
	{
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("bar_chart_panel_title")).isDisplayed(), "Bar Chart Panel Heading is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("bar_chart")).isDisplayed(), "Bar Chart is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("bar_chart_legends")).isDisplayed(), "Bar Chart legends are not displayed");
	}
	
	@Test
	public void Dashboard_Defect_Description_Table_Panel_Verify_UI ()
	{
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("details_table_title")).isDisplayed(), "Details Table Title is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("details_table_head")).isDisplayed(), "Details table head is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("details_table_body")).isDisplayed(), "Details table body is not displayed");
	}
	
	@Test
	public void Dashboard_Footer_Verify_UI () 
	{
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_faq")).isDisplayed(), "FAQ is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_contactUs_label")).isDisplayed(), "ContactUs Label is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_contactUs_text")).isDisplayed(), "ContactUs Text is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_createdBy_label")).isDisplayed(), "CreatedBy Label is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_createdBy_text")).isDisplayed(), "CreatedBy Text is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_createdYear_label")).isDisplayed(), "CreatedYear Label is not displayed");
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("footer_createdYear_text")).isDisplayed(), "CreatedYear Text is not displayed");
	}
	
	@Test(description = "validate_pie_chart_navigation", priority = 1)
	public void validate_pie_chart_navigation () throws InterruptedException 
	{
		driver.findElement(ExcelFileReader.findValue("pie_chart_tab")).click();
		driver.findElement(ExcelFileReader.findValue("home_tab")).click();
	}
	
	@Test(description = "validate_priority_bar_navigation", priority = 1)	
	public void validate_priority_bar_navigation () throws InterruptedException 
	{
		driver.findElement(ExcelFileReader.findValue("priority_bar_tab")).click();
		driver.findElement(ExcelFileReader.findValue("home_tab")).click();
	}
	
	@Test(description = "validate_details_table_navigation", priority = 1)
	public void validate_details_table_navigation () throws InterruptedException
	{
		driver.findElement(ExcelFileReader.findValue("details_table_tab")).click();
		driver.findElement(ExcelFileReader.findValue("home_tab")).click();
	}
	
	@Test(description = "validate_about_us_navigation", priority = 1)
	public void validate_about_us_navigation () throws InterruptedException 
	{
		driver.findElement(ExcelFileReader.findValue("about_us_tab")).click();
		driver.get("http://localhost:8080/DefectView/template/home.jsp");
	}
	
	@Test(description = "Dashboard_PieChart_Click_Validate_UI", priority = 1)
	public void Dashboard_PieChart_Click_Validate_UI () throws InterruptedException 
	{
		driver.findElement(ExcelFileReader.findValue("blocker_pie_chart_label")).click();
		driver.findElement(ExcelFileReader.findValue("critical_pie_chart_label")).click();
		driver.findElement(ExcelFileReader.findValue("enhancement_pie_chart_label")).click();		
		driver.findElement(ExcelFileReader.findValue("major_pie_chart_label")).click();		
		driver.findElement(ExcelFileReader.findValue("minor_pie_chart_label")).click();		
		driver.findElement(ExcelFileReader.findValue("normal_pie_chart_label")).click();	
		driver.findElement(ExcelFileReader.findValue("trivial_pie_chart_label")).click();
	}
	
	@Test(description = "validate_legends_enable_disable_functionality", priority = 1)
	public void validate_legends_enable_disable_functionality () throws InterruptedException
	{
		driver.findElement(ExcelFileReader.findValue("blocker_pie_chart_legend")).click();
		driver.findElement(ExcelFileReader.findValue("critical_pie_chart_legend")).click();
		driver.findElement(ExcelFileReader.findValue("enhancement_pie_chart_legend")).click();
		driver.findElement(ExcelFileReader.findValue("major_pie_chart_legend")).click();
		driver.findElement(ExcelFileReader.findValue("minor_pie_chart_legend")).click();
		driver.findElement(ExcelFileReader.findValue("normal_pie_chart_legend")).click();
		driver.findElement(ExcelFileReader.findValue("trivial_pie_chart_legend")).click();
	}
	@Test(description = "validateTableData", priority = 1)
	public void validateTableData () throws InterruptedException, SQLException 
	{
		List<List<String>> UItableData = Util.getTableData("details_table_body", driver);
		System.out.println("UI table data is : "+UItableData);
		Connection con = MySqlMethods.createConnection();
		String query = "SELECT * FROM defectview.bugs b";
		List<List<String>> DBtableData = MySqlMethods.getDBTableData(query, con);
		System.out.println("DB list is : "+DBtableData);
		Assert.assertEquals(UItableData, DBtableData); 
	}	
	
	@AfterClass
	public void btn_Logout ()
	{
		driver.findElement(By.cssSelector("logout_btn")).click();
	}
}