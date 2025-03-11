package MultipleWindowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowHandles {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://the-internet.herokuapp.com/login"); 
	    Thread.sleep(2000); 
		driver.findElement(By.xpath("//a[normalize-space()='Elemental Selenium']")).click();  //Click on the Hyper Link to open new Tab
		
		Set<String> childid = driver.getWindowHandles();  //Control the Tabs with help of getWindowHandles
		System.out.println(childid); //Print Parentid
		//Iterator
		Iterator<String> itr = childid.iterator();
		
		//next()
        String id1 = itr.next();   //first tab id
        String id2 = itr.next();   //second tab id
           
        //Go to the child website
        Thread.sleep(3000); 
        driver.switchTo().window(id2); // Switch to second tab
       
        Thread.sleep(2000);         
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("Kartik123@gmail.com"); //Type Email
		
		WebElement language = driver.findElement(By.xpath("(//select[@id='options'])[1]"));
		//language.click();
		Select pick = new Select(language); // Select Python from the dropdown
		pick.selectByVisibleText("Python");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //Click on the submit button
		
		String url = driver.getCurrentUrl();  //To Check Enter the details are successful submit or not
		System.out.println(driver.getCurrentUrl()); //With help of url matching
		if(url.equals("https://elementalselenium.com/thanks?drip_email=Kartik123%40gmail.com&drip_subscriber_id=o14hlfwzpeu4jbqx85vl")) {;
		System.out.println("<---------Second tab url test successful----------->");
		}
		
		
		//Return to Parentwebsite
		Thread.sleep(5000);
		driver.switchTo().window(id1);
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		String urlmain = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		if(urlmain.equals("https://the-internet.herokuapp.com/secure")) {
			System.out.println("<------Complete WindowHandles------->");
		}
		
	}

}
 