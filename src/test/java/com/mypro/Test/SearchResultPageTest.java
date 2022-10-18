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
import obj.repository.SearchResultPage;

/**
 * @author DELL
 *
 */
public class SearchResultPageTest extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchrespage;
	
	@BeforeMethod
	public void setup() throws IOException {
		launchApp();
	}
	 
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void productAvailabilityTest() {
		indexpage=new IndexPage();
		searchrespage=indexpage.searchProduct("t-shirt");
		boolean res=searchrespage.isProductAvailable();
		Assert.assertTrue(res);
	}
}
