package assignmentweek2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		
		//Step 12: Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		
		//Step 13: Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
		
		//Step 14: Click find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 15: Capture lead ID of First Resulting lead
		String FirstResLead = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();
		
		//Step 16: Click First Resulting lead
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
		Thread.sleep(2000);
		
		//Step 17: Click Delete
		driver.findElement(By.linkText("Delete")).click();
		
		//Step 18: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 20: Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(FirstResLead);
		
		//Step21: Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		
		//Step 22:Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String NoRectext = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(NoRectext);
		if(NoRectext.equalsIgnoreCase("No records to display")) {
			System.out.println("Created Lead should be deleted");
		} else {
			System.err.println("Created Lead is not deleted");
		}
		
		//Step 23: Close the browser (Do not log out)
		driver.close();
		
	
		

	}

}
