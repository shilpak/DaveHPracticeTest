package PracticeExample;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class HoverElement {
	
		WebDriver driver;
		
		@Before
		public void setUp() throws Exception {
			driver = new ChromeDriver();			
		}	
		
		@Test
		public void hoverElementTest() {
			driver.get("http://the-internet.herokuapp.com/hovers");
			WebElement avatar = driver.findElement(By.className("figure"));
			Actions builder = new Actions(driver);
			builder.moveToElement(avatar).build().perform();
			
			/*//can be written as utility method
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
			"figure")));
			
			assertThat(driver.findElement(By.className("figcaption")).isDisplayed(), is(
					Boolean.TRUE));*/
		}
		
		
		
		
		@After
		public void tearDown() throws Exception {
		//driver.quit();
		}

}
