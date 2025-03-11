package FormFill;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CartForm {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // to maximize the screen size
		driver.get("https://cart.com/contact/sales"); //To visit Url in Chrome
		Thread.sleep(4000);
		//Closing the cookie pop up
		driver.findElement(By.id("onetrust-close-btn-container")).click();
 		Thread.sleep(2000);
	   //Message box
		
		
//		 WebElement Text = driver.findElement(By.xpath("//textarea[@name='contant_message']"));
//		 Text.click();
//	     Text.sendKeys("Hello! This is an Selenium Test Case");
        //WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Kartik Sharma");
		
        Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		firstName.click();
		firstName.sendKeys("Kartik");
		
		//Finding the Last Name
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.click();
		lastName.sendKeys("Sharma");
		
		//finding the phone number
		
		WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone number']"));
		phone.click();
		phone.sendKeys("1234567890");
		
		//Finding the email address
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Work email']"));
		email.click();
		email.sendKeys("Kartikgautam123@gmail.com");
		
		
		//Enter company name
		
		WebElement companyName = driver.findElement(By.xpath("//input[@placeholder='Company']"));
		companyName.click();
		companyName.sendKeys("Blinkit");
		
			
		//DropDown
		WebElement dropdn = driver.findElement(By.xpath("//select[@id='country-dac8341c-befa-4b14-af02-786eba6a50dd_7452']"));
		Select sel = new Select(dropdn);
		// Selecting by value index
		//sel.selectByIndex(11);
		
		sel.selectByVisibleText("Cook Islands"); // selecting by visible text
		//select all check boxes
		//handling check boxes
		 WebElement Text = driver.findElement(By.xpath("//textarea[@name='contant_message']"));
		 Text.click();
	     Text.sendKeys("Hello! This is an Selenium Test Case");
		//Use Findelements to get multiple checkbox
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']")); 
		//uses list to each check box
		for(WebElement ele: checkbox) {			
			ele.click();
		}
		
		 Thread.sleep(2000);
		
		
		//Click on the Submit Button
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		Thread.sleep(4000);
		String url = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		
		if(url.equals("https://cart.com/thank-you?submissionGuid=aeb7cb1f-4816-4e5c-b38a-d02313025f5b")) {
			System.out.println("<-----Test case Pass----->");
		}
	  

	}

}
