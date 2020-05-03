package PracticeExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class HandleNestedFrame {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}

	@Test
	public void nestedFrames() throws Exception {
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		String rightframetext = driver.findElement(By.tagName("body")).getText();
		System.out.println(rightframetext);
		assertThat(rightframetext, is(equalTo("RIGHT")));
	}
}
