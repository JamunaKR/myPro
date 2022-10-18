/**
 * 
 */
package com.mypro.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mypro.base.BaseClass;

import obj.repository.HomePage;
import obj.repository.IndexPage;
import obj.repository.LoginPage;

/**
 * @author DELL
 *
 */
public class HomePageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void whishListTest() {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignInBtn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean res=homepage.validateMyWishlist();
		Assert.assertTrue(res);
	}
	
	@Test
	public void orderHistoryAndDetailsTest() {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignInBtn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean res1=homepage.validateOrderHistory();
		Assert.assertTrue(res1);
	}

}
