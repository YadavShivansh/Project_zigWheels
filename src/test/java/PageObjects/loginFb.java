package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginFb extends BasePage {

	public loginFb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// @FindBy(xpath = "(//div[@class='newgf-login']/div[1])[1]")
	@FindBy(xpath = "(//span[contains(text(),'Facebook')])")
	public WebElement Fb;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement FbEmail;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement FbPass;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement logIn;

	@FindBy(xpath = "//div[@class='fsl fwb fcb']")
	public WebElement FbError;

	public void selectfb() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Fb));
		js.executeScript("arguments[0].click();", Fb);
		System.out.println(Fb.getText());

	}

	public WebElement enterCred() {
		return FbEmail;
	}

	public WebElement enterfbPass() {
		return FbPass;
	}

	public void fbLogIn() {
		logIn.click();
	}

	public void Fberror() {
		System.out.println(FbError.getText());
	}
}
