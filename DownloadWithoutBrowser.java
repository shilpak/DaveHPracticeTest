package PracticeExample;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;

public class DownloadWithoutBrowser {
	
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
	driver = new ChromeDriver();
	}
	
	@Test
	public void download() throws Exception {
		driver.get("http://the-internet.herokuapp.com/download");
		String link = driver.findElement(By.xpath("//a[contains(text(),'example.json')]")).getAttribute("href");
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpHead request = new HttpHead(link);
		HttpResponse response = httpclient.execute(request);
		System.out.println(response);
		String contentType = response.getFirstHeader("Content-Type").getValue();
		System.out.println(contentType);
		int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
		System.out.println(contentLength);
		
		assertThat(contentType, is("application/octet-stream"));
		assertThat(contentLength, is(not(0)));
		}
	
	
	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

}
