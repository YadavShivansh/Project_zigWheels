package StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;

import com.utils.HelperClass;

import PageObjects.fundamentalElement;
import PageObjects.loginFb;
import PageObjects.loginGoogle;
import PageObjects.newCars;
import PageObjects.newbikesFilter;
import PageObjects.usedCars;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdef2 {

	public static WebDriver driver;
	static Properties Pr;

	usedCars ucs;
	newbikesFilter bikefilter;
	newCars newC;
	loginGoogle ggl;
	loginFb fb;
	fundamentalElement Bs;

	@Given("Homepage of Zigwheels")
	public void homepage_of_zig_wheels() {

		driver = HelperClass.getDriver();

		ucs = new usedCars(driver);
		bikefilter = new newbikesFilter(driver);
		newC = new newCars(driver);
		ggl = new loginGoogle(driver);
		fb = new loginFb(driver);
		Bs = new fundamentalElement(driver);
	}

	@Given("User is nevigated back to Zigwheels homepage")
	public void user_is_nevigated_back_to_zigwheels_homepage() {

		driver = HelperClass.getDriver();
		driver.navigate().to("https://www.zigwheels.com/");
		Bs = new fundamentalElement(driver);
		ucs = new usedCars(driver);
		bikefilter = new newbikesFilter(driver);
		newC = new newCars(driver);

	}

	@When("user Hover on Used Cars")
	public void user_hover_on_used_cars() throws InterruptedException {

		ucs.hoverUsedCar();
	}

	@Then("Dropdown is displayed")
	public void dropdown_is_displayed() {
		ucs.cheakdrpDown();
	}

	@When("User Clicks on the search Bar")
	public void user_clicks_on_the_search_bar() {
		ucs.clickSearch();
	}

	@Then("Search Options is displayed")
	public void search_options_is_displayed() {
		ucs.searchOptions();
	}

	@When("The user clicks on Login button")
	public void the_user_clicks_on_login_button() {

		ggl.clicklogin();
	}

	@Then("The user select google as login")
	public void the_user_select_google_as_login() throws InterruptedException {

		ggl.selectgoogle();

	}

	@When("The user nevigates to login window")
	public void the_user_nevigates_to_login_window() {
		String originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) { // to handle windows
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("User clicks the Next button")
	public void user_clicks_the_next_button() {
		try {
			ggl.clickNext();
		} catch (Exception e) {

		}
	}

	@When("User enters {string} email")
	public void user_enters_email(String string) {

		ggl = new loginGoogle(driver);

		WebElement mail = ggl.enterMail();

		mail.sendKeys(string);
	}

	@When("User enter the invalid {string}")
	public void user_enter_the_invalid(String string) {

		ggl = new loginGoogle(driver);
		try {
			ggl.enterPass().sendKeys(string);
		} catch (Exception e) {
			System.out.println("Use Different Browser");
		}
	}

	@Then("display the Password error message")
	public void display_the_password_error_message() {
		try {
			ggl = new loginGoogle(driver);
			ggl.printError();
		} catch (Exception e) {

		}
	}

	@Then("select Facebook as login option")
	public void select_facebook_as_login_option() {

		fb.selectfb();

	}

	@When("user Enters Invalid mail\\/ph {string}")
	public void user_enters_invalid_mail_ph(String fbcread) {

		fb.enterCred().sendKeys(fbcread);
	}

	@When("user Enters Invalid Password {string}")
	public void user_enters_invalid_password(String string) {

		fb.enterfbPass().sendKeys(string);
	}

	@Then("clicks Login button")
	public void clicks_login_button() {

		fb.fbLogIn();
	}

	@Then("displays the facebook message")
	public void displays_the_facebook_message() {

		fb.Fberror();
	}

	@When("User hover on More in Header")
	public void user_hover_on_more_in_header() {

		Bs.hoverMore();
	}

	@When("Select Sell Car to Cardekho Gaadi Store")
	public void select_sell_car_to_cardekho_gaadi_store() {

		Bs.clickSellCar();
	}

	@Then("User is nevigated to the Car dekho home page")
	public void user_is_nevigated_to_the_car_dekho_home_page() throws IOException {

		String originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		Pr = HelperClass.getProperties();
		String expectedTitle = Pr.getProperty("CarDekh_Title");

		String actualTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@When("the User clicks on New Bikes")
	public void the_user_clicks_on_new_bikes() {

		bikefilter.clickNewBikes();
	}

	@When("the user clicks displacement filter")
	public void the_user_clicks_displacement_filter() throws InterruptedException {

		Thread.sleep(2000);
		bikefilter.selectFilter();
	}

	@Then("the user selects bike a displacement range {string}")
	public void the_user_selects_bike_a_displacement_range(String range) {

		List<WebElement> ele = bikefilter.displacementRanges();

		System.out.println(ele.size());

		for (int i = 0; i < ele.size(); i++) {

			if (ele.get(i).getText().equals(range)) {

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", ele.get(i));

				break;
			}

		}

	}

	@Then("Displays Bike name and Displacement")
	public void displays_bike_name_and_displacement() {

		bikefilter.scroll();
		bikefilter.displaysResults();

	}

	@When("The User clicks on New Cars")
	public void the_user_clicks_on_new_cars() {

		newC.clickNewCars();
	}

	@When("The User select Fuel Type filter")
	public void the_user_select_fuel_type_filter() throws InterruptedException {

		Thread.sleep(2000);
		newC.selectCarFilterType();
	}

	@Then("The User selcet Fuel Type {string}")
	public void the_user_selcet_fuel_type(String fuel) {
		try {
			for (WebElement ele : newC.fuelTypes()) {
				if (ele.getText().equalsIgnoreCase(fuel))
					ele.click();
			}
		} catch (StaleElementReferenceException e) {

		}
	}

	@Then("Validate the Displayed result with {string}")
	public void validate_the_displayed_result_with(String fuel) {

		List<WebElement> re = newC.filteredResult();
		String Expected = fuel;

		for (int i = 0; i < 5; i++) {

			String Actual = re.get(i).getText();

			Assert.assertEquals(Actual.contains(Expected), true);

		}

	}

}
