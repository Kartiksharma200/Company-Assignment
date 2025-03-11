package SearchProduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	WebDriver driver = new ChromeDriver();
	Search_Page searchpage = new Search_Page(driver);
	
	
	public void productSearchAndAddToCart() throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		searchpage.searchForProduct("iphone");
		searchpage.addFirstProductToCart();
		if(searchpage.isProductInCart()) {
			System.out.println("Product added to cart successfully!");
		}else {
			System.out.println("Failed to add product to cart.");
		}
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		test.productSearchAndAddToCart();
	}

}
