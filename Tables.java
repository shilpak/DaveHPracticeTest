package PracticeExample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.LinkedList;
import java.util.List;

public class Tables {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
	}

	@Test
	public void withoutHelpfulMarkupDuesAscending() {
		{
			driver.get("http://the-internet.herokuapp.com/tables");
			driver.findElement(By.xpath("//th[@class='header']/span")).click();
			List<WebElement> dues = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(4)"));
			System.out.println(dues.size());
			List<Double> dueValues = new LinkedList<Double>();
			for(WebElement element : dues){
				dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
			}
			
			System.out.println(dueValues.size());
			

		}
	}

	/*@After
	public void tearDown() throws Exception {
	driver.quit();
	}*/

}
