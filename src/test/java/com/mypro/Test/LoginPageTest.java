/**
 * 
 */
package com.mypro.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mypro.base.BaseClass;
import com.mypro.utility.EventList;

import obj.repository.HomePage;
import obj.repository.IndexPage;
import obj.repository.LoginPage;

/**
 * @author DELL
 *
 */

@Listeners(EventList.class)
public class LoginPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod				//(groups= {"smoke","regression"})
	public void setup() throws IOException {
		launchApp();
	}
	
	@AfterMethod				//(groups= {"smoke","regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test 								//(groups= {"smoke"})
	public void loginTest() {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignInBtn();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		String actURL=homepage.getCurrentURL();
		String expURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actURL, expURL);
	}
	
	/*@Test(dataProvider = "signInTest") 
	public void loginTest2(String uname, String paswd) {
		//indexpage=new IndexPage();
		//loginpage=indexpage.clickOnSignInBtn();
		//homepage=loginpage.login(uname, paswd);
		System.out.println(uname+paswd);
		}*/
}
