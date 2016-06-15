package com.webomates.app.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webomates.app.util.ExcelFileReader;
import com.webomates.app.util.Util;

public class PriorityBar {
	static WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void read (String browser) throws Exception 
	{	
		driver = Util.getDriver(browser);
		Util.login(driver);		
	}
	
	@Test 
    public static void PriorityBar_Panel_Verify_UI () throws InterruptedException {
        Util.assertElementExistence(driver, "priority_bar_tab", "Defects Priority", "priority_bar_header");
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
	public void PriorityBar_ClickLegends_Enable_DisableFunctionality () throws InterruptedException
	{
		driver.findElement(ExcelFileReader.findValue("high_priority_bar_section_legend")).click();
		driver.findElement(ExcelFileReader.findValue("highest_priority_bar_section_legend")).click();
		driver.findElement(ExcelFileReader.findValue("lowest_priority_bar_section_legend")).click();
		driver.findElement(ExcelFileReader.findValue("normal_priority_bar_section_legend")).click();
	}
}
