package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInformationPage;
import ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.DriverUtility;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class DataProviders {
	//Create Object of all the required utilities
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		DriverUtility dUtil = new DriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		
		WebDriver driver;
		
		@Test(dataProvider = "OrgData")
		public void createMultipleOrgTest(String OrgName, String industryType) throws IOException
		{
			//read all the necessary data
			String BROWSER = pUtil.readDataFromProperty("browser");
			String URL = pUtil.readDataFromProperty("url");
			String USERNAME = pUtil.readDataFromProperty("username");
			String PASSWORD = pUtil.readDataFromProperty("password");
			
			String Org = OrgName+jUtil.getRandomNumber();
			
			//launch the browser
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("chrome browser launched");
			}
			else if (BROWSER.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("firefox browser launched");
				
			}
			else
			{
				System.out.println("browser name invalid, henced launched chrome");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("chrome browser launched");
			}
			
			dUtil.maximizeWindow(driver);
			dUtil.waitToElementsToLoadInDom(driver);
			driver.get(URL);
			
			//login to app
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			//Navigate to Organizations link
			HomePage hp = new HomePage(driver);
			hp.ClickonOrgLink();;
			
			//Navigate to create org look up image
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateNewOrgImg();
			
			//create new org with industry type
			CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
			cop.CreateNewOrg(Org, industryType);
			
			//Validate
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String orgHeader = oip.getOrgHeader();
			System.out.println(orgHeader);
			if(orgHeader.contains(Org))
	        {
		      System.out.println("PASS");
	        }
			else
			{
				System.out.println("FAIL");
			}
			
		}
		
		@DataProvider(name = "OrgData")
		public Object[][] getData() throws EncryptedDocumentException, IOException
		{
			return eUtil.readMultipleDataFromExcel("sheet3");
		}
		

	}


