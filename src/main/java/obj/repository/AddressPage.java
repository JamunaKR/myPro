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
public class AddressPage extends BaseClass{
Action act=new Action();

@FindBy(xpath="//span[.='Proceed to checkout']")
WebElement proceedToCheckOut;

public AddressPage() {
	PageFactory.initElements(driver, this);
}

public ShippingPage clickProceedToCheckOut() {
	act.click(driver, proceedToCheckOut);
	return new ShippingPage();
}

}
