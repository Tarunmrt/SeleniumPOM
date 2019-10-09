package com.qa.hubspaot.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.utils.FileUtil;
import com.qa.hotspot.commons.Constants;

public class BasePage {

	//WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver initialize_driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Tarun\\selenium\\chromedriver.exe");
			tldriver.set(new ChromeDriver());
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Tarun\\selenium\\geckodriver.exe");
			tldriver.set(new FirefoxDriver());
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Tarun\\selenium\\IEDriverServer.exe");
			tldriver.set(new InternetExplorerDriver());
		} else {
			System.out.println("Browser is not defined in Config file");
		}

		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		if (prop.getProperty("fullscreenmode").equals("yes")) {
			getDriver().manage().window().maximize();
		}
		return getDriver();

	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties initialize_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\tarun.kumar\\eclipse-workspace\\SeptPomSeries\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenShot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			System.out.println("Caputure Failed " + e.getMessage());
		}
		return path;
	}

}
