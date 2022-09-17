package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.DriverUtility;

public class CreateContactPage extends DriverUtility {

	


	@FindBy(name="lastname")
	private WebElement ContactNameEdt;
	
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookUpImg;
	
	@FindBy(id="search_txt")
	
	private WebElement searchTextEdt;
	
	
	@FindBy(name="search")
	private WebElement searchBoxBtn;
	
	@FindBy(name="leadsource")
	
	private WebElement leadSourceType;
	
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	
	public  CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		
	}


	public WebElement getContactNameEdt() {
		return ContactNameEdt;
	}


	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}


	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}


	public WebElement getSearchBoxBtn() {
		return searchBoxBtn;
	}


	public WebElement getLeadSourceType() {
		return leadSourceType;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void CreateNewContact(String LASTNAME) {
		
		ContactNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	public void CreateNewContact(String LASTNAME, String leadsourcedropdown) {
		ContactNameEdt.sendKeys(LASTNAME);
		handleDropDown(leadsourcedropdown,leadSourceType);
		saveBtn.click();
	}
	public void CreateNewContact(String LASTNAME,String orgname,WebDriver driver) {
		ContactNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		searchTextEdt.sendKeys(orgname);
		 searchBoxBtn.click();
		 driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		 switchToWindow(driver,"Contacts");
		 saveBtn.click();
		
		
	}
	
	
	


}