package PracticeExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.File;

public class Uploadfile {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception{
		driver = new ChromeDriver();		
	}
	
	@Test
	public void uploadFile() throws Exception {
		String filename = "testDH.txt";
		File file = new File(filename);
		String path = file.getAbsolutePath();
		driver.get("http://the-internet.herokuapp.com/upload");
		driver.findElement(By.id("file-upload")).sendKeys(path);
		driver.findElement(By.id("file-submit")).click();
		String text = driver.findElement(By.id("uploaded-files")).getText();
		System.out.println(text);
		
		assertThat(text, is(equalTo(filename)));
	}
	
	/*@After
	public void tearDown() throws Exception {
		driver.quit();
	}*/

}
