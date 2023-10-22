package seleniumtest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTestPricing {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(10000);

		By productList = By.xpath("//div[@class='puisg-row']//h2");
		By priceList = By.xpath(
				"//div[@class='puisg-row']//h2//parent::div/following-sibling::div//span[@class='a-price-whole']");

		Map<String, Long> mobileMap = new LinkedHashMap<String, Long>();
		List<WebElement> prodList = driver.findElements(productList);
		List<WebElement> prodPriceList = driver.findElements(priceList);

		for (int i = 0; i < prodList.size(); i++) {
			String name = prodList.get(i).getText().trim();
			Long price = Long.parseLong(prodPriceList.get(i).getText().trim().replaceAll("[^0-9]", ""));

			mobileMap.put(name, price);

		}

		// mobileMap.forEach((k, v) -> System.out.println(k + ":" + v));
		List<Map.Entry<String, Long>> unsortedList = new LinkedList<Map.Entry<String, Long>>(mobileMap.entrySet());
		Collections.sort(unsortedList, (m1, m2) -> m1.getValue().compareTo(m2.getValue()));

		Map<String, Long> temp = new LinkedHashMap<String, Long>();
		for (Map.Entry<String, Long> aa : unsortedList) {
			temp.put(aa.getKey(), aa.getValue());
		}
		temp.forEach((k, v) -> System.out.println(k + ":" + v));
	}

}
