package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractMethods;

public class LandingPage extends AbstractMethods {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userElement = driver.findElement(By.cssSelector("input[id='userEmail']"));
	@FindBy(css="input[id='userEmail']")
	WebElement userEmail;
	
	@FindBy(css="input[id='userPassword']")
	WebElement userPassword;
	
	@FindBy(css="input[id='login']")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessagElement;
	
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessagElement);
		return errorMessagElement.getText();
	}
	
	public CataloguePage loginAction(String userName , String UserPassword) {
		
		userEmail.sendKeys(userName);
		userPassword.sendKeys(UserPassword);
		submit.click();
		
		return new CataloguePage(driver);
		
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	
	
	
}
