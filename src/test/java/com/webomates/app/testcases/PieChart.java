package com.webomates.app.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webomates.app.util.Util;

public class PieChart {
	static WebDriver driver;
	
	@Parameters (
            {"platform","browser"})
	@BeforeClass
	public void read (String platform, String browser) throws Exception 
	{	
		driver = Util.getDriver(browser);
		Util.login(driver);			
	}
	@Parameters (
            {"platform","browser"})
	@BeforeTest 
    public static void beforetest(String platform, String browser) throws Exception {
        driver = Util.getDriver(browser);
    }
	@Test 
    public static void PieChart_Vaidate_Navigation() throws InterruptedException {
        Util.assertElementExistence(driver, "pie_chart_tab", "Defects Severity", "piechart_header");
    }
	@Test 
    public static void PieChart_Verify_UI () throws InterruptedException {
        Util.assertElementExistence(driver, "pie_chart_tab", "Defects Severity", "piechart_header");
        Util.assertElementText(driver, "top_homelink", "Home");
        Util.assertElementText(driver, "top_piechartlink", "Pie Chart");
        Util.assertElementText(driver, "top_prioritybarlink", "Priority Bar Graph");
        Util.assertElementText(driver, "top_descriptiontablelink", "Description Table");
        Util.assertElementText(driver, "top_aboutuslink", "About Us");
        Util.assertElementText(driver, "top_logoutlink", "Logout");
        Util.assertElementText(driver, "defectview_header", "Defects View");
        Util.assertElementText(driver, "sidebar_homelink", "Home");
        Util.assertElementText(driver, "sidebar_piechartlink", "Pie Chart");
        Util.assertElementText(driver, "sidebar_prioritybarlink", "Priority Bar Graph");
        Util.assertElementText(driver, "sidebar_descriptiontablelink", "Description Table");
        Util.assertElementText(driver, "sidebar_aboutuslink", "About Us");
        Util.assertElementText(driver, "footer_header", "Defect View System");
        Util.assertElementText(driver, "FAQ", "FAQ");
        Util.assertElementText(driver, "contact_us", "Contact Us");
        Util.assertElementText(driver, "created_by", "Created by:");
        Util.assertElementText(driver, "created_year", "Created Year:");
    }
	/*@Test 
    public static void PieChart_Verify_DefectSeverity_GraphUI() throws InterruptedException {
        Util.dashboard(driver);
        Util.assertElementExistence(driver, "sidebar_piechartlink", "Defects Severity", "piechart_header");
        List<WebElement> element1 = driver.findElements(ExcelFileReader.findValue("piechart_datalabels"));
        String datalabels = Util.getTableData(element1);
        String[] pieChartDataLables = {"blocker","critical","enhancement","major","minor","normal","trivial"};
        Assert.assertEquals(pieChartDataLables, datalabels);
        Thread.sleep(1000);
        List<WebElement> element11 = driver.findElements(ExcelFileReader.findValue("piechart_legend"));
        String legend = Util.getTableData(element11);
        Thread.sleep(1000);
    }*/
	
	@Test 
    public static void PieChart_Click_GraphSection_VerifyUI() throws InterruptedException {
        Util.dashboard(driver);
        Util.assertElementExistence(driver, "pie_chart_tab", "Defects Severity", "piechart_header");
        Util.assertGraphElement(driver, "pie_slice_blocker", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_critical", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_enhancement", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_major", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_minor", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_normal", "transform", "translate(0,0)");
        Util.assertGraphElement(driver, "pie_slice_trivial", "transform", "translate(0,0)");
    }
	@Test 
    public static void PieChart_Verify_Click_DefectSeverity_GraphLegend() throws InterruptedException {
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
}
