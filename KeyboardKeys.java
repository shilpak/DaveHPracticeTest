package PracticeExample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class KeyboardKeys {
	
	WebDriver driver;
	
	@Test
	public void uploadFile() throws Exception {
	driver.get("http://the-internet.herokuapp.com/key_presses");
	//https://github.com/SeleniumHQ/selenium/wiki/Advanced-User-Interactions
	Actions builder = new Actions(driver);
	builder.sendKeys(Keys.TAB).build().perform();
	assertThat(driver.findElement(By.id("result")).getText(), is("You entered: TAB"));
	}
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}

}
