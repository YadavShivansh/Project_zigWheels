package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fundamentalElement extends BasePage {

	public fundamentalElement(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//*[@id='Header']/div/div[1]/div[1]/a/img")
	public WebElement logo;

	@FindBy(xpath = "//input[@id='headerSearch']")
	public WebElement searchbox;

	@FindBy(xpath = "//div[@id='des_lIcon']")
	public WebElement btn;

	@FindBy(xpath = "//a[normalize-space()='More']")
	public WebElement more;

	@FindBy(xpath = "//span[normalize-space()='Sell Car to Cardekho Gaadi Store']")
	public WebElement sellCar;

	public void cheakLogo() {

		wait.until(ExpectedConditions.visibilityOf(logo));
		Assert.assertTrue(logo.isDisplayed());
	}

	public void cheakSearchbox() {

		Assert.assertTrue(searchbox.isDisplayed());
	}

	public void cheakloginbtn() {

		btn.isDisplayed();
	}

	public void hoverMore() {
		act.moveToElement(more).perform();
	}

	public void clickSellCar() {
		// sellCar.click();

		js.executeScript("arguments[0].click();", sellCar);
	}
}
