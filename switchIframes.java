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


public class switchIframes {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();	
	}

	@Test
	public void iFrames() throws Exception {
		driver.get("http://the-internet.herokuapp.com/tinymce");
		String iframevalue = driver.switchTo().frame("mce_0_ifr").toString();
		System.out.println(iframevalue);
		WebElement textbox = driver.findElement(By.id("tinymce"));
		String beforeText = textbox.getText();
		textbox.clear();
		textbox.sendKeys("Hello World!");
		String afterText = textbox.getText();
		assertThat(afterText, not(equalTo((beforeText))));
		driver.switchTo().defaultContent();
		assertThat(driver.findElement(By.cssSelector("h3")).getText(),
		is("An iFrame containing the TinyMCE WYSIWYG Editor"));
		
	}
}
