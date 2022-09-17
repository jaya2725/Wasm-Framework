package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement CreateProductLookUpImg;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookUpImg() {
		return CreateProductLookUpImg;
	}

	public void ClickOnCreateLookUp() {
		 CreateProductLookUpImg.click();
	}
	
	
}
