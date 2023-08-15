package eromsTe.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		//code to start server
				service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\eroms\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				
				//service.start();
				
				//uiautomator2 set up
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Eroms Pixel 6");
				options.setChromedriverExecutable("C:\\Users\\eroms\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
				options.setCapability("browserName", "Chrome");
				
				//AndroidDriver
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	@AfterClass
	public void tearDown() {
	//quit driver & stop server 
		driver.quit();
		service.stop();
	}
}
