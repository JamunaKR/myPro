/**
 * 
 */
package com.mypro.Test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mypro.base.BaseClass;
import com.mypro.utility.EventList;

import obj.repository.AddToCartPage;
import obj.repository.AddressPage;
import obj.repository.IndexPage;
import obj.repository.LoginPage;
import obj.repository.OrderConfirmationPage;
import obj.repository.OrderPage;
import obj.repository.OrderSummary;
import obj.repository.PaymentPage;
import obj.repository.SearchResultPage;
import obj.repository.ShippingPage;

/**
 * @author DELL
 *
 */

@Listeners(EventList.class)
public class EndToEndTest extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchrespag;
	AddToCartPage addtocartpag;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummary ordersummary;
	OrderConfirmationPage orderconfirmpage;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		report.flush(); 																													//6
		test.pass("Logged out from the app");																		//10
	}

	@Test
	public void endToEndTest() throws Exception {
		test=report.createTest("End To End Test");																	//7											
		
		OrderPage op=PageFactory.initElements(driver, OrderPage.class);
		//LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		loginpage=new LoginPage();
		indexpage=new IndexPage();
		orderpage=new OrderPage();
		searchrespag=indexpage.searchProduct("t-shirt");
		addtocartpag=searchrespag.clickOnProduct();
		test.pass("Clicked the product");																				//9
//Assert.assertFalse(true);								//In order to verify the failed script of Extent report.
		addtocartpag.enterQuantity("2");
		addtocartpag.selectSizeVal("M");
		addtocartpag.clickOnAddToCart();
		test.pass("Clicked the product to cart");																	//9
		
		orderpage=addtocartpag.clickOnProceedAddToCart();
		test.pass("Clicked the proceed to pay");																	//9
		
		orderpage.getUnitPrice();
		orderpage.getFinalTotalPrice(op.getTotalPrice());
		//loginpage=orderpage.clickProceedToCheckout();
		op.getProceedToCheckout().click();
		test.pass("Clicked the proceed to check out of order page");
		
		addresspage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage=addresspage.clickProceedToCheckOut();
		test.pass("Clicked the proceed to check out of shipping  page");
		
		shippingpage.checkTheTerms();
		paymentpage=shippingpage.clickProceedToCheckOut();
		ordersummary=paymentpage.clickOnPaymentMethod();
		orderconfirmpage=ordersummary.clickConfirmOrderBtn();
		String actualMes=orderconfirmpage.validateConfirmMessage();
		String expMes="Your order on My Store is complete.";
		Assert.assertEquals(actualMes, expMes);
		test.pass("All tests are passed");
	}
}
