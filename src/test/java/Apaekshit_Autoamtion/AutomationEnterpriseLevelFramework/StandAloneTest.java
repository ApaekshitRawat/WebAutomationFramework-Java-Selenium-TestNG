package Apaekshit_Autoamtion.AutomationEnterpriseLevelFramework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.CartPage;
import pageObjects.CataloguePage;
import pageObjects.LandingPage;

public class StandAloneTest   {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		LandingPage landingPage = new LandingPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/client/");
		landingPage.goTo();
		landingPage.loginAction("demotest7@gmail.com", "Admin123");
//		driver.findElement(By.c ""ssSelector("input[id='userEmail']")).sendKeys("demotest7@gmail.com");
//		
//		driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("Admin123");
//		
//		
//		driver.findElement(By.cssSelector("input[id='login']")).click();
//		
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));		
		
		CataloguePage cataloguePage = new CataloguePage(driver);
		//cataloguePage.getProductList();
		cataloguePage.addProductToCart("ADIDAS ORIGINAL");
		
//		 WebElement prod = cataloguePage.getProductList().stream().filter(product->
//		 product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//		  
//		  prod.findElement(By.cssSelector(".card button:last-of-type")).click();
//		 
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));	
//		 
		 
//		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//
//		 driver.findElement(By.cssSelector("[routerlink*='cart']")));
		 
		 String CartProd = "ADIDAS ORIGINAL";
		cataloguePage.goToCart();
		CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductDisplay(CartProd);
		Assert.assertTrue(match);
		
		cartPage.checkOut();
		
		
//		 List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cart h3"));
//		 Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(CartProd));
//		 Assert.assertTrue(match);
//		 driver.findElement(By.cssSelector(".subtotal button[class*='btn']")).click();
//		 
		 
		 
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Select Country']")));
		 Actions a = new Actions(driver);
		 a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
//		 
// 		 driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].value = 'India';", driver.findElement(By.cssSelector("input[placeholder='Select Country']")));

		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		 WebElement Submit = driver.findElement(By.cssSelector(".action__submit"));


		 js.executeScript("arguments[0].click();", Submit);
		 //driver.findElement(By.cssSelector(".action__submit")).click();
		
		 String validate = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
		 
		 Assert.assertTrue(validate.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		 //driver.quit();
		  
	}

}
