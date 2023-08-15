package eromsTe.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AppAlertDialogsDemo extends BaseTest{

	@Test
	public void FreeStyleDemoTest() throws MalformedURLException, InterruptedException
	{
	
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		WebElement defaultChoice = driver.findElement(By.xpath("(//android.widget.CheckedTextView)[1]"));
		Assert.assertEquals(defaultChoice.getText(), "Map");
		Assert.assertEquals(defaultChoice.getAttribute("checked"), "true");
		WebElement newChoice = driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]"));
		newChoice.click();
		Assert.assertEquals(defaultChoice.getAttribute("checked"), "false");
		Assert.assertEquals(newChoice.getText(), "Satellite");
		Assert.assertEquals(newChoice.getAttribute("checked"), "true");
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(3000);
		
		
		
		
	}
}
