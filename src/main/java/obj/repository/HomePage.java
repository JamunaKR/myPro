/**
 * 
 */
package obj.repository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mypro.actiondriver.Action;
import com.mypro.base.BaseClass;

/**
 * @author DELL
 *
 */
public class HomePage extends BaseClass {
	Action act=new Action();
	
	@FindBy(xpath="//a[@title='My wishlists']")
	WebElement myWishlists;
	
	@FindBy(xpath="//*[@id=\"center_column\"]//span[.='Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this); //this is other type of writing the constructor for page factory
	}
	
	public boolean validateMyWishlist() {
		return act.isDisplayed(driver, myWishlists);
	}
	
	public boolean validateOrderHistory() {
		return act.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrentURL() {
		String homepageURL=driver.getCurrentUrl();
		return homepageURL;
	}
	}