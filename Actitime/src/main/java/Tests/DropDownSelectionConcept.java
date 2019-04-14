package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownSelectionConcept {

	public static WebDriver driver;
	public static ChromeOptions options;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("start-maximized");
		options.setAcceptInsecureCerts(true);

		driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com");

	}

	@Test
	public static void testDropdownSelection() {

		By date = By.id("day");

		selectDateOfBirth(date, "10");

	}

	public static WebElement getElement(By selector, WebDriver driver) {
		WebElement ele = driver.findElement(selector);
		return ele;
	}

	public static void selectDateOfBirth(By day, String selectDate) {
		WebElement ele1 = getElement(day, driver);
		Select select1 = new Select(ele1);
		select1.selectByValue(selectDate);

	}

	@AfterMethod
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.close();
		
	}

}
