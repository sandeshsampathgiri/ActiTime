package Tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
		driver.get("https://www.facebook.com");
	}

	@Test
	public void accessTestSite() {

		System.out.println("Driver class is " + driver.getClass());
		System.out.println("Current URL is " + driver.getCurrentUrl());
		// System.out.println("Page Source: " + driver.getPageSource());

	}

	@Test(enabled = false)
	public void verifyPageTitle() {
		try {

			// Thread.sleep(5000);
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle, "actiTIME - Login");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = false)
	public void getLinkCount() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> LinkText = driver.findElements(By.tagName("a"));
		int linkCount = LinkText.size();
		System.out.println("No. of links in this page is " + linkCount);
	}

	@Test(enabled = false)
	public void getAllLinksText() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.findElement(By.xpath("//div[@class='_3Njdz7']/button")).click();
		List<WebElement> LinkText = driver.findElements(By.tagName("a"));

		for (int i = 0; i < LinkText.size(); i++) {

			if (LinkText.get(i).getText().length() != 0) {
				System.out.println(LinkText.get(i).getText());
			}

		}

	}

	@Test
	public void selectDateFromDropdown() {
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		Select dayValue = new Select(day);
		dayValue.selectByVisibleText("4");

		Select monthValue = new Select(month);
		monthValue.selectByVisibleText("May");

		Select yearValue = new Select(year);
		yearValue.selectByVisibleText("1985");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
