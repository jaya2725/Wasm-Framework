package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.DriverUtility;

public class CreateNewOrganizationPage extends DriverUtility {
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;

	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement accountTypeDropDown;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	//intialization
	public CreateNewOrganizationPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getAccountTypeDropDown() {
		return accountTypeDropDown;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Libraries
	public void CreateNewOrg(String orgname)
	{
		OrgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void CreateNewOrg(String orgname,String industryType)
	{
		OrgNameEdt.sendKeys(orgname);
		handleDropDown(industryType,industryDropDown);
		
		
		
	}
	public void CreateNewOrg(String orgname,String industryType,String accounttype) {
		OrgNameEdt.sendKeys(orgname);
		handleDropDown(industryType,industryDropDown);
		handleDropDown(accounttype,accountTypeDropDown);
		
	}
	public void ClickOnSave() {
		saveBtn.click();
	}

		
	}
	
	
	
	
	
	

