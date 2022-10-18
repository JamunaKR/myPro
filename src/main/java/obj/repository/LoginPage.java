package obj.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mypro.actiondriver.Action;
import com.mypro.base.BaseClass;

public class LoginPage extends BaseClass {
	
	//WebDriver driver;
	Action act=new Action();
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(name="passwd")
	WebElement pwdId;
	
	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	@FindBy(id="email_create")
	WebElement createEmail;
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccount;
	
	public LoginPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public HomePage login(String uname, String pwd) {
		act.type(emailId, uname);
		act.type(pwdId, pwd);
		act.click(driver, signInButton);
		return new HomePage();
	}
	
	//When we do not signIn initially
	public AddressPage login1(String uname, String pwd) {
		act.type(emailId, uname);
		act.type(pwdId, pwd);
		act.click(driver, signInButton);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		act.type(createEmail, newEmail);
		act.click(driver, createAnAccount);
		return new AccountCreationPage();
	}
	
}
