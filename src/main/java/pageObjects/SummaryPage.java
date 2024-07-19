package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractMethods;

public class SummaryPage extends AbstractMethods {
	
	WebDriver driver;
	public SummaryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement headingElement;
	
	 //String validate = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
		
	 public String getProductName() {
		return headingElement.getText();
	}
	
	
}
