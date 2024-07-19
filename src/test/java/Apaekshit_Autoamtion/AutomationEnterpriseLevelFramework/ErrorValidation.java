package Apaekshit_Autoamtion.AutomationEnterpriseLevelFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CataloguePage;
import testComponents.BaseTest;

public class ErrorValidation extends BaseTest{

	@Test(groups = {"errorHandling"})
	public void errorValidation() throws IOException {
		
		
		
		landingPage.loginAction("demotest7@gmail.com", "Admin23");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage() ); 
	}
	
	
	@Test(groups = {"errorHandling"})
	public void productErrorValidation() throws IOException {
		
		
		
		CataloguePage cataloguePage = landingPage.loginAction("demotest7@gmail.com", "Admin123");
		String CartProd = "ADIDAS ORIGINAL";
		cataloguePage.addProductToCart(CartProd);
		
		 
		
		CartPage cartPage = cataloguePage.goToCart();
		Boolean match = cartPage.verifyProductDisplay("Abibas");
		Assert.assertFalse(match);
		

	}

}
