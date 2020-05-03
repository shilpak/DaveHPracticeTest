package PracticeExample;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}
	
	@Test
	public void workWithBasicAuthTest() {
	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	String pageMessage = driver.findElement(By.cssSelector("p")).getText();
	System.out.println(pageMessage);
	assertThat(pageMessage, containsString("Congratulations!"));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
