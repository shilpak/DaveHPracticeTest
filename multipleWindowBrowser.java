package PracticeExample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindowBrowser {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}

	@Test
	public void multipleWindowsRedux() {
		driver.get("http://the-internet.herokuapp.com/windows");
		String firstWindow = driver.getWindowHandle();
		String newWindow = "";
		driver.findElement(By.cssSelector(".example a")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(firstWindow)) {
				newWindow = window;
			}
		}
		driver.switchTo().window(firstWindow);
		String firstWindowTitle = driver.getTitle();
		System.out.println(firstWindowTitle);
		assertThat(driver.getTitle(), is(not(equalTo("New Window"))));
		driver.switchTo().window(newWindow);
		String secondWindowTitle = driver.getTitle();
		System.out.println(secondWindowTitle);
		assertThat(driver.getTitle(), is(equalTo("New Window")));
	}
}

