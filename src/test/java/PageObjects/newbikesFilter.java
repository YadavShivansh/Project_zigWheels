package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newbikesFilter extends BasePage {

	public newbikesFilter(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement NewBikes;

	@FindBy(xpath = "//li[normalize-space()='Displacement']")
	public WebElement Filter;

	@FindBy(xpath = "/html/body/div[8]/div/div/div/div[1]/div[1]/div[4]/div[2]/div/div/div/div/div/a")
	public List<WebElement> range;

	@FindBy(xpath = "//strong[@class='lnk-hvr block of-hid h-height']")
	public List<WebElement> bikeName;

	@FindBy(xpath = "//div[@class='clr-try fnt-14 pb-10 h-height of-hid']")
	public List<WebElement> bikesDisplacement;

	@FindBy(xpath = "//span[normalize-space()='Price Range']")
	public WebElement scrollNewBikes;

	public void clickNewBikes() {
		NewBikes.click();

	}

	public void selectFilter() throws InterruptedException {

		js.executeScript("arguments[0].click();", Filter);
	}

	public List<WebElement> displacementRanges()

	{
		return range;
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollNewBikes);

	}

	public void displaysResults() {

		for (int i = 0; i < bikeName.size(); i++) {

			System.out.println(bikeName.get(i).getText() + " | " + bikesDisplacement.get(i).getText());
		}

	}

}
