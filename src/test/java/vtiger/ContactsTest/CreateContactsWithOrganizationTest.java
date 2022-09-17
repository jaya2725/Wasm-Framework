package vtiger.ContactsTest;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.DriverUtility;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;


/**
 * 
 * @author Jaya
 *
 */

public class CreateContactsWithOrganizationTest {

	@Test(groups="RegressionSuite")
	public void CreateContactsWithOrgTest() throws IOException {
		WebDriver driver=null;
		
		
		
		DriverUtility dUtil=new DriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		JavaUtility jUtil=new JavaUtility();
		
		
		String BROWSER = pUtil.readDataFromProperty("browser");
		String URL = pUtil.readDataFromProperty("url");
		String USERNAME = pUtil.readDataFromProperty("username");
		String PASSWORD = pUtil.readDataFromProperty("password");
		
		String ORGNAME = eUtil.getDataFromExcel("sheet2",4,3)+jUtil.getRandomNumber();
		String lASTNAME = eUtil.getDataFromExcel("sheet2", 4, 2)+jUtil.getRandomNumber();
		
		
		
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				System.out.println("chrome browser launced");
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new FirefoxDriver();
				System.out.println("chrome browser launced");
				
				
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				System.out.println("chrome browser launced");
				}
			
			
			dUtil.maximizeWindow(driver);
			dUtil.waitToElementsToLoadInDom(driver);
			driver.get(URL);
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			driver.findElement(By.name("button")).click();
			 String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 System.out.println(orgHeader);
			 if((orgHeader.contains(ORGNAME)))
			 {
				 System.out.println("pass");
				 System.out.println("organization created");
			 }
			 else
			 {
				 System.out.println("fail");
				 System.out.println("orgaization not created");
			 }
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(lASTNAME);
				driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img[@alt='Select']")).click();
				dUtil.switchToWindow(driver, "Accounts");
				driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(ORGNAME)).click();
				dUtil.switchToWindow(driver, "Contacts");
				driver.findElement(By.name("button")).click();
				 String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 if(ContactHeader.contains(ORGNAME))
				 {
					 System.out.println("pass");
					 System.out.println("Contact created");
				 }
				 else
				 {
					 System.out.println("fail");
					 System.out.println("Contact not created");
				 }
				 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					dUtil.mouseHover(driver, element);
					driver.findElement(By.linkText("Sign Out")).click();
					System.out.println("executed successfully");
				
				
				
				
				
				

	}
				
}
