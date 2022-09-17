package vtiger.OrganizationWithObjRep;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateOrganizationTest {

	@Test
	public void CreateOrgTest() throws IOException {
		
		WebDriver driver=null;
		JavaUtility jUtil=new JavaUtility();
		DriverUtility dUtil=new DriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		
		
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
			System.out.println("---------browser launched---------");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			System.out.println("---------browser launched---------");
			
		}
		else {
			
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		System.out.println("---------browser launched---------");
		}
		driver.get(URL);
		dUtil.maximizeWindow(driver);
		dUtil.waitToElementsToLoadInDom(driver);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.ClickonOrgLink();
		
		
		OrganizationPage op=new OrganizationPage(driver);
		op.ClickOnCreateOrganization();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.CreateNewOrg(ORGNAME);
		cop.CreateNewOrg(ORGNAME, INDUSTRYNAME);
		
		//verfication
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String OrgHeader = oip.getOrgHeader();
		if(OrgHeader.contains(OrgHeader)) {
			System.out.println("pass");
		}
		else
		{
			System.out.println("failed");
		}
		hp.signOutOfApp(driver);
		
		
		
		
		
		
		
		
		
		
	}

}
