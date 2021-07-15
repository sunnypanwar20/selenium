package Selenium.Jenkins;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RegressionSuite {

	WebDriver driver;

	Logger log;

	@Test(priority = 1, groups = { "Regression", "Smoke" })
	void searchMyNameInGoogle() {
		log = Logger.getLogger("demotest1");
		PropertyConfigurator.configure("Log4j.properties");
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		search.sendKeys("sunny panwar publicis sapient linkedin");
		search.sendKeys(Keys.ENTER);

		List<WebElement> result = driver.findElements(By.xpath("//cite[@class='iUh30 Zu0yb qLRx3b tjvcx']"));
		for (WebElement i : result) {
//			System.out.println(i.getText());
			log.info(i.getText());
//			if(i.getText().contains("snypwr")) {
//				i.click();
//			}
		}

		System.out.println("****************************below starts info of people**********************");

		List<WebElement> info = driver.findElements(By.xpath("//div[@class='VwiC3b yXK7lf MUxGbd yDYNvb lyLwlc']"));
		for (WebElement i : info) {
//			System.out.println(i.getText());
			log.info(i.getText());
			System.out.println();
		}
	}

	@Test(priority = 2, groups = { "Regression", "Smoke","Sanity" })
	public static void methodNo2() {
		System.out.println("this is second method");
        System.out.println("sunny");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
