package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.DriverUtility;

public class HomePage extends DriverUtility {
	//declaration
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslnk;
	
	
	@FindBy(linkText="Leads")
	private WebElement leadslnk;
	
	
	
	@FindBy(linkText="Products")
	private WebElement productslnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administartorimg;
	
	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signoutbtn;
	

// Intialization

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
//utilization


public WebElement getOrganizationlnk() {
	return organizationlnk;
}


public WebElement getContactslnk() {
	return contactslnk;
}


public WebElement getLeadslnk() {
	return leadslnk;
}


public WebElement getProductslnk() {
	return productslnk;
	
}


public WebElement getAdministartorimg() {
	return administartorimg;
}


public WebElement getSignoutbtn() {
	return signoutbtn;
}
//utilization using  business library
public void ClickonOrgLink() {
	organizationlnk.click();
}
public void ClickOnContactsLink() {
	contactslnk.click();
}
public void ClickOnLeadsLink() {
	leadslnk.click();
}

public void ClickOnProductsLink() {
	productslnk.click();
}
public void signOutOfApp(WebDriver driver)

{
	mouseHover(driver,administartorimg);
	signoutbtn.click();
	
	
}






	

	


	
}











