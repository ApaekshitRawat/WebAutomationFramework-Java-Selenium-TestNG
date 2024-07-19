package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrderPage;

public class AbstractMethods {

	WebDriver driver;

	public AbstractMethods(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement Cart;
	@FindBy(css="[routerlink*='myorders']")
	WebElement Order;
	
	public void waitForElementsToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(ele));

	}
		public CartPage goToCart() {
		
		waitForElementsToAppear(By.cssSelector("[routerlink*='cart']"));
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				Cart);
		
		return new CartPage(driver);

				 //driver.findElement(By.cssSelector("[routerlink*='cart']")));

	}
		public OrderPage goToOrderPage() {
			
			waitForElementsToAppear(By.cssSelector("[routerlink*='myorders']"));
		
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					Order);
			
			return new OrderPage(driver);

					 

		}


}
