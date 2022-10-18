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
public class OrderSummary extends BaseClass{
	Action act=new Action();
	
	@FindBy(xpath="//span[contains(.,'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(driver, this);
		}
	
	public OrderConfirmationPage clickConfirmOrderBtn() {
		act.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}

}
