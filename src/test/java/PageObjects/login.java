package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login extends BasePage {

	public login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//*[@id='forum_login_wrap_lg']")
	public WebElement loginButton;

	@FindBy(xpath = "//span[contains(text(),'Google')]")
	public WebElement selectGoogle;

	@FindBy(xpath = "//input[@id='identifierId']")
	public WebElement enteremail;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nxtButton;

	@FindBy(xpath = "//div[@aria-live='assertive']/div")
	public WebElement mailError;

	public void clickLogin() {

		loginButton.click();
	}

	public void selectGoogle() {

		wait.until(ExpectedConditions.elementToBeClickable(selectGoogle));
		js.executeScript("arguments[0].click();", selectGoogle);
	}

	public WebElement enterMail() {
		return enteremail;
	}

	public void clickNext() {
		nxtButton.click();
	}

	public void captureError() {

		wait.until(ExpectedConditions.visibilityOf(mailError));
		System.out.println(mailError.getText());
	}

}
