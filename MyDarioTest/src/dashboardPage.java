

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class dashboardPage {
	Logger logger = LogManager.getLogger(dashboardPage.class);
	WebDriver driver;
	
	public dashboardPage (WebDriver driver) {
		this.driver = driver;
	}
	
	 By inputField = By.xpath("/html/body/section/div/header/input");
	 By todoCount = By.xpath("/html/body/section/div/footer/span");
	 By todoList = By.xpath("/html/body/section/div/section/ul/li");
	 By completedTab = By.xpath("/html/body/section/div/footer/ul/li[3]/a");
	 By allTab = By.xpath("/html/body/section/div/footer/ul/li[1]/a");
	 By clearCompletedTab = By.xpath("/html/body/section/div/footer/button");
	 By firstCheckBox = By.xpath("/html/body/section/div/section/ul/li[1]/div/input");
	 
	
		
	public void addMissions (String missionName1, String missionName2)  {
		logger.info("adding new missions");
		driver.findElement(inputField).sendKeys(missionName1);
		driver.findElement(inputField).sendKeys(Keys.ENTER);
		driver.findElement(inputField).sendKeys(missionName2);
		driver.findElement(inputField).sendKeys(Keys.ENTER);		
	}
	
	public void checkTheCorrertness() {
		logger.info("verifying that the missions added and in the left corner we see '2 items left' message ");
		Assert.assertTrue("Verification Failed: The missions were not added "  ,driver.findElements(todoList).size()==2);
		Assert.assertTrue("Verification Failed: The text '2 items left' doesn't appear in the left corner "  ,driver.findElement(todoCount).getText().equals("2 items left"));		
	
		logger.info("verifying that in completed tab there are no missions ");
		driver.findElement(completedTab).click();
		Assert.assertTrue("Verification Failed: The missions were not added "  ,driver.findElements(todoList).size()==0);
		
		logger.info("choosing one mission and checking that in the left corner we see '1 item left' message");
		driver.findElement(allTab).click();
		driver.findElement(firstCheckBox).click();
		Assert.assertTrue("Verification Failed: The text '1 item left' doesn't appear in the left corner "  ,driver.findElement(todoCount).getText().equals("1 item left"));		
		
		logger.info("verifying that in completed tab there is 1 mission");		
		driver.findElement(completedTab).click();
		Assert.assertTrue("Verification Failed: The missions were not added "  ,driver.findElements(todoList).size()==1);
		
		logger.info("clearing the completed tab and verifying that in completed tab there are no missions");
		driver.findElement(clearCompletedTab).click();
		Assert.assertTrue("Verification Failed: The missions were not added "  ,driver.findElements(todoList).size()==0);
	
	}
	
	
}



