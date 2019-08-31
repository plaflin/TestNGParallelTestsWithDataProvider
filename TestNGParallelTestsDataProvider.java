package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParallelTestsDataProvider {
	
	@BeforeClass
	void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/patri/Downloads/chromedriver.exe");
	}
	
	@DataProvider(name = "browsers", parallel=true)
	Object[][]testBrowsers() {
		return new Object[][] {
			{"Selenium WebDriver"},
			{"TestNG"}
		};
	}
	
	@Test(dataProvider="browsers")
	void searchTest(String searchText) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(searchText);
		element.submit();
		
		Assert.assertTrue(driver.getTitle().startsWith(searchText));
	}
}
