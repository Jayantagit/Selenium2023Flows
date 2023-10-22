package seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(8000);
		By priceList = By.xpath("//div[@class='inventory_item_price']");
		List<WebElement> price = driver.findElements(priceList);
		double maxPrice = price.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", ""))).max()
				.getAsDouble();
		System.out.println(maxPrice);
		String path = "//div[normalize-space()='$" + maxPrice + "']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(path)).click();

	}

}
