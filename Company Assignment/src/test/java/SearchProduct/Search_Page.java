package SearchProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search_Page {
	
	WebDriver driver;
	
	
	By searchBox = By.xpath("//input[@placeholder='Search']");
    By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
    By firstProduct = By.xpath("//img[@title='iPhone']");
    By addToCartBtn = By.xpath("//button[@id='button-cart']");
	
	
	public Search_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	  public void searchForProduct(String productName) {
		  driver.findElement(searchBox).sendKeys(productName);
		  driver.findElement(searchBtn).click();
	        
	    }

	    public void addFirstProductToCart() {
	    	driver.findElement(firstProduct).click();
	    	driver.findElement(addToCartBtn).click();
	    }

	    public boolean isProductInCart() {
	        // Implement the logic to check cart for added product.
	        return driver.getPageSource().contains("shopping cart"); // For example
	    }
	
	

}
