package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.excelUtils;

public class newBikes extends BasePage {

	public newBikes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Actions hover = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String xlpath = System.getProperty("user.dir") + "\\src\\test\\resources\\Output.xlsx";

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(xpath = "//a[normalize-space()='New Bikes']")
	public WebElement newBikesHover;

	@FindBy(xpath = "//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/ul")
	public WebElement newBikesdrpDown;

	@FindBy(xpath = "//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/ul/li")
	public static List<WebElement> bikedrpList;

	@FindBy(xpath = "//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/ul/li[5]/span")
	public WebElement drpUpcomingBikes;

	@FindBy(xpath = "//select[@id='makeId']")
	public WebElement manufacturerdrpDown;

	@FindBy(xpath = "//span[@data-track-label='view-more-models-button']")
	public WebElement scrollview;

	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	public WebElement viewMore;

	@FindBy(xpath = "//a[@data-track-label='model-name']")
	public List<WebElement> bikenames;

	// Storing list of web elements for bike price
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[1]")
	public List<WebElement> bikeprices;

	// Storing list of web elements for bike launch date
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[2]")
	public List<WebElement> bikelaunchdate;

	public void hoveract() {

		hover.moveToElement(newBikesHover).perform();
	}

	public void chckNewbikesdrpDown() {

		Assert.assertTrue(newBikesdrpDown.isDisplayed());

	}

	public List<WebElement> bikecategory() {
		return bikedrpList;
	}

	public void click_Manufactrer() {
		manufacturerdrpDown.click();
	}

	public void scroll_view() {

		js.executeScript("arguments[0].scrollIntoView();", scrollview);

		js.executeScript("arguments[0].click();", viewMore);
	}

	public void extractBikeDetails() throws IOException

	{

		int k = 0;
		for (int i = 0; i < bikenames.size(); i++) {
			String price = bikeprices.get(i).getText();

			String middleNumber = price.split(" ")[1];

			// ["Rs." , "3.3" , "lakh"]
			if (middleNumber.contains(".")) {
				Double d = Double.parseDouble(middleNumber);
				if (d <= 4.0) {

					excelUtils.setCellData(xlpath, "BikeDetails", k + 1, 0, bikenames.get(i).getText());
					excelUtils.setCellData(xlpath, "BikeDetails", k + 1, 1, bikeprices.get(i).getText());
					excelUtils.setCellData(xlpath, "BikeDetails", k + 1, 2, bikelaunchdate.get(i).getText());
					k++;
				}

			} else if (middleNumber.contains(",")) {
				middleNumber = middleNumber.replaceAll(",", "");
				int p = Integer.parseInt(middleNumber);
				if (p <= 400000) {
					excelUtils.setCellData(xlpath, "BikeDetails", k + 1, 0, bikenames.get(i).getText());
					excelUtils.setCellData(xlpath, "BikeDetails", k + 1, 1, bikeprices.get(i).getText());
					excelUtils.setCellData(xlpath, "BikeDetails", k + 1, 2, bikelaunchdate.get(i).getText());
					k++;
				}
			}
		}
	}

}
