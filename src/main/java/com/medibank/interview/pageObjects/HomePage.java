package com.medibank.interview.pageObjects;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject {

	@FindBy(xpath = "//a[text()='Health Insurance' and @class='heading']")
	private WebElement HEALTHINSURANCE;

	@FindBy(xpath = "//a[@name='singles']")
	private WebElement Singles;

	@FindBy(xpath = "//a[@name='couples']")
	private WebElement Couples;

	@FindBy(xpath = "//a[@name='families']")
	private WebElement Families;

	@FindBy(xpath = "//a[text()='Other Insurance' and @class='heading' ]")
	private WebElement OTHERINSURANCE;

	@FindBy(xpath = "//a[text()='Pet Insurance' and @name='']")
	private WebElement PetInsurance;

	@FindBy(xpath = "//a[text()='Travel Insurance' and @name='']")
	private WebElement TravelInsurance;

	@FindBy(xpath = "//a[text()='Life Insurance' and @name='']")
	private WebElement LifeInsurance;

	@FindBy(xpath = "//a[text()='Better Health' and @class='heading']")
	private WebElement BETTERHEALTH;

	@FindBy(xpath = "//a[text()='Healthy recipes' and  @name='']")
	private WebElement Healthyrecipes;

	@FindBy(xpath = "//a[text()='Better health guides' and @name='']")
	private WebElement Betterhealthguides;

	@FindBy(xpath = "//a[text()='Get Active' and @name='']")
	private WebElement GetActive;

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean checkIfLandedOnHomePage()

	{
		Boolean status = false;
		if (driver.getTitle().equals(
				"Medibank Private Health Insurance - For Better Health")) {
			status = true;
		}
		return status;

	}

	public boolean checkPackages(List<Map<String, String>> rows, String product) {

		for (int i = 0; i < rows.size(); i++) {
			System.out.println("*********"
					+ rows.get(i).get(product).replace(" ", ""));
			assertTrue(
					"checking for package:"
							+ rows.get(i).get(product).replace(" ", ""),
					isAvailable(driver,
							getBy(rows.get(i).get(product).replace(" ", ""))) == true);
		}
		return (true);
	}

	public boolean checkProduct(String product) {

		System.out.println("checking for product:" + product.replace(" ", ""));

		assertTrue("checking for :" + product,
				isAvailable(driver, getBy(product.replace(" ", ""))) == true);

		return true;
	}

}