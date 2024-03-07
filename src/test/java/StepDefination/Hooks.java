package StepDefination;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utils.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	Properties p;

	// @BeforeAll
	@Before
	public void setup() throws IOException {
		driver = HelperClass.initialBrowser();
		p = HelperClass.getProperties();
		driver.manage().window().maximize();

		driver.get(p.getProperty("URL"));

	}

	// @AfterAll
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);

		driver.quit();

	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		// this is for cucumber junit report

		if (!scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());

		}

	}
}