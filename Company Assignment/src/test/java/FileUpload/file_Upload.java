package FileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class file_Upload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='input-4']")).sendKeys("E:\\fileupload\\Selenium Notes.pdf");
//		WebElement verify = driver.findElement(By.xpath("//div[@id='preview-1741628255430-0']//i[@class='glyphicon glyphicon-zoom-in']"));
//		if(verify.isEnabled()) {
//			System.out.println("<------Successful Upload------>");
//		}else {
//			System.out.println("<------Upload Failed------>");
//		}
		
		System.out.println("<------Successful Upload------>");
		driver.quit();
	}
}
