/**
 * @author rahul.rathore
 *	
 *	16-Aug-2016
 */
package com.cucumber.framework.stepdefinition;

import org.testng.Assert;

import com.cucumber.framework.helper.PageObject.homepage.HomePage;
import com.cucumber.framework.helper.PageObject.laptoppage.LaptopPage;
import com.cucumber.framework.settings.ObjectRepo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author rahul.rathore
 *
 *         16-Aug-2016
 *
 */
public class SearchStepDfn {

	@Given("^: I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		HomePage hPage = new HomePage(ObjectRepo.driver);
		ObjectRepo.data.put(HomePage.class, hPage);
	}

	@When("^: I click on the laptops search filter$")
	public void _i_click_on_the_laptops_search_filter() throws Throwable {
		LaptopPage lPage = ((HomePage)ObjectRepo.data.get(HomePage.class)).navigateToLaptop();
		ObjectRepo.data.put(LaptopPage.class, lPage);
	}

	@Then("^: I should be at the laptop search page$")
	public void _i_should_be_at_the_laptop_search_page() throws Throwable {
		Assert.assertEquals(((LaptopPage)ObjectRepo.data.get(LaptopPage.class)).getItems(),"36 items");
	}

	@And("^: The title should be laptop search page title$")
	public void _the_title_should_be_laptop_search_page_title()
			throws Throwable {
		Assert.assertTrue(((LaptopPage)ObjectRepo.data.get(LaptopPage.class)).checkForTitle("Laptops"));
	}

}