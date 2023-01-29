package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utiles.ElementUtiles;

public class HomePage {
	
	WebDriver driver;
	private ElementUtiles elementUtiles;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	public void clickOnMyAccountDropMenu()
	{
		elementUtiles.clickOnElement(myAccountDropMenu, 30);
	}
	
	public LoginPage selectLoginOption()
	{
		elementUtiles.clickOnElement(loginOption, 30);
		return new LoginPage(driver);
	}
	
	public void selectRegisterOption()
	{
		elementUtiles.clickOnElement(registerOption, 30);
	
	}
}
