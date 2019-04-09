package Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

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
	}

	@Test
	public void accessTestSite() {

		driver.get("https://demo.actitime.com");
		System.out.println("Driver class is " + driver.getClass());
		System.out.println("Current URL is " + driver.getCurrentUrl());
	//	System.out.println("Page Source: " + driver.getPageSource());

	}

	@Test(enabled=false)
	public void verifyPageTitle() {
		try {
			driver.get("https://demo.actitime.com");
			// Thread.sleep(5000);
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle, "actiTIME - Login");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
