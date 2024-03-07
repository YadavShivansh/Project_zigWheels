package StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.utils.HelperClass;

import PageObjects.fundamentalElement;
import PageObjects.login;
import PageObjects.loginGoogle;
import PageObjects.newBikes;
import PageObjects.usedCars;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDef1 {

	public static WebDriver driver;
	static Properties Pr;

	fundamentalElement fE;
	newBikes bike;
	usedCars car;
	login g;
	loginGoogle ggl;

	@Given("Homepage of ZigWheels")
	public void homepage_of_zig_wheels() {

		driver = HelperClass.getDriver();
		fE = new fundamentalElement(driver);
		bike = new newBikes(driver);
		car = new usedCars(driver);
		g = new login(driver);
		ggl = new loginGoogle(driver);
	}

	@Given("User is nevigated back to ZigWheels homepage")
	public void user_is_nevigated_back_to_zigWheels_homepage() {

		driver = HelperClass.getDriver();
		driver.navigate().to("https://www.zigwheels.com/");
		car = new usedCars(driver);

	}

	@Then("ZigWheels logo should be displayed")
	public void zig_wheels_logo_should_be_displayed() {

		fE.cheakLogo();

	}

	@Then("Searchbox should be displayed")
	public void searchbox_should_be_displayed() {

		fE.cheakSearchbox();
	}

	@Then("Login button should be displayed")
	public void login_button_should_be_displayed() {

		fE.cheakloginbtn();
	}

	@Then("scrollbar is present")
	public void scrollbar_is_present() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		long documentHeight = (long) js.executeScript("return document.documentElement.scrollHeight;");
		long viewportHeight = (long) js.executeScript("return window.innerHeight;");

		// Check if the document height exceeds the viewport height
		boolean isScrollBarPresent = documentHeight > viewportHeight;

		Assert.assertTrue(isScrollBarPresent, "Scroll bar is not present on the webpage.");

	}

	@When("User hover on New Bikes Dropdown")
	public void user_hover_on_new_bikes_dropdown() {

		bike.hoveract();
	}

	@Then("Dropdown options Should be displayed")
	public void dropdown_options_should_be_displayed() {

		bike.chckNewbikesdrpDown();

	}

	@When("user clicks on the {string}")
	public void user_clicks_on_the(String string) {

		try {
			for (WebElement ele : bike.bikecategory()) {

				if (ele.getText().equalsIgnoreCase(string)) {
					ele.click();
				}

			}

		} catch (StaleElementReferenceException e) {

		}
	}

	@Then("user is nevigated to the upcoming bikes page")
	public void user_is_nevigated_to_the_upcoming_bikes_page() throws IOException {

		Pr = HelperClass.getProperties();
		String expectedTitle = Pr.getProperty("Upcoming_Bikes_PageTitile");
		String actualTitle = driver.getTitle();

		Assert.assertTrue(actualTitle.contains(expectedTitle));

	}

	@When("user  mapulated to the manufacturer dropdown")
	public void user_mapulated_to_the_manufacturer_dropdown() {
		bike.click_Manufactrer();
	}

	@Then("user select {string}")
	public void user_select(String string) {

		Select drpOption = new Select(bike.manufacturerdrpDown);

		drpOption.selectByVisibleText(string);
	}

	@When("User scroll and click View More")
	public void user_scroll_and_click_view_more() {

		bike.scroll_view();

	}

	@Then("List of the bikes is displayed")
	public void list_of_the_bikes_is_displayed() throws IOException {

		bike.extractBikeDetails();
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {

		g.clickLogin();

	}

	@Then("select google as login")
	public void select_google_as_login() {

		g.selectGoogle();
	}

	@When("user nevigates to login window")
	public void user_nevigates_to_login_window() {

		String originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) { // to handle windows
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Then("User enter {string} email")
	public void user_enter_email(String string) {

		WebElement mail = g.enterMail();
		mail.sendKeys(string);
	}

	@Then("click the Next button")
	public void click_the_next_button() {

		g.clickNext();

	}

	@Then("display the Error message")
	public void display_the_error_message() {
		g.captureError();
	}

	@When("User hover on Used Cars")
	public void user_hover_on_used_cars() throws InterruptedException {

		car.hoverUsedCar();
	}

	@When("User select {string} in Location options")
	public void user_select_in_location_options(String string) {

		try {
			for (WebElement ele : car.selectLoc()) {

				if (ele.getText().equalsIgnoreCase(string)) {
					ele.click();
				}

			}
		} catch (StaleElementReferenceException e) {

		}

	}

	@Then("User is nevigated to the Used Cars page")
	public void User_is_nevigated_to_the_Used_Cars_page() throws IOException {

		Pr = HelperClass.getProperties();
		String expectedTitle = Pr.getProperty("Used_Cars_PageTitile");
		String actualTitle = driver.getTitle();

		Assert.assertTrue(actualTitle.contains(expectedTitle));

	}

	@When("User scroll till list of popular Brands")
	public void user_scroll_till_list_of_popular_brands() {

		car.scroll_to_popularBrands();
	}

	@Then("User scoll popular model list")
	public void user_scoll_popular_model_list() {

		car.scroll_popularBrands_List();
	}

	@Then("User selects brands and displays cars list")
	public void user_selects_brands_and_displays_cars_list() throws InterruptedException, IOException {

		car.extractCarDetails();
	}

}
