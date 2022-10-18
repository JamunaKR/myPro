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

import obj.repository.AccountCreationPage;
import obj.repository.IndexPage;
import obj.repository.LoginPage;

/**
 * @author DELL
 *
 */
public class AccountCreationPageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();
	}
	 
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	public void validateCreateAccountPage() {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignInBtn();
		accountcreationpage=loginpage.createNewAccount("abcdefgh12@gmail.com");
		boolean actTitle=accountcreationpage.validateAccountCreationPageTitle();
		Assert.assertTrue(actTitle);
	}
}
