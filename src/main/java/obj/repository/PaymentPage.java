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
public class PaymentPage extends BaseClass {
	Action act=new Action();
	
	@FindBy(xpath="//a[contains(.,'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath="//a[contains(.,'Pay by check')]")
	WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
		}
	
	public OrderSummary clickOnPaymentMethod() {
		act.click(driver, bankWireMethod);
		return new OrderSummary();
	}

}
