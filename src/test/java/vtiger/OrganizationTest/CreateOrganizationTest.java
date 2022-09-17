package vtiger.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
	


	@Test
	public void CreateOrgTest() throws EncryptedDocumentException, IOException {
		WebDriver driver;
		Random r=new Random();
		int RANDOM = r.nextInt(1000);
		
		//1. Read data from PropertyFile
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
	
	//Step 2 read data from excel sheet
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fisp);
	Sheet sh = wb.getSheet("sheet1");
	Row ROW = sh.getRow(1);
	Cell cel = ROW.getCell(2);
	String orgname = cel.getStringCellValue();
	
	//step 3 launch the browser--example for run time polymorphism
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		System.out.println( "chrome browser launched successfully-----");
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
		System.out.println("-------firefox browser launced successfully---");
		
	}
	else
	{
		System.out.println("browser invalid");
		driver=new ChromeDriver();
		System.out.println("------chromebrowser lauched successfully----");
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgname+RANDOM);
	driver.findElement(By.name("button")).click();
	 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a=new Actions(driver);
	
	a.moveToElement(element).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("---------scenario is executed successfully------------");
	
	
	
	
	
	
	
	
	


	

}
}
