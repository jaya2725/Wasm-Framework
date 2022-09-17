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
 * THIS CLASS CONTAINS TEST SCRIPTS TO CREATE CONTACTS
 * @author JAYA
 *
 */

public class CreateContactsTest {
	@Test
	public void CreateConTest() throws IOException {
		WebDriver driver;
		/**
		 * Create object for all generic utility classes
		 */
		JavaUtility jUtil=new JavaUtility();
		DriverUtility dUtil=new DriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
		/**
		 * read all neccessary data 
		 */
		String BROWSER = pUtil.readDataFromProperty("browser");
		String URL = pUtil.readDataFromProperty("url");
		String USERNAME = pUtil.readDataFromProperty("username");
		String PASSWORD = pUtil.readDataFromProperty("password");
		String LASTNAME = eUtil.getDataFromExcel("sheet2",1, 2);
		/**
		 * launch the browser
		 */
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
		
		driver.get(URL);
		dUtil.waitToElementsToLoadInDom(driver);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("contact_name")).sendKeys(LASTNAME+jUtil.getRandomNumber());
		driver.findElement(By.name("button")).click();
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		dUtil.mouseHover(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("executed successfully");
	
		
		
		
		
		
	}
	

}
