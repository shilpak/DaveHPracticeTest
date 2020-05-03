package PracticeExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumGridTest {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");	
		String url = "http://localhost:8090/wd/hub";
		driver = new RemoteWebDriver(new URL(url), capabilities);
	}

	@Test
	public void gridTest() {
		 driver.get("http://the-internet.herokuapp.com/");
		 String title = driver.getTitle();
		 System.out.println(title);
		assertThat(driver.getTitle(), is(equalTo("The Internet")));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}


