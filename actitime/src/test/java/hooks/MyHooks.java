package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utiles.ReadConfig;
import factory.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@Before
	public void setUp()
	
	{
		ReadConfig r = new ReadConfig();
		driver=Driver.initializeBrowser(r.setBrowser());
		driver.get(r.setURL());
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String name = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			byte[] srcfile = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcfile,"image/png", name);
			
		}
		driver.quit();
	}
}
