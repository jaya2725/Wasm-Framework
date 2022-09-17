package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.DriverUtility;

public class OrganizationPage extends DriverUtility {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganizationBtn;
	
	
	public OrganizationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateorganizationBtn() {
		return createorganizationBtn;
	}
	//business library
	public void ClickOnCreateOrganization() {
		createorganizationBtn.click();
	}
	

}
