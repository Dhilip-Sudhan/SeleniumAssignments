package assignmentweek2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		
		//Step10: click Leads Link
		driver.findElement(By.linkText("Leads")).click();
		
		//Step 11: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 12: Click on Email
		driver.findElement(By.linkText("Email")).click();
		
		//Step 13: Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("xyz@gmail.com");
		
		//Step 14: Click find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 15: Capture name of First Resulting lead
		String namefirstlead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]")).getText();
		System.out.println(namefirstlead);
		
		//Step 16: Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]")).click();
		Thread.sleep(2000);
		String leadname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(leadname);
		
		//Step 17: Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(2000);
		
		//Step 18: Verify the title as 'Duplicate Lead'
		String titleDup = driver.getTitle();
		if(titleDup.contains("Duplicate Lead")) {
			System.out.println("Duplicate Lead title is displayed");
		} else {
			System.err.println("Duplicate Lead title is not displayed");
		}

		//Step 19: Click Create Lead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(5000);
		
		//Step 20: Confirm the duplicated lead name is same as captured name
		String dupnamelead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(dupnamelead);
		Thread.sleep(2000);
		if(dupnamelead.equalsIgnoreCase(leadname)) {
			System.out.println("Lead Name and Duplicate Lead name should be matched");
		} else {
			System.err.println("Lead Name and Duplicate Lead name not matched");
		
		}
		
		//Step 21: Close the browser (Do not log out)
		driver.close();
	}

}
