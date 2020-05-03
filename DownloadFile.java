package PracticeExample;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFile{

	WebDriver driver;
	File folder;

	@Before
	public void setUp() throws Exception {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		//
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", "C:\\Users\\Shilpa\\Desktop\\davetest");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg, application/pdf, application/octet-stream");      
		profile.setPreference( "browser.download.manager.showWhenStarting", false );
		profile.setPreference( "pdfjs.disabled", true );
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(profile);
		driver = new FirefoxDriver(opt); 
	}

	@Test
	public void download() throws Exception {
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[contains(text(),'example.json')]")).click();
		// Wait 2 seconds to download file

		}
	

	@After
	public void tearDown() throws Exception {
		for (File file : folder.listFiles()) {
			file.delete();
		}

		folder.delete();
	}

}
