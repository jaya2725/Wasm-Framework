package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.DriverUtility;

public class OrganizationInformationPage extends DriverUtility {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;
	
	//intiliazation
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}
	//business librariies
	
	public String getOrgHeader() {
		String orgheader = OrgHeaderTxt.getText();
		return orgheader;
	}
	

}
