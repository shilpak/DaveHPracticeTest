package PracticeExample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.chrome.ChromeDriver;


public class multipleWindows {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}
	
	@Test
	public void multipleWindowTest() {
	driver.get("http://the-internet.herokuapp.com/windows");
	driver.findElement(By.cssSelector(".example a")).click();
	//create array of window handles
	Object[] allWindows = driver.getWindowHandles().toArray();
	driver.switchTo().window(allWindows[0].toString());
	String firstWindowTitle = driver.getTitle();
	System.out.println(firstWindowTitle);//The Internet
	assertThat(driver.getTitle(), is(not("New Window")));
	driver.switchTo().window(allWindows[1].toString());
	String secondWindowTitle = driver.getTitle();
	System.out.println(secondWindowTitle);//New Window
	assertThat(driver.getTitle(), is("New Window"));
	}

}
