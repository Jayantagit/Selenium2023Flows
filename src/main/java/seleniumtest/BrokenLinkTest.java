package seleniumtest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		By productList = By.tagName("a");
		List<WebElement> links = driver.findElements(productList);

		List<String> brokenList = new ArrayList<String>();

		for (WebElement e : links) {
			try {
				String href = e.getAttribute("href");
				if (href.length() > 0) {
				//	System.out.println(href);
					if (checkLink(href) >= 400) {
						brokenList.add(href);
					}
				}
			} catch (Exception e1) {

			}

		}
		System.out.println(brokenList);

	}

	private static int checkLink(String href) {
		try {
			URL url = new URL(href);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			return http.getResponseCode();
		} catch (Exception e) {

		}
		return 0;
	}

}
