package stepdefinitions;

import org.openqa.selenium.WebDriver;

import PageObject.AccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import Utiles.CommonUtiles;
import factory.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	private LoginPage lp;
	private AccountPage ap;
	@Given("User has to Navigate To LoginPage")
	public void user_has_to_navigate_to_login_page() {
		driver=Driver.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		lp=homepage.selectLoginOption();
	}

	@When("User Enters Valid Email Address {string} into username text box")
	public void user_enters_valid_email_address_into_username_text_box(String validemail) {
		
		lp.enterEmailAddress(validemail);
	}

	@And("User Has Entered Valid Password {string} into password textbox")
	public void user_has_entered_valid_password_into_password_textbox(String validpassword) {
		lp.enterPassword(validpassword);
	}

	@And("User Clicks on Loginbutton")
	public void user_clicks_on_loginbutton() {
	    ap=lp.clickOnLoginbtn();
	}

	@Then("User Should Get Successfully Logged in")
	public void user_should_get_successfully_logged_in() {
			ap.visiblityofEditYourAccountLink();
	}
	
	@When("^User Enters Valid Email Address (.+) into username text box field$")
	public void user_enters_valid_email_address_into_username_text_box_field(String email) {
		lp = new LoginPage(driver);
		lp.enterEmailAddress(email);
	}

	@And("^User Has Entered Valid Password (.+) into password textbox field$")
	public void user_has_entered_valid_password_into_password_textbox_field(String pwd) {
		lp.enterPassword(pwd);
	}
	
	@When("User Enters Invalid Email Address into username text box")
	public void user_enters_invalid_email_address_into_username_text_box() {
		lp = new LoginPage(driver);
		lp.enterEmailAddress(CommonUtiles.getEmailTimeStamp());
	}

	@And("User Has Entered Invalid Password {string} into password textbox")
	public void user_has_entered_invalid_password_into_password_textbox(String invalidpassword) {
		lp.enterPassword(invalidpassword);
	}

	@Then("User Should Get Warning Message")
	public void user_should_get_warning_message() {
		lp.warningInvalidEmailOrPasswordMessage();
	}

	@When("User Dont Enter Email into username text box")
	public void user_dont_enter_email_into_username_text_box() {
		lp = new LoginPage(driver);
		lp.enterEmailAddress("");
	}

	@And("User Dont Enter Password into password textbox")
	public void user_dont_enter_password_into_password_textbox() {
		lp.enterPassword("");
	}

}
