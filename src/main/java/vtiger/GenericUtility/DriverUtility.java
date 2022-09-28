package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic actions method related to web driver actions 
 * @author Jaya
 *
 */

public class DriverUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
}
	/**
	 * This method will wait 20 second for the DOM structure to load
	 * @param driver
	 */
	public void waitToElementsToLoadInDom(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void expilicitlyWait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait  for the particular element to perform click operation 
	 * if element is not interactive  it will wait 1 second
	 * @param driver
	 * @throws InterruptedException
	 */
	
		
	
	public void customWaitClickOnElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10) {
			try
			{
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
				
			}
		}
	}
		public void  handleDropDown(WebElement element1,int index) {
			Select s=new Select(element1);
			s.selectByIndex(index);
			
			
		}
		public void handleDropDown(WebElement element,String visibletext) {
			Select s=new Select(element);
			s.selectByVisibleText(visibletext);
	
		
	}
		public void handleDropDown(String value,WebElement element) {
			Select s=new Select(element);
			s.selectByValue(value);
			
			
		}
		public void  doubleClick(WebDriver driver) {
			Actions a=new Actions(driver);
			a.doubleClick().perform();
		}
		public void doubleClick(WebDriver driver, WebElement element) {
			Actions a= new Actions(driver);
			a.doubleClick(element).perform();
		}
		public void mouseHover(WebDriver driver,WebElement element) {
			Actions a= new Actions(driver);
			a.moveToElement(element).perform();
		}
		public void mouseHover(WebDriver driver,int x, int y) {
			Actions a =new Actions(driver);
			a.moveByOffset(x, y).perform();
		}
		public void rightClick(WebDriver driver, WebElement element) {
			Actions a = new Actions(driver);
			a.contextClick(element).perform();
		}
		public void rightClick(WebDriver driver) {
			Actions a = new Actions(driver);
			a.contextClick().perform();
		}
		public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement targetElement) {
			Actions a= new Actions(driver);
			a.dragAndDrop(srcElement, targetElement);
		}
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		public void dissmissAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		public String getTextInAlert(WebDriver driver) {
			String text = driver.switchTo().alert().getText();
			return text;
		}
		public void switchToWindow(WebDriver driver, String partialTitle) {
			Set<String> windowids = driver.getWindowHandles();
			Iterator<String> it = windowids.iterator();
			while(it.hasNext()) {
				String windid = it.next();
				String CurrentTitle = driver.switchTo().window(windid).getTitle();
				if(CurrentTitle.contains(partialTitle)) {
					break;
				}
			}
			
		}
		public void switchToFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		public void switchToFrame(WebDriver driver, String idorName) {
			driver.switchTo().frame(idorName);
		}
		public void switchToFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}
		public String takesScreenShot(WebDriver driver, String ScreenShotName) throws IOException {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".\\Screenshots\\"+ScreenShotName+".png";
			File dst = new File(path);
			FileUtils.copyFile(src, dst);

			return dst.getAbsolutePath(); // used for reporting in listeners
		}
		public void scrollDown(WebDriver driver) {
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)","");
		}
		
		public void scrollAction(WebDriver driver, WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("argument[0].scrollIntoView()", element);
			int Y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+Y+")", element);
			
		}
		
			
		
		
		
	

}

