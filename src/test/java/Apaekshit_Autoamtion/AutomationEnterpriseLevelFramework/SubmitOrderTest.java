package Apaekshit_Autoamtion.AutomationEnterpriseLevelFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pageObjects.CartPage;
import pageObjects.CataloguePage;
import pageObjects.CheckOut;
import pageObjects.OrderPage;
import pageObjects.SummaryPage;
import testComponents.BaseTest;
import testComponents.Retry;



public class SubmitOrderTest extends BaseTest {
	String CartProd = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData",groups = {"Purchase"},retryAnalyzer = Retry.class)
	// This is for Array type dataProvider method
	//public void submitOrder(String emailString , String passwordString , String productNameString) throws IOException {
	public void submitOrder(HashMap<String, String> input) throws IOException {
		
		String emailString= input.get("email");
		String passwordString= input.get("password");
		String productNameString= input.get("productName");
		
		CataloguePage cataloguePage = landingPage.loginAction(emailString, passwordString);
		cataloguePage.addProductToCart(productNameString);
		
		 
		
		CartPage cartPage = cataloguePage.goToCart();
		Boolean match = cartPage.verifyProductDisplay(productNameString);
		Assert.assertTrue(match);
		
		 CheckOut checkOut = cartPage.checkOut();
		 checkOut.selectCountry("India");
		SummaryPage summaryPage = checkOut.placeOrder();
		
		
		 String validate= summaryPage.getProductName();
		 AssertJUnit.assertTrue(validate.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		

	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistory() {
		CataloguePage cataloguePage = landingPage.loginAction("demotest7@gmail.com", "Admin123");
		OrderPage orderPage = cataloguePage.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(CartProd));
		
	}
	
	@DataProvider
	private Object[][] getData() throws IOException {
		// Hashmap way of passing data (not from a file, directly hardcoding)
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "demotest7@gmail.com");
//		map.put("password","Admin123");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("email", "demotest777@gmail.com");
//		map2.put("password","Admin@123");
//		map2.put("productName", "ADIDAS ORIGINAL");
		List<HashMap<String, String>>data = getJsonDataToMap("\\src\\test\\java\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};

	}
	
	// Array Method
//	@DataProvider
//	public Object[][] getData() {
//		
//		
//		return new Object[][] {{"demotest7@gmail.com", "Admin123","ZARA COAT 3"},{"demotest777@gmail.com","Admin@123","ADIDAS ORIGINAL"}};
//	}

}
