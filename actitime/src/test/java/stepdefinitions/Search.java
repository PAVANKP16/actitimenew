package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	public static WebDriver driver;
	@Given("User Opens the Application")
	public void user_opens_the_application() {
	    driver=Driver.getDriver();
	}

	@When("User Enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validproducttext) {
	    driver.findElement(By.name("search")).sendKeys(validproducttext);
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
	    driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	 Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());   
	}

	@When("User Enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproducttext) {
		driver.findElement(By.name("search")).sendKeys(invalidproducttext);
	}

	@Then("User should get Message about No product matching")
	public void user_should_get_message_about_no_product_matching() {
	    Assert.assertEquals("There is no product that matches the search criteria.",driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	}

	@When("User Dont Enter any product insearch box field")
	public void user_dont_enter_any_product_insearch_box_field() {
	   
	}

}
