package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DealingWithTags {

	static WebDriver driver;

	@Test
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "//exes/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		getEleCount("img");
		driver.close();
	}

	@Test(enabled=false)
	public static void findElementCount() {
		List<WebElement> tagDetails = driver.findElements(By.tagName("a"));
		//System.out.println("No. of anchor tags are: " + tagDetails.size());

		System.out.println("List of anchor links are:");
		for (int i = 0; i < tagDetails.size(); i++) {

			if (tagDetails.get(i).getText().length() != 0) {

				System.out.println(tagDetails.get(i).getText());
			}
		}

	}
	
	
	public static void getEleCount(String tagName)
	{
		List<WebElement> tagData = driver.findElements(By.tagName(tagName));
		System.out.println("No. of elements present in the webpage are:"+tagData.size());
		
		
	}
	/*
	 * @AfterMethod public static void tearDown() {
	 * 
	 * }
	 */
}
