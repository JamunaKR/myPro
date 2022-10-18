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
public class ShippingPage extends BaseClass {
	Action act=new Action();
	
	@FindBy(id="cgv")
	WebElement checkBox;
	
	@FindBy(xpath="//button//span[contains(.,'Proceed to checkout')]")
	WebElement proceedToCkeckOut;
	
	public ShippingPage() {
	PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms() {
		act.click(driver, checkBox);
	}
	
	public PaymentPage clickProceedToCheckOut() {
		act.click(driver, proceedToCkeckOut);
		return new PaymentPage();
	}
}
