package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import PageObject.AccountSuccessPage;
import PageObject.HomePage;
import PageObject.RegistrationPage;
import Utiles.CommonUtiles;
import factory.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration {
	public static WebDriver driver;
	RegistrationPage rp;
	@Given("User Navigates to Registration Page")
	public void user_navigates_to_registration_page() {
		driver=Driver.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccountDropMenu();
		hp.selectRegisterOption();
	}
	
	@When("User Enters the details into below Fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    rp = new RegistrationPage(driver);
		rp.enterFirstName(dataMap.get("FirstName"));
	    rp.enterLastName(dataMap.get("LastName"));
	    rp.enterEmail(CommonUtiles.getEmailTimeStamp());
	    rp.enterTelephone(dataMap.get("Telephone"));
	    rp.enterPassword(dataMap.get("Password"));
	    rp.enterconfirmPassword(dataMap.get("PasswordConfirm"));
	
	}
	
	@When("User Enters the details into below Fields with new Email")
	public void user_enters_the_details_into_below_fields_with_new_email(DataTable dataTable) {
	    Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    rp = new RegistrationPage(driver);
		rp.enterFirstName(dataMap.get("FirstName"));
	    rp.enterLastName(dataMap.get("LastName"));
	    rp.enterEmail(CommonUtiles.getEmailTimeStamp());
	    rp.enterTelephone(dataMap.get("Telephone"));
	    rp.enterPassword(dataMap.get("Password"));
	    rp.enterconfirmPassword(dataMap.get("PasswordConfirm"));
	
	}
	
	@When("User Enters the details into below Fields with existing Email")
	public void user_enters_the_details_into_below_fields_with_existing_email(DataTable dataTable) {
	    Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    RegistrationPage rp = new RegistrationPage(driver);
		rp.enterFirstName(dataMap.get("FirstName"));
	    rp.enterLastName(dataMap.get("LastName"));
	    rp.enterEmail(dataMap.get("Email"));
	    rp.enterTelephone(dataMap.get("Telephone"));
	    rp.enterPassword(dataMap.get("Password"));
	    rp.enterconfirmPassword(dataMap.get("PasswordConfirm"));
	 }
	
	
	@And("User Selects Privacy Policy")
	public void uswer_selects_privacy_policy() {
		rp.selectPrivacyPolicy();
	      
	}

	@And("User Clicks On ContinueButton")
	public void user_clicks_on_continue_button() {
		rp = new RegistrationPage(driver);
		rp.clickOnContinuebutton();
	}

	@Then("User Account Should get Created")
	public void user_account_should_get_created() {
		AccountSuccessPage asp = new AccountSuccessPage(driver);
		asp.verifyaccountcreatedmessage();
		}

	@And("User Selects YES for NewsLetter RadioButton")
	public void user_selects_yes_for_news_letter_radio_button() {
		rp = new RegistrationPage(driver);
		rp.selectNewsLetter();
	}

	@Then("User Must get Proper Warning Message")
	public void user_must_get_proper_warning_message() {
		
		rp.msgEmailAlreadyReg();
	}

	@When("User Dont Enter any details into below Fields")
	public void user_dont_enter_any_details_into_below_fields() {
	    RegistrationPage rp = new RegistrationPage(driver);
		rp.enterEmail("");
	}

	@Then("User Must get Proper Warning Messages For All Mandatory Fields")
	public void user_must_get_proper_warning_messages_for_all_mandatory_fields() {
		
		rp.warningprivacyMsg();
		rp.warningFirstNameMsg();
		rp.warningLastNameMsg();
		rp.warningEmailMsg();
		rp.warningTelephoneMsg();
		rp.warningPasswordMsg();
		
	}
	
}









