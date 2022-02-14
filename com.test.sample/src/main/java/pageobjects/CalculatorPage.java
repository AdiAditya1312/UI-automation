package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalculatorPage {
	public WebDriverWait wait;
	WebDriver driver;

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how = How.XPATH, using = "//select[@title='Number of dependants']")
	  private static WebElement selectDependants;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Your annual income (before tax)']/parent::"
			+ "div/descendant::div/descendant::input")
	  private static WebElement annualIncomeInputfield;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Your annual other income (optional)']/parent::"
			+ "div/descendant::div/descendant::input")
	  private static WebElement annualIncomeOtherInputfield;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Monthly living expenses ']/parent::"
			+ "div/descendant::div/descendant::input")
	  private static WebElement monthlyLivingExpensesInputfield;
	
	@FindBy(how = How.ID, using = "homeloans")
	  private static WebElement currentHomeLoanRepaymentsInputField;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Other loan monthly repayments']/parent::"
			+ "div/descendant::div/descendant::input")
	  private static WebElement otherLoanMonthlyRepaymentsInputField;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Other monthly commitments']/parent::"
			+ "div/descendant::div/descendant::input")
	  private static WebElement otherMonthlyCommitmentsInputField;
	
	@FindBy(how = How.ID, using = "credit")
	  private static WebElement creditCardLimitInputField;
	
	@FindBy(how = How.ID, using = "btnBorrowCalculater")
	  private static WebElement btnBorrowCalculator;
	
	@FindBy(how = How.ID, using = "borrowResultTextAmount")
	  private static WebElement estimatedAmount;
	
	@FindBy(how = How.XPATH, using = "//div[@class='result__restart']/descendant::button")
	  private static WebElement startOverButton;
	

	/**
	 *Function to enter details in detail section.
	 */

	public void enterTheInformationInDetailsSection(String applicationType, String dependants, String property) {
		WebElement applicationtype = driver.findElement(By.xpath("//label[@for='application_type_single' and "
				+ "contains(text(),'"+applicationType+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(applicationtype));
		applicationtype.click();
		Select select = new Select(selectDependants);
		select.selectByVisibleText(dependants);
		WebElement propertyToBuy = driver.findElement(By.xpath("//label[@for='borrow_type_home' and "
				+ "contains(text(),'"+property+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(propertyToBuy));
		propertyToBuy.click();

	}
	
	/**
	 *Function to enter details in earnings section.
	 */

	public void enterTheInformationInEarningsSection(String annualIncome, String otherIncome) {
		wait.until(ExpectedConditions.visibilityOf(annualIncomeInputfield));
		annualIncomeInputfield.sendKeys(annualIncome);
		annualIncomeOtherInputfield.sendKeys(otherIncome);
		
	}
	
	/**
	 * Function to enter the information in your expenses section.
	 */

	public void enterTheInformationInExpenseSection(String monthly, String repayments, String otherLoan,
			String commitments, String creditCard) {
		wait.until(ExpectedConditions.visibilityOf(monthlyLivingExpensesInputfield));
		monthlyLivingExpensesInputfield.sendKeys(monthly);
		currentHomeLoanRepaymentsInputField.sendKeys(repayments);
		otherLoanMonthlyRepaymentsInputField.sendKeys(otherLoan);
		otherMonthlyCommitmentsInputField.sendKeys(commitments);
		creditCardLimitInputField.sendKeys(creditCard);
		
	}
	
	/**
	 *Function to validate the correct estimation is displayed or not.
	 */

	public void validateTheCorrectEstimationIsCalculatedOrNot(String estimation) {
		wait.until(ExpectedConditions.elementToBeClickable(btnBorrowCalculator));
		btnBorrowCalculator.click();
		WebElement estimatedAmount = driver.findElement(By.xpath("//span[@id='borrowResultTextAmount' and text()='"+estimation+"']"));
		wait.until(ExpectedConditions.visibilityOf(estimatedAmount));
	    String getEstimatedAmount = estimatedAmount.getText();
	    Assert.assertEquals(estimation, getEstimatedAmount);
	}
	
	/**
	 *Function to validate the start over button.
	 */

	public void validateTheStartOverForm() {
		wait.until(ExpectedConditions.elementToBeClickable(startOverButton));
		startOverButton.click();
		String getEstimatedAmount = estimatedAmount.getText();
		Assert.assertEquals("$0", getEstimatedAmount);
		boolean validateAnnualIncomeField = annualIncomeInputfield.getAttribute("value").equalsIgnoreCase("0");
		Assert.assertTrue(validateAnnualIncomeField);
		boolean validateOtherAnnualIncomeField = annualIncomeOtherInputfield.getAttribute("value").equalsIgnoreCase("0");
		Assert.assertTrue(validateOtherAnnualIncomeField);
		boolean validateMonthlyLivingExpensesField = monthlyLivingExpensesInputfield.getAttribute("value").equalsIgnoreCase("0");
		Assert.assertTrue(validateMonthlyLivingExpensesField);
		boolean validateCurrentHomeLoanRepaymentsField = currentHomeLoanRepaymentsInputField.getAttribute("value").equalsIgnoreCase("0");
		Assert.assertTrue(validateCurrentHomeLoanRepaymentsField);
		driver.close();
	}
}
