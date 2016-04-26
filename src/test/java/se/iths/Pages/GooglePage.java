package se.iths.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	WebDriver driver;

	public GooglePage(WebDriver d) {
		driver = d;
	}

	public void search(String search) {
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(search);
		element.submit();

	}

	public void verifyResult(String search) {
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith(search);
			}
		});
		System.out.println("Page title is: " + driver.getTitle());
	}

}
