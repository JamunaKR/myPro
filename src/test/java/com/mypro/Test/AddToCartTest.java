/**
 * 
 */
package com.mypro.Test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mypro.base.BaseClass;

import obj.repository.AddToCartPage;
import obj.repository.IndexPage;
import obj.repository.SearchResultPage;

/**
 * @author DELL
 *
 */
public class AddToCartTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchrespag;
	AddToCartPage addtocart;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	public AddToCartTest() {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void validateAddToCartTest() throws Exception {
		indexpage=new IndexPage();
		searchrespag=indexpage.searchProduct("t-shirt");
		addtocart=searchrespag.clickOnProduct();
		addtocart.enterQuantity("2");
		addtocart.selectSizeVal("M");
		addtocart.clickOnAddToCart();
		boolean res=addtocart.ValidateAddToCartMessage();
		Assert.assertTrue(res);
	}

}
