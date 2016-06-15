package com.webomates.app.testcases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webomates.app.util.ExcelFileReader;
import com.webomates.app.util.MySqlMethods;
import com.webomates.app.util.Util;

public class DescriptionTable {
	static WebDriver driver;
	
	@Parameters (
            {"platform","browser"})
	@BeforeClass
	public void read (String platform, String browser) throws Exception 
	{	
		driver = Util.getDriver(browser);
		Util.login(driver);			
	}
	
	@Test 
    public static void Vaidate_Description_Table_Navigation() throws InterruptedException {
        Util.dashboard(driver);
        Util.assertElementExistence(driver, "details_table_tab", "Defects Description", "description_table_header");
    }
	@Test 
    public static void DescriptionTable_Verify_PageUI() throws InterruptedException {
        Util.dashboard(driver);
        Util.assertElementExistence(driver, "details_table_tab", "Defects Description", "description_table_header");
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
    public static void DescriptionTable_Validate_DefectsDescription_DataGridDetails() throws InterruptedException, SQLException {
		List<List<String>> UItableData = Util.getTableData("details_table_body", driver);
		System.out.println("UI table data is : "+UItableData);
		Connection con = MySqlMethods.createConnection();
		String query = "SELECT * FROM defectview.bugs b";
		List<List<String>> DBtableData = MySqlMethods.getDBTableData(query, con);
		System.out.println("DB list is : "+DBtableData);
		Assert.assertEquals(UItableData, DBtableData);
    }
	
}
