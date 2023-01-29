package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

WebDriver driver;
	
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "(//div[@id='content']//p)[1]")
	private WebElement accntCreatedmsg;
	
	public void verifyaccountcreatedmessage()
	{
		Assert.assertEquals(accntCreatedmsg.getText().contains("Congratulations!"),true);
	}
}
