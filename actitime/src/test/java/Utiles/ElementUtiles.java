package Utiles;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtiles {
	
	
	WebDriver driver;
	
	public ElementUtiles(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement waitForElement(WebElement element,long durationInseconds)
	{
		WebElement webelement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInseconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return webelement;
		
	}
	public void clickOnElement(WebElement element,long durationInseconds)
	{
		WebElement webelement = waitForElement(element, durationInseconds);
		element.click();
	}
	
	public void typeTextIntoElement(WebElement element,String text,long durationInseconds)
	{
		waitForElement(element, durationInseconds);
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	public void selectOptionInDropDown(WebElement element,String dropDowdOption,long durationInseconds)
	{
		WebElement webelement = waitForElement(element,durationInseconds);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropDowdOption);
	}
	
	public Alert waitForAlert(WebElement element,long durationInseconds)
	{
		Alert alert=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInseconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void acceptAlert(WebElement element,long durationInseconds)
	{
		Alert alert = waitForAlert(element, durationInseconds);
		driver.switchTo().alert();
		alert.accept();
	}
	
	public void dismissAlert(WebElement element,long durationInseconds)
	{
		Alert alert = waitForAlert(element, durationInseconds);
		driver.switchTo().alert();
		alert.dismiss();;
	}
	
	public void mouseHoverandClick(WebElement element,long durationInseconds)
	{
		WebElement webelement = waitForVisibilityOfElement(element, durationInseconds);
		Actions action = new Actions(driver);
		action.moveToElement(webelement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInseconds)
	{
		WebElement webelement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInseconds));
		webelement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	
	
	public void javaScriptClick(WebElement element,long durationInseconds)
	{
		WebElement webelement = waitForVisibilityOfElement(element, durationInseconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("argument[0].click();", webelement);
	}
	
	public void javaScriptTyping(WebElement element,long durationInseconds,String text)
	{
		WebElement webelement = waitForVisibilityOfElement(element, durationInseconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+text+"'" , webelement);
	}
	
}
