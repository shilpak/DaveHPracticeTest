package PracticeExample;

import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}

	@Test
	public void checkboxCountTest() {
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(
				"input[type='checkbox']"));

		System.out.println("With .attribute('checked')");
		for (WebElement checkbox : checkboxes) {
			System.out.println(String.valueOf(checkbox.getAttribute("checked")));
		}

		System.out.println("\nWith .selected?");
		for (WebElement checkbox : checkboxes) {
			System.out.println(checkbox.isSelected());
		}
	}
	
	@Test
	public void checkboxOption1Test() throws Exception {
	driver.get("http://the-internet.herokuapp.com/checkboxes");
	WebElement checkbox = driver.findElement(By.cssSelector("forminput:nth-of-type(2)"));
	assertThat(checkbox.getAttribute("checked"), is(not("null")));
	assertThat(checkbox.getAttribute("checked"), is("true"));
	}
	
	@Test
	public void checkboxOption2Test() throws Exception {
	driver.get("http://the-internet.herokuapp.com/checkboxes");
	WebElement checkbox = driver.findElement(By.cssSelector("forminput:nth-of-type(2)"));
	assertThat(checkbox.isSelected(), is(true));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
