package LoginAutomation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class login {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	//READING DATA FROME THE FILE
		//FileInputStream file = new FileInputStream("C:\\Users\\10000\\eclipse-workspace\\Selenium-Test\\Test Data\\Instagram Assignment.xlsx");
		FileInputStream file = new FileInputStream("C:\\Users\\10000\\Downloads\\OrangeHRM.xlsx");
        Workbook bok = WorkbookFactory.create(file);
        String username = bok.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
        String password = bok.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
        
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
        
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        
        WebElement error = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        if(error.isDisplayed()) {
        	System.out.println("<-------Login Failed-------->");
        }else {
        	System.out.println("<--------Login Successful--------->");
        }
        
        Thread.sleep(3000);
        driver.quit();
	}
}
