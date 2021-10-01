package pages.actions;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.SeleniumDriver;

/**
 * @author karthik kaduburi
 *
 */
public class ANZ_HomePage {

	private static By single = By.xpath("//h3[text()='Your details']/following-sibling::div/ul/li/label[@for='application_type_single']");
	private static By noOfDep = By.xpath("//label[text()='Number of dependants']/following-sibling::div/select");
	private static By income = By.xpath("//input[@aria-describedby='q2q1i1 q2q1i2']");
	private static By otherIncome = By.xpath("//input[@aria-describedby='q2q2i1 q2q2i2']");
	private static By liveExp = By.xpath("//input[@id='expenses']");
	private static By homeLoanPay = By.xpath("//input[@id='homeloans']");
	private static By otherLoanPay = By.xpath("//input[@id='otherloans']");
	private static By otherCommit = By.xpath("//input[@aria-describedby='q3q4i1 q3q4i2']");
	private static By credLimit = By.xpath("//input[@aria-describedby='q3q5i1']");
	private static By workOutEstimate = By.xpath("//button[@id='btnBorrowCalculater']");
	private static By estimateResult = By.xpath("//span[@class='borrow__result__text__amount']");
	private static By startOver = By.xpath("//span[@class='borrow__result__text__amount']/ancestor::div[@class='box--left ']/following-sibling::div/button");
	private static By estimateMessage = By.xpath("//span[@class='borrow__error__text']");
	private static By xpath = null;

	JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
	String actual = null;
	String expected = null;
	String key, value;

	/**
	 * @param signIn Clicks On Button/link
	 */
	public void clickOnElement(String link) {
		if (link.equalsIgnoreCase("workOut")) {
			SeleniumDriver.getDriver().findElement(workOutEstimate).click();
		} else if (link.equalsIgnoreCase("startOver")) {
			SeleniumDriver.getDriver().findElement(startOver).click();
		}
	}

	/**
	 * @param link move to element click on the button
	 */
	public void moveToElement(String link) {

		js.executeScript("arguments[0].scrollIntoView(true);",
				SeleniumDriver.getDriver().findElement(By.xpath("//*[@class='product-image-container']")));
		Actions action = new Actions(SeleniumDriver.getDriver());
		action.moveToElement(SeleniumDriver.getDriver().findElement(By.xpath("//*[@class='product-image-container']")))
				.perform();
	}

	/**
	 * @param map Enter the Personal Info Details
	 */
	public void enterDetails(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map.containsKey("appType")) {
			SeleniumDriver.getDriver().findElement(single).sendKeys(map.get("appType"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("income")) {
			SeleniumDriver.getDriver().findElement(income).sendKeys(map.get("income"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("otherIncome")) {
			SeleniumDriver.getDriver().findElement(otherIncome).sendKeys(map.get("otherIncome"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("liveExp")) {
			SeleniumDriver.getDriver().findElement(liveExp).sendKeys(map.get("liveExp"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("homeLoanPay")) {
			SeleniumDriver.getDriver().findElement(homeLoanPay).sendKeys(map.get("homeLoanPay"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("otherLoanPay")) {
			SeleniumDriver.getDriver().findElement(otherLoanPay).sendKeys(map.get("otherLoanPay"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("otherCommit")) {
			SeleniumDriver.getDriver().findElement(otherCommit).sendKeys(map.get("otherCommit"));
			SeleniumDriver.waitForSeconds(1);
		}
		if (map.containsKey("credLimit")) {
			SeleniumDriver.getDriver().findElement(credLimit).sendKeys(map.get("credLimit"));
			SeleniumDriver.waitForSeconds(1);
		}

	}

	/**
	 * @param map Validate details on a page
	 */
	public void validateDetails(Map<String, String> map) {
		// TODO Auto-generated method stub
		if (map.containsKey("estimate")) {
			expected = "$" + map.get("estimate");
			try {
				actual = SeleniumDriver.getDriver().findElement(estimateResult).getText();
				Assert.assertEquals(expected, actual);

			} catch (AssertionError e) {
				Assert.fail("\nESTIMATE DETAILS DISPLAYED ARE NOT VALID \n" + "Expected Estimate : " + expected
						+ "\nActual Estimate : " + actual + "\n");
			}
		} else if (map.containsKey("message")) {
			expected = map.get("message");
			try {
				actual = SeleniumDriver.getDriver().findElement(estimateMessage).getText();
				Assert.assertEquals(expected, actual);

			} catch (AssertionError e) {
				Assert.fail("\nESTIMATE MESSAGE DISPLAYED IS NOT VALID \n" + "Expected Message : " + expected
						+ "\nActual Message : " + actual + "\n");
			}
		} else {
			for (Entry<String, String> entry : map.entrySet()) {
				key = entry.getKey();
				value = entry.getValue();
				expected = "$" + map.get(key);

				try {
					actual = "$" + SeleniumDriver.getDriver().findElement(getXpath(key)).getAttribute("value");
					Assert.assertEquals(expected, actual);

				} catch (AssertionError e) {
					Assert.fail("\nFORM FIELDS ARE NOT CLEARED \n" + "Expected FormField value : " + expected
							+ "\nActual FormField value : " + actual + "\n");
				}
			}

		}

	}

	/**
	 * @param fieldName
	 * @return provides xpath based on fieldName
	 */
	public static By getXpath(String fieldName) {
		if (fieldName.equalsIgnoreCase("income")) {
			xpath = income;
		}
		if (fieldName.equalsIgnoreCase("otherIncome")) {
			xpath = otherIncome;
		}
		if (fieldName.equalsIgnoreCase("liveExp")) {
			xpath = liveExp;
		}
		if (fieldName.equalsIgnoreCase("homeLoanPay")) {
			xpath = homeLoanPay;
		}
		if (fieldName.equalsIgnoreCase("otherLoanPay")) {
			xpath = otherLoanPay;
		}
		if (fieldName.equalsIgnoreCase("otherCommit")) {
			xpath = otherCommit;
		}
		if (fieldName.equalsIgnoreCase("credLimit")) {
			xpath = credLimit;
		}

		return xpath;
	}

}
