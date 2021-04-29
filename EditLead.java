package assignmentweek2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		
		//Step 12: Enter first name
		driver.findElement(By.xpath("//span[text()='Name and ID']//following::input[2]")).sendKeys("Dhilip");
		
		//Step 13: Click Find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		//Step 14: Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).click();
		
		//Step 15: Verify title of the page
		String titleDup = driver.getTitle();
		if(titleDup.contains("View Lead")) {
			System.out.println("View Lead title is displayed");
		} else {
			System.err.println("View Lead title is not displayed");
		}

		//Step 16: Click Edit
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		
		//Step 17: Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		String updatedcompanyExp = driver.findElement(By.id("updateLeadForm_companyName")).getText();
		
		//Step 18: Click Update
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(2000);
		
		//Step 19:Confirm the changed name appears
		String updatedcompanyAct = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(updatedcompanyAct.contains(updatedcompanyAct)) {
			System.out.println("Changed name should be matched");
		} else {
			System.err.println("Changed name not matched");
		
		}
		
		//Step 20: Close the browser (Do not log out)
		driver.close();
	}

}
