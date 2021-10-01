package steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.actions.ANZ_HomePage;
import utils.SeleniumDriver;

public class AnzSteps {

	ANZ_HomePage anzActions = new ANZ_HomePage();

	@Given("^I am on the Home Page \"([^\"]*)\" of \"([^\"]*)\" Website$")
	public void i_am_on_the_Home_Page_of_AutomationPractise_Website(String webSiteURL,String webSite) {
		SeleniumDriver.openPage(webSiteURL);

	}

	@Then("^I enter the \"([^\"]*)\" on \"([^\"]*)\"$")
	public void enterTheDetails(String details, String page, Map<String, String> map) {
		if (page.equalsIgnoreCase("BorrowPage")) {
			anzActions.enterDetails(map);
		}
	}

	@Then("^verify the \"([^\"]*)\" displayed on \"([^\"]*)\"$")
	public void validateTheDetails(String details, String page, Map<String, String> map) {

		if (page.equalsIgnoreCase("BorrowPage")) {
			anzActions.validateDetails(map);
		}
	}

	@And("^clicked on \"([^\"]*)\" link$")
	public void click_on_link(String link) {

		anzActions.clickOnElement(link);
	}

	@And("^moved to \"([^\"]*)\" element$")
	public void move_to_element(String link) {

		anzActions.moveToElement(link);
	}

}
