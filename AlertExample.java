package PracticeExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {
	
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
	driver = new ChromeDriver();
	}
	
	@Test
	public void JavaScriptAlertTest() {
	driver.get("http://the-internet.herokuapp.com/javascript_alerts");
	driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();//to click ok
	//alert.dismiss();//to click cancel
	String text = driver.findElement(By.id("result")).getText();
	assertThat(text, is(equalTo("You clicked: Ok")));
	}
	
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

}
