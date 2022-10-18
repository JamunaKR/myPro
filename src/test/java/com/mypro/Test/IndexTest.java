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

import obj.repository.IndexPage;

/**
 * @author DELL
 *
 */
public class IndexTest extends BaseClass{
	IndexPage indexpage;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogo() {
		indexpage =new IndexPage();
		boolean res=indexpage.logoButton();
		Assert.assertTrue(res);
	}
	
	@Test
	public void verifyTitle() {
		indexpage=new IndexPage();
		String actTitle=indexpage.isTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	
	
}
