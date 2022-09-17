package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public DatabaseUtility dbUtil=new DatabaseUtility();
	public  JavaUtility jUtil=new JavaUtility();
		public DriverUtility dUtil=new DriverUtility();
	public	ExcelFileUtility eUtil=new ExcelFileUtility();
		public PropertyFileUtility pUtil= new PropertyFileUtility();
		public WebDriver driver=null;
		public static WebDriver sdriver=null;
		
		
		@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
		public void bsConfig() throws SQLException{
			//dbUtil.connectToDB();
			Reporter.log("--------Database Connection is successfull",true);
			
		}
		//@Parameters("BROWSER")
		//@BeforeTest
		@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
		public void bcConfig() throws IOException {
			String BROWSER= pUtil.readDataFromProperty("browser");
			String URL= pUtil.readDataFromProperty("url");
			if(BROWSER.equalsIgnoreCase("CHROME")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				Reporter.log("browser successfully launced",true);
			
		}
			else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
				WebDriverManager.chromedriver().setup();
				driver=new FirefoxDriver();
				Reporter.log("browser launched",true);
			}
			else
			{
				System.out.println("invalid browser");
			}
			sdriver=driver;
			
			dUtil.maximizeWindow(driver);
			dUtil.waitToElementsToLoadInDom(driver);
			driver.get(URL);
		}
		@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
		public void bmConfig() throws IOException {
			String USERNAME = pUtil.readDataFromProperty("username");
			String PASSWORD = pUtil.readDataFromProperty("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("---------login succesfull-----",true);
			
		}
		@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
		
			public void amConfig() {
				HomePage hp=new HomePage(driver);
				hp.signOutOfApp(driver);
				Reporter.log("--signout successfull",true);
				
				
			}
		//@AfterTest
		@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
		public void acConfig() {
			driver.close();
			Reporter.log("browser closed");
			
		}
		@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
		public void asConfig() throws SQLException {
			//dbUtil.closeDB();
			Reporter.log("DATABASE CLOSED",true);
			
		}
		
		

}
