package PracticeExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ABTestoptOut {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}

	@Test
	public void WithCookieAfterVisitingPage() {
		driver.get("http://the-internet.herokuapp.com/abtest");
		String headingText = driver.findElement(By.tagName("h3")).getText();
		System.out.println(headingText);
		assertThat(headingText, startsWith("A/B Test"));
		driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
		driver.navigate().refresh();
		headingText = driver.findElement(By.cssSelector("h3")).getText();
		System.out.println(headingText);
		assertThat(headingText, is("No A/B Test"));
	}

/*	@Test
	public void WithCookieBeforeVisitingPage() {
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
		driver.get("http://the-internet.herokuapp.com/abtest");
		assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("No A/B Test"
				));
	}*/
	
	/*@Test
	public void WithOptOutUrl() {
	driver.get("http://the-internet.herokuapp.com/abtest?optimizely_opt_out=true");
	driver.switchTo().alert().dismiss();
	assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("No A/B Test"
	));
	}
	*/

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
