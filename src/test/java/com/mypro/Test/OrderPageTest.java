/**
 * 
 */
package com.mypro.Test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mypro.base.BaseClass;

import obj.repository.AddToCartPage;
import obj.repository.IndexPage;
import obj.repository.LoginPage;
import obj.repository.OrderPage;
import obj.repository.SearchResultPage;

/**
 * @author DELL
 *
 */
public class OrderPageTest extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchrespag;
	AddToCartPage addtocartpag;
	OrderPage orderpage;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	/*public OrderPageTest() {
		PageFactory.initElements(driver, this);
	}*/
	
	@Test
	public void VerifyTotalPrice() throws Exception {
		OrderPage op = PageFactory.initElements(driver, OrderPage.class);
		orderpage=new OrderPage();
		indexpage=new IndexPage();
		searchrespag=indexpage.searchProduct("t-shirt");
		addtocartpag=searchrespag.clickOnProduct();
		addtocartpag.enterQuantity("2");
		addtocartpag.selectSizeVal("M");
		addtocartpag.clickOnAddToCart();
		orderpage=addtocartpag.clickOnProceedAddToCart(); 							//Toget into the method loop press ctrl+mouseover then click
		double unitprice=orderpage.getUnitPriceVal(op.getUnitPrice());
		double totalprice=orderpage.getFinalTotalPrice(op.getTotalPrice());
		double totalExpPrice=(unitprice*2)+2;
		System.out.println("Total Expected price "+ totalExpPrice);
	Assert.assertEquals(totalprice, totalExpPrice);
	
	}
	
	
}
