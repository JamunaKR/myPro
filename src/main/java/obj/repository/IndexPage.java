package obj.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mypro.actiondriver.Action;
import com.mypro.base.BaseClass;

public class IndexPage extends BaseClass{

Action act=new Action();
	
	
	@FindBy(xpath="//div[@class='header_user_info']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logoButton;
	
	@FindBy(id="search_query_top")
	WebElement searchText;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage clickOnSignInBtn() {
		act.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public Boolean logoButton() {
		return act.isDisplayed(driver, logoButton);
	}
	
	public String isTitle() {
		String title=driver.getTitle();
		return title;
	}
	public SearchResultPage searchProduct(String productName) {
		act.type(searchText, productName);
		act.click(driver, searchBtn);
		return new SearchResultPage();
	}
	
	
	

}
