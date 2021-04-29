package assignmentweek2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		//Step 1: Launch the Chrome Browser
		ChromeDriver driver = new ChromeDriver();
				
		//Step 2: URL Load
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Step 3: Maximize the Browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Step 4: find the Username and type the value
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Step 5: find the Password and type the value
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Step 6: Find the Login button and Click
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Step 7: Verify that you are logged in
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		//Step 8: Get the title and verify it
		String title = driver.getTitle();
		if(title.equals("Leaftaps - TestLeaf Automation Platform")) {
			System.out.println("Validate the Proper Title of Page should be displayed");
		} else {
			System.err.println("Valid Title of Page is not displayed");
		}
		
		//Step 9: click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Step10: click Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 11: Click Create Contacts
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Step 12: Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Dhilip Sudhan");
		
		//Step 13: Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Muralidharan");
		
		//Step 14: Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Dhilip");
		
		//Step 15: Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Sudhan");
		
		//Step 16: Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.name("departmentName")).sendKeys("Quality");
		
		//Step 17: Enter Description Field Using any Locator of your choice 
		driver.findElement(By.name("description")).sendKeys("Quality Assurance");
		
		//Step 18: Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.name("primaryEmail")).sendKeys("xyz@gmail.com");
		
		//Step 19: a) Select State/Province as NewYork Using Visible Text
		WebElement eleStateProv = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		//Step 19: b) Convert the WebElement as Select
		Select dpStateProv = new Select(eleStateProv);
		
		//Step 19: c) Choose the option by getvisibletext
		dpStateProv.selectByVisibleText("California");
		
		//Step 20: Click Create contact
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(5000);
		
		//Step 21: Click on edit button
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		
		//Step 22: Clear the Description Field using .clear
		driver.findElement(By.name("description")).clear();
		Thread.sleep(2000);
		
		//Step 23: Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Selenium Java");
		
		//Step 24: Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);
		
		// Step 25: Get the Title of Resulting Page.
		String titlePge = driver.getTitle();
		System.out.println(titlePge);
		
		}

}
