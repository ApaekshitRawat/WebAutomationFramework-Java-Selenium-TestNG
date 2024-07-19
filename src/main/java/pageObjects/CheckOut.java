package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractMethods;

public class CheckOut extends AbstractMethods{
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	By countryPlaceholderBy = By.cssSelector("[placeholder='Select Country']");
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryPlaceholderElement;
	
	@FindBy(css=".ta-results .ta-item:nth-child(3)")
	WebElement selectedCountryElement;
	
	@FindBy(css=".action__submit")
	WebElement submitElement;
	
	By submitBy = By.cssSelector(".action__submit");
	
	
	
	public void selectCountry(String country) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
		
		waitForElementsToAppear(countryPlaceholderBy);
		 Actions a = new Actions(driver);
		 a.sendKeys(driver.findElement(countryPlaceholderBy),country).build().perform();
//		 
//		 driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].value = 'India';", countryPlaceholderElement);
		 
		 selectedCountryElement.click();
		 
		 
		 
	}
	public SummaryPage placeOrder() {
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		waitForElementsToAppear(submitBy);
		 //WebElement Submit = driver.findElement(By.cssSelector(".action__submit"));
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", submitElement);
		 //driver.findElement(By.cssSelector(".action__submit")).click();
		 return new SummaryPage(driver);
	}
}
