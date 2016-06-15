package com.webomates.app.testcases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webomates.app.util.ExcelFileReader;
import com.webomates.app.util.MySqlMethods;
import com.webomates.app.util.Util;

public class Dashboard {
	
	static WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void read (String browser) throws Exception 
	{	
		driver = Util.getDriver(browser);
		Util.login(driver);		
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
		Util.assertElementText(driver, "home_tab", "Home");
        Util.assertElementText(driver, "pie_chart_tab", "Pie Chart");
        Util.assertElementText(driver, "priority_bar_tab", "Priority Bar Graph");
        Util.assertElementText(driver, "details_table_tab", "Description Table");
        Util.assertElementText(driver, "about_us_tab", "About Us");
	}
	
	@Test
	public void Dashboard_Pie_Chart_Panel_Verify_UI () 
	{	
        Util.dashboard(driver);
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
		Util.assertElementText(driver, "details_table_title", "Defect View System");
	}
	
	@Test
	public void Dashboard_Footer_Verify_UI () 
	{	
		Util.assertElementText(driver, "footer_header", "Defect View System");
        Util.assertElementText(driver, "footer_faq", "FAQ");
        Util.assertElementText(driver, "footer_contactUs_label", "Contact Us");
        Util.assertElementText(driver, "footer_createdBy_label", "Created by:");
        Util.assertElementText(driver, "footer_createdYear_label", "Created Year:");
	}
	
	@Test
	public void Dashboard_Sidebar_Click_PieChart_ValidateNavigation () throws InterruptedException 
	{
		Util.assertElementExistence(driver, "pie_chart_tab", "Defects Severity", "piechart_header");		
		Util.dashboard(driver);
	}
	
	@Test	
	public void Dashboard_Sidebar_Click_PriorityBarGraph_ValidateNavigation () throws InterruptedException 
	{	
		Util.assertElementExistence(driver, "priority_bar_tab", "Defects Priority", "priority_bar_header");		
		Util.dashboard(driver);
	}
	
	@Test
	public void Dashboard_Sidebar_Click_DescriptionTable_ValidateNavigation () throws InterruptedException
	{	
		Util.assertElementExistence(driver, "details_table_tab", "Defects Description", "details_table_header");		
		Util.dashboard(driver);
	}
	
	@Test
	public void Dashboard_Sidebar_Click_AboutUs_ValidateNavigation () throws InterruptedException 
	{
		Util.assertElementExistence(driver, "about_us_tab", "INTRODUCTION:", "about_us_header");		
		Util.dashboard(driver);
	}
	@Test
	public void Dashboard_PieChart_Click_Verify_UI () throws InterruptedException 
	{
		Util.dashboard(driver);
        Util.assertGraphElement(driver, "pie_slice_blocker", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_critical", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_enhancement", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_major", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_minor", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_normal", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_trivial", "transform", "translate(0,0)");
	}
	
	@Test
	public void Dashboard_PieChart_ClickLegends_Enable_DisableFunctionality () throws InterruptedException
	{	
		Util.assertGraphLegend(driver, "pie_slice_blocker", "blocker_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_blocker", "blocker_pie_chart_legend", "visibility", null);
		Util.assertGraphLegend(driver, "pie_slice_critical", "critical_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_critical", "critical_pie_chart_legend", "visibility", null);
		Util.assertGraphLegend(driver, "pie_slice_enhancement", "enhancement_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_enhancement", "enhancement_pie_chart_legend", "visibility", null);
		Util.assertGraphLegend(driver, "pie_slice_major", "major_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_major", "major_pie_chart_legend", "visibility", null);
		Util.assertGraphLegend(driver, "pie_slice_minor", "minor_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_minor", "minor_pie_chart_legend", "visibility", null);
		Util.assertGraphLegend(driver, "pie_slice_normal", "normal_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_normal", "normal_pie_chart_legend", "visibility", null);
		Util.assertGraphLegend(driver, "pie_slice_trivial", "trivial_pie_chart_legend", "visibility", "hidden");
		Util.assertGraphLegend(driver, "pie_slice_trivial", "trivial_pie_chart_legend", "visibility", null);		
	}
	
	@Test
	public void Dashboard_PriorityBarGraph_ClickLegends_Enable_DisableFunctionality () throws InterruptedException
	{	
		driver.findElement(ExcelFileReader.findValue("high_priority_bar_legend")).click();
		driver.findElement(ExcelFileReader.findValue("highest_priority_bar_legend")).click();
		driver.findElement(ExcelFileReader.findValue("lowest_priority_bar_legend")).click();
		driver.findElement(ExcelFileReader.findValue("normal_priority_bar_legend")).click();
	}
	@Test 
    public static void DescriptionTable_Validate_DefectsDescription_DataGridUI() throws InterruptedException {
        Util.dashboard(driver);
        Thread.sleep(1000);
        Util.assertElementExistence(driver, "sidebar_descriptiontablelink", "Defects Description", "description_table_header");
        System.out.println("we are on defect description page.");
        List<WebElement> List2 = driver.findElements(ExcelFileReader.findValue("defects_table"));
        String tableData = Util.getTableData(List2);
        System.out.println("col elements are: " +tableData);
    }
	
	@Test
	public void Dashboard_DefectDescription_Validate_Table_Data () throws InterruptedException, SQLException 
	{
		List<List<String>> UItableData = Util.getTableData("details_table_body", driver);
		System.out.println("UI table data is : "+UItableData);
		Connection con = MySqlMethods.createConnection();
		String query = "SELECT * FROM defectview.bugs b";
		List<List<String>> DBtableData = MySqlMethods.getDBTableData(query, con);
		System.out.println("DB list is : "+DBtableData);
		Assert.assertEquals(UItableData, DBtableData); 
	}
	
	@Test
	public void Dashboard_Click_Logo_ValidateNavigation ()
	{
		driver.findElement(ExcelFileReader.findValue("pie_chart_tab")).click();
		driver.findElement(ExcelFileReader.findValue("logo_header")).click();
		Assert.assertTrue(driver.findElement(ExcelFileReader.findValue("bar_chart_panel_title")).isDisplayed(), "Logo Navigation is not working");
	}
	
	@Test
	public void Dashboard_Click_Logout_ValidateNavigation ()
	{
		driver.findElement(ExcelFileReader.findValue("logout_btn")).click();
	}
}