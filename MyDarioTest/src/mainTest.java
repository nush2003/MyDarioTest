
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class mainTest {
	static WebDriver driver;
	static String path = System.getProperty("user.dir");
	Logger logger = LogManager.getLogger(mainTest.class);
	
	dashboardPage dashPage = new dashboardPage(driver);
	
	
	@BeforeClass
	public static void initDriver() {
				
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("download.default_directory", path);
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("prefs", chromePrefs);	
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	
	 @Test
	 public void test() throws IOException, InterruptedException {
		 
		
		driver.get("https://todomvc.com/examples/react/#/");	
		
		dashPage.addMissions("Read", "Write");
		dashPage.checkTheCorrertness();	
	 } 
	 
	
	
	 
	 @AfterClass
	 public static void tearDown() {
		driver.quit();
	 }
	
}
