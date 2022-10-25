/**
 * 
 */
package obj.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mypro.actiondriver.Action;
import com.mypro.base.BaseClass;

/**
 * @author DELL
 *
 */
public class OrderPage {
	Action act=new Action();
	//WebDriver driver;
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price_container")
	private WebElement totalPrice;
	
	@FindBy(xpath="//p/a[@title='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	/*public OrderPage() {
		PageFactory.initElements(driver, this);
	}*/
	
	public double getUnitPriceVal(WebElement e) {
		String unitPrice1=e.getText();
		String unit=unitPrice1.substring(1);	 								//Converting special Char to Blank and we are ignoring the $ place and taking the placeholder from 1st index.(not from 0th index)
		double finalUnit=Double.parseDouble(unit); 					//Converting string to double
		System.out.println("The final unit price val " + finalUnit);
		return finalUnit; 																	//here /100 becz we get in terms of 1651 [for 16.51] but getting error
	}
	
	public WebElement getUnitPrice() {
		return unitPrice;
	}

	public double getFinalTotalPrice(WebElement f) {
		String totalPrice1=f.getText();
		String total=totalPrice1.substring(1); 									//Converting special Char to Blank	
		double finalTotalPrice=Double.parseDouble(total);	 			//Converting string to double
		System.out.println("The final total price val " + finalTotalPrice);
		return finalTotalPrice; 														//here /100 becz we get in terms of 1651 [for 16.51]
	}
	
	public LoginPage clickProceedToCheckout() throws Exception {
		act.fluentWait(BaseClass.driver, proceedToCheckout, 20);
		act.click(BaseClass.driver, getProceedToCheckout());
		return new LoginPage();
	}

	public Action getAct() {
		return act;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getProceedToCheckout() {
		return proceedToCheckout;
	}
}
