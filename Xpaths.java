package assignmentweek2day2;

public class Xpaths {

	public static void main(String[] args) {
		
		//Step1: Enter the username based on its label
		//label[text()='Username']/following::input[1]
		
		//Step2: Enter the password based on its label
		//label[text()='Password']/following::input[1]
		
		//Step3: Click Login
		//input[@class='decorativeSubmit']
		
		//Step4: Click on CRMSFA link
		//a[contains(text(),'CRM/SFA')]
		
		//Step5: Click on Leads link
		//a[text()='Leads']
		
		//Step6: Click on Merge Leads link
		//a[text()='Merge Leads']
		
		//Step7: Click the first img icon
		(//img[@alt='Lookup'])[1]
		//input[@id='ComboBox_partyIdFrom']//following::img[1]		
		
		//Step8: Select the first resulting lead
		//input[@id='ComboBox_partyIdFrom']
				
		//Step9: Click the second img icon
		(//img[@alt='Lookup'])[2]
		//input[@id='ComboBox_partyIdTo']//following::img[1]
				
		//Step10: Select the second resulting lead
		//input[@id='ComboBox_partyIdTo']
		
		//Step11: Click on Merge Lead (submit) button
		//a[text()='Merge']
				
		//Step12: Get the company name text based on its label
		//span[text()='Company Name']//following::span[1]

	}

}
