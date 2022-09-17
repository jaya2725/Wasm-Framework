package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PomPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		
		//login to app
		LoginPage p=new LoginPage(driver);
		WebElement username = p.getUserNameEdt();
		username.sendKeys("admin");
		
		WebElement password = p.getPasswordEdt();
		password.sendKeys("admin");
		
		
		WebElement login = p.getLoginBtn();
		login.click();
		

	}

}
