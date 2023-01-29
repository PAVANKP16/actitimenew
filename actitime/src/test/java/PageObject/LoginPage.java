package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="input-email")
	WebElement textEmail;
	
	@FindBy(id ="input-password")
	WebElement textPassword;
	
	@FindBy(xpath ="//input[@value='Login']" )
	WebElement btnLogin;
	
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	WebElement warningInvalidEmailOrPasswordMessage;
	
	public void enterEmailAddress(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public AccountPage clickOnLoginbtn()
	{
		btnLogin.click();
		return new AccountPage(driver);
	}
	
	public void warningInvalidEmailOrPasswordMessage()
	{
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",warningInvalidEmailOrPasswordMessage.getText());
	}
	

}
