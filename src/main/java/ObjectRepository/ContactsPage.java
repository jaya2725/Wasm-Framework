package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactlnk;
	
	
	//intialization
	
	public  ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization

	public WebElement getCreateContactlnk() {
		return createContactlnk;
	}
	
	//business library
	public void ClickOnCreateContact() {
		createContactlnk.click();
	}

}
