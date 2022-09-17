package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewProductPage {
	@FindBy(name="productname")
	private WebElement productnameEdt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement VendorLookUpImg;

}
