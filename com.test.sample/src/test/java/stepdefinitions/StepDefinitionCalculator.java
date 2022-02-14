package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataprovider.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CalculatorPage;

public class StepDefinitionCalculator {
	public static WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();

	@Given("^user access URL$")
	public void userAccessUrl() throws Throwable {
		String browserName = configFileReader.getBrowserName();
		// Launching Chrome browser
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configFileReader.getApplicationUrl());
			driver.manage().timeouts().pageLoadTimeout(configFileReader
					.getPageLoadTime(), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(configFileReader
					.getImplicitlyWait(), TimeUnit.SECONDS);
		}
	}

	/**
	 *Step definition to enter details in detail section.
	 */

	@When("^I enter the information in details section with given details(.+)dependants(.+)and(.+)property$")
	public void enterTheInformationInDetailsSection(String applicationType, String dependants, String property) throws Throwable {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.enterTheInformationInDetailsSection(applicationType, dependants, property);

	}
	
	/**
	 *Step definition to enter the information in your earnings section.
	 */

	@When("^I enter the information in your earnings section(.+)and(.+)otherincome$")
	public void enterTheInformationInEarningsSection(String annualIncome, String otherIncome) throws Throwable {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.enterTheInformationInEarningsSection(annualIncome, otherIncome);

	}
	
	/**
	 *Step definition to enter the information in your expenses section.
	 */

	@When("^I enter the information in your expenses section(.+)repayments(.+)otherloan(.+)commitments(.+)creditcard(.+)$")
	public void enterTheInformationInExpenseSection(String monthly, String repayments, String otherLoan, String commitments, String creditCard) throws Throwable {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.enterTheInformationInExpenseSection(monthly, repayments, otherLoan, commitments, creditCard);

	}
	
	/**
	 *Step definition to validate the correct estimation is displayed or not.
	 */

	@Then("^I should validate the correct estimation(.+) is calculated or not$")
	public void validateTheCorrectEstimationIsCalculatedOrNot(String estimation) throws Throwable {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.validateTheCorrectEstimationIsCalculatedOrNot(estimation);

	}
	
	/**
	 *Step definition to validate the start over button.
	 */

	@Then("^I should click on startOver it should clear the form$")
	public void validateTheStartOverForm() throws Throwable {
		CalculatorPage cp = new CalculatorPage(driver);
		cp.validateTheStartOverForm();

	}


}
