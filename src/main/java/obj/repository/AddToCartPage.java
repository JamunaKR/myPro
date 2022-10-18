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
public class AddToCartPage  extends BaseClass{
	Action act=new Action();
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size1;
	
	@FindBy(name="Submit")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2//i")
	WebElement addToCartMess;
	
	@FindBy(xpath="//span[contains(.,'Proceed to checkout')]")
	WebElement proceedAddToCart;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String Qty) {
		act.type(quantity, Qty);
	}
	
	public void selectSizeVal(String size) {
		act.selectByValue(size1, size);
	}

	
	public void clickOnAddToCart() {
		act.click(driver, addToCart);
	}
	
	public boolean ValidateAddToCartMessage() {
		act.fluentWait(driver, addToCartMess, 20);
		return act.isDisplayed(driver, addToCartMess);
	}
	
	public OrderPage clickOnProceedAddToCart() throws Exception {
		act.fluentWait(driver, proceedAddToCart, 20);
		act.JSClick(driver, proceedAddToCart);
		return new OrderPage();
	}
}
