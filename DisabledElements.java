package PracticeExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DisabledElements {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}
	
	//first we need to check that nothing is enabled
	@Test
	public void test() {
	driver.get("http://the-internet.herokuapp.com/dropdown");
	Select dropdown = new Select(driver.findElement(By.id("dropdown")));
	assertThat(dropdown.getOptions().get(0).isEnabled(), is(false));
	}
	
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

}
