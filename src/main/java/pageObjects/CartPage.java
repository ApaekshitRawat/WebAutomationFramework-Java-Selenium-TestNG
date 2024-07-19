package pageObjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AbstractMethods;

public class CartPage extends AbstractMethods{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css=".cart h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".subtotal button[class*='btn']")
	WebElement checkOutBtn;
	
	 
	
	public Boolean verifyProductDisplay(String name) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(name));
		return match;
		
		
	}
	
	public CheckOut checkOut() {
		checkOutBtn.click();
		return new CheckOut(driver);
	}
	
	
}	
