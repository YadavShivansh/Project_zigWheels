package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginGoogle extends BasePage {

	public loginGoogle(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	login lg;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//*[@id='forum_login_wrap_lg']")
	public WebElement loginButton;

	@FindBy(xpath = "//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public WebElement selectGoogle;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement enteremail;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nxtButton;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;

	@FindBy(xpath = "//div[@jsname='B34EJ']//span")
	public WebElement passError;

	public void clicklogin() {
		loginButton.click();
	}

	public void selectgoogle() {

		// selectGoogle.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectGoogle));
		js.executeScript("arguments[0].click();", selectGoogle);

	}

	public WebElement enterMail() {

		return enteremail;
	}

	public void clickNext() {
		nxtButton.click();
	}

	public WebElement enterPass() {

		return password;
	}

	public void printError() {

		System.out.println(passError.getText());
	}

}
