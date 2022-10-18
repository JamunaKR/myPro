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
public class OrderConfirmationPage extends BaseClass{
	Action act=new Action();
	
	@FindBy(xpath="//strong[.='Your order on My Store is complete.']	")
	WebElement confirmMessag;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
		}
	
	public String validateConfirmMessage() {
		String confirmMes=confirmMessag.getText();
		return confirmMes;
	}

}
