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

public class AmazonTest {

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
		By ratingList = By.xpath("//div[@class='puisg-row']//div[@class='a-row a-size-small']/span[1]");

		Map<String, Double> mobileMap = new LinkedHashMap<String, Double>();
		List<WebElement> prodList = driver.findElements(productList);
		List<WebElement> prodRatingList = driver.findElements(ratingList);
		String p = "4.3 out of 5 stars";
		double t = Double.parseDouble(p.trim().split(" ")[0]);
		System.out.println(t);

		for (int i = 0; i < prodList.size(); i++) {
			String name = prodList.get(i).getText().trim();
			// System.out.println(name);
			double rate = Double.parseDouble(prodRatingList.get(i).getAttribute("aria-label").trim().split(" ")[0]);

			mobileMap.put(name, rate);

		}

		// mobileMap.forEach((k, v) -> System.out.println(k + ":" + v));
		List<Map.Entry<String, Double>> unsortedList = new LinkedList<Map.Entry<String, Double>>(mobileMap.entrySet());
		Collections.sort(unsortedList, (m1, m2) -> m1.getValue().compareTo(m2.getValue()));

		Map<String, Double> temp = new LinkedHashMap<String, Double>();
		for (Map.Entry<String, Double> aa : unsortedList) {
			temp.put(aa.getKey(), aa.getValue());
		}
		temp.forEach((k, v) -> System.out.println(k + ":" + v));
	}

}
