package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public static WebDriver driver;

	// method 1 --> opens browser
	public static void setUp(String browserName) {
		if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		//maximize the webpage
		driver.manage().window().maximize();
		// Waits
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// method2 --> closes the browser
	public static void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
