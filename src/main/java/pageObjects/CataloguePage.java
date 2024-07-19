package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.AbstractMethods;

public class CataloguePage extends AbstractMethods{

	WebDriver driver;

	public CataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));		
	@FindBy(css=".mb-3")
	List<WebElement>Products;
	By productsBy = By.cssSelector(".mb-3");
	
	By productName = By.cssSelector("b");
	
	By addToCartBy = By.cssSelector(".card button:last-of-type");
	
	
	
	public List<WebElement> getProductList() {
		
		waitForElementsToAppear(productsBy);
		return Products;
	}
	
	public WebElement getProductByName(String name) {
		 WebElement prod = getProductList().stream().filter(product->
		 product.findElement(productName).getText().equals(name)).findFirst().orElse(null);
		 
		 return prod;

	}
	
	public void addProductToCart(String name) {
		WebElement	prod = getProductByName(name);
		prod.findElement(addToCartBy).click();
		 	
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));	
		 waitForElementToDisappear(By.cssSelector(".ng-animating"));
		// waitForElementsToAppear(By.cssSelector("#toast-container"));
	}
	
	}
