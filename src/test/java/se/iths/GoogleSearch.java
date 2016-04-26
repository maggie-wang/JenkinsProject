package se.iths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import se.iths.Pages.GooglePage;

public class GoogleSearch {

	private WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	@Category(SystemTest.class)
	public void testSearchCheese() {
		GooglePage gp = new GooglePage(driver);
		gp.search("Cheese!");
		gp.verifyResult("cheese!");
	}

	@Test
	public void testSearchJohan() {
		GooglePage gp = new GooglePage(driver);
		gp.search("Johan");
		gp.verifyResult("johan");
	}
}
