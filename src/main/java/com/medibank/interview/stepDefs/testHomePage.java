/*  Author : Raghu Alapati
 *  Feature Mapped : Home Page Header for checking products and packages
 *  Versioning: Master Branch - prod code base (4-11-15)
 *  To do list:
 *  Changes by team:
 *  
 */
package com.medibank.interview.stepDefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.medibank.interview.genericResources.BaseTest;
import com.medibank.interview.pageObjects.HomePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;

public class testHomePage extends BaseTest {

	public testHomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver = null;
	public HomePage hp = null;

	@Given("^I open the home page$")
	public void I_open_the_home_page() throws Throwable {
		this.driver = getDriver();
		hp = new HomePage(driver);

		assertTrue("I have landed on the home page:",
				hp.checkIfLandedOnHomePage() == true);
	}

	@When("^I explore the \"([^\"]*)\"$")
	public void I_explore_the_products(String arg1, DataTable dt)
			throws Throwable {
		List<Map<String, String>> rows = dt.asMaps();
		System.out.println("Current Targer product: " + arg1);
		// checks Product link
		hp.checkProduct(arg1);

		// checks the packages under each product.
		hp.checkPackages(rows, arg1);

	}

	@Then("^I should see all the required package info$")
	public void I_should_see_all_the_required_info() throws Throwable {
		// To implement ...check for page content and assert

	}

	@Before
	public void startUp() throws IOException {
		// BaseTest b= new BaseTest();

		// get the driver with home page loaded up
		// this.driver=b.getDriver();
	}

	@After
	public void tearDown() {

		// quit the driver for clean start.
		driver.quit();
	}

}
