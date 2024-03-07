package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class newCars extends BasePage {

	public newCars(WebDriver driver) {
		super(driver);

	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[normalize-space()='New Cars']")
	public WebElement NewCars;

	@FindBy(xpath = "//li[@data-track-label='refine-fuel-tab']")
	public WebElement fuelFitler;

	@FindBy(xpath = "//div[@data-track-label='refine-fueltype-click']//a")
	public List<WebElement> fuelType;

	@FindBy(xpath = "//div[@class='clr-try fnt-12 pb-10 ht-spec of-hid']")
	public List<WebElement> carsResults;

	public void clickNewCars() {
		NewCars.click();
	}

	public void selectCarFilterType() {
		// fuelFitler.click();

		js.executeScript("arguments[0].click();", fuelFitler);
	}

	public List<WebElement> fuelTypes() {
		return fuelType;
	}

	public List<WebElement> filteredResult() {
		return carsResults;
	}

}
