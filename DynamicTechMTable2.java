import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//driver.findElement(By.xpath("//label[contains(@id,'dv-textbox-label-SubList')]");
//ul[@class='pagination pagination-sm']//li[@class='paginate_button active']//following::li[1]/a

public class DynamicTechMTable2 {

	public static void scrollBy(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}

	@Test
	public void paginationTest() throws Exception
	{
		List<String> names = new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa\\eclipse-workspace\\mavenjenkins\\FacebookQuiries\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trendlyne.com/equity/insider-trading-sast/all/TECHM/1374/tech-mahindra-ltd/");
		Assert.assertEquals(driver.getTitle(),"Tech Mahindra Ltd. - Disclosures under Insider Trades & Substantial Acquisition of Shares and Takeovers");
		driver.findElement(By.xpath("//div[contains(@id, 'DataTables_Table')]"));
		
		scrollBy(driver);
		
		List<WebElement> namesElements=driver.findElements(By.xpath("//div[contains(@id, 'DataTables_Table')]//tbody//tr//td[1]"));

		for(WebElement namesElement : namesElements) {		    
			names.add(namesElement.getText());
		}

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String liclass = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//ul//li[last()]")).getAttribute("class");
		
		while(!liclass.contains("disabled")) {
			WebElement element = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//ul//li[last()]"));
			js1.executeScript("arguments[0].click();",element);	
			//driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//ul//li[last()]")).click();
			namesElements=driver.findElements(By.xpath("//div[contains(@id, 'DataTables_Table')]//tbody//tr//td[1]"));

			for(WebElement namesElement : namesElements) {		    
				names.add(namesElement.getText());
			}

			liclass = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//ul//li[last()]")).getAttribute("class");
		}
		for(String name : names) {
			System.out.println(name);						
		}
		
		int totalNames = names.size();
		System.out.println("Total number of Names:" + totalNames);
		
		String displayedCount = driver.findElement(By.xpath("//div[@class='dataTables_info']")).getText().split(" ")[5];
		System.out.println("Total count displayed:"+displayedCount);
		
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		
		Thread.sleep(5000);

	}

}




