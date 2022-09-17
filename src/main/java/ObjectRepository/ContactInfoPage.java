package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;


//initilization
public ContactInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//utilization


public WebElement getContactHeaderTxt() {
	return ContactHeaderTxt;
}
public String GetContactHeader()
{
	String contactheader = ContactHeaderTxt.getText();
	return contactheader;
}

	
}