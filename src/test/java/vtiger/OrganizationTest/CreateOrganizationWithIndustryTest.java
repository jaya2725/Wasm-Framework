package vtiger.OrganizationTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

public class CreateOrganizationWithIndustryTest {
	

	public static void main(String[] args) throws IOException {
	WebDriver driver;
	DriverUtility dUtil=new DriverUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	
	
	String BROWSER = pUtil.readDataFromProperty("browser");
	String URL = pUtil.readDataFromProperty("url");
	String USERNAME = pUtil.readDataFromProperty("username");
	String PASSWORD = pUtil.readDataFromProperty("password");
	String ORGNAME = eUtil.getDataFromExcel("sheet1", 4, 2);
	String INDUSTRYNAME = eUtil.getDataFromExcel("sheet1", 4, 3);
	
	
	if(BROWSER.equalsIgnoreCase("CHROME"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("-------browser launched-----");
	}
	else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
		System.out.println("-------browser launched-----");
		
	}
	else
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("-------browser launched-----");
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
	
	WebElement value = driver.findElement(By.name("industry"));
			dUtil.handleDropDown(INDUSTRYNAME, value);
			driver.findElement(By.name("button")).click();
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			dUtil.mouseHover(driver, element);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("executed successfully");
		
		
	
	
	
	
	

	}

}
