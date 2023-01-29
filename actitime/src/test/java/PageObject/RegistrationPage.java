package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "input-firstname")
	private WebElement textfirstname;
	
	@FindBy(id = "input-lastname")
	private WebElement textlastname;
	
	@FindBy(id = "input-email")
	private WebElement textemail;
	
	@FindBy(id = "input-telephone")
	private WebElement texttelephone;
	
	@FindBy(id = "input-password")
	private WebElement textpassword;
	
	@FindBy(id = "input-confirm")
	private WebElement textconfirmpassword;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement selectboxprivacyPlicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterRadiobtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement alreadyEmailRegisteredmsg;
	
	public void msgEmailAlreadyReg()
	{
		Assert.assertEquals("Warning: E-Mail Address is already registered!",alreadyEmailRegisteredmsg.getText());
	}
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningprivacypolicy ;
	
	public void warningprivacyMsg()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']/following-sibling::div" )
	private WebElement  warningfirstname;
	
	public void warningFirstNameMsg()
	{
		Assert.assertEquals("First Name must be between 1 and 32 characters!",warningfirstname.getText());
	}
	
	@FindBy(xpath ="//input[@id='input-lastname']/following-sibling::div" )
	private WebElement  warninglastname;
	
	public void warningLastNameMsg()
	{
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",warninglastname.getText());
	}
	
	@FindBy(xpath ="//input[@id='input-email']/following-sibling::div" )
	private WebElement warningEmail;
	public void warningEmailMsg()
	{
		Assert.assertEquals("E-Mail Address does not appear to be valid!",warningEmail.getText());
	}
	
	
	@FindBy(xpath ="//input[@id='input-telephone']/following-sibling::div" )
	private WebElement  warningTelephone;
	public void warningTelephoneMsg()
	{
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",warningTelephone.getText());
	}
		
	@FindBy(xpath ="//input[@id='input-password']/following-sibling::div" )
	private WebElement warningpassword ;
	public void warningPasswordMsg()
	{
		Assert.assertEquals("Password must be between 4 and 20 characters!", warningpassword.getText());
	}
	
	public void enterFirstName(String firstnametext)
	{
		textfirstname.sendKeys(firstnametext);
	}
	
	public void enterLastName(String lastnametext)
	{
		textlastname.sendKeys(lastnametext);
	}
	
	public void enterEmail(String emailtext)
	{
		textemail.sendKeys(emailtext);
	}
	
	public void enterTelephone(String telephonenumber)
	{
		texttelephone.sendKeys(telephonenumber);
	}
	
	public void enterPassword(String password)
	{
		textpassword.sendKeys(password);
	}
	
	public void enterconfirmPassword(String confirmpassword)
	{
		textconfirmpassword.sendKeys(confirmpassword);
	}
	
	public void selectPrivacyPolicy()
	{
		selectboxprivacyPlicy.click();
	}
	
	public AccountSuccessPage clickOnContinuebutton()
	{
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	
	
	public void selectNewsLetter()
	{
		newsLetterRadiobtn.click();
	}
	
	
}


























