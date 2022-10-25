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

import obj.repository.IndexPage;

/**
 * @author DELL
 *
 */
@Listeners(EventList.class)
public class IndexTest extends BaseClass{
	IndexPage indexpage;
	
	@BeforeMethod				//(groups= {"smoke","regression"})
	public void setup() throws IOException {
		launchApp();		
	}
	
	@AfterMethod				//(groups={"smoke","regression"})
	public void teardown() {
		driver.quit();
	}
	
	@Test							//(groups={"smoke"})
	public void verifyLogo() {
		indexpage =new IndexPage();
		boolean res=indexpage.logoButton();
		Assert.assertTrue(res);
	}
	
	@Test							//(groups= {"smoke"})
	public void verifyTitle() {
		indexpage=new IndexPage();
		String actTitle=indexpage.isTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	
	
}
