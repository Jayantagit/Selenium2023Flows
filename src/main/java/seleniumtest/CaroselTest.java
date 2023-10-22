package seleniumtest;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaroselTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();
		Thread.sleep(10000);

		printCarsosel("Recommended for you");

	}

	private static void printCarsosel(String sectionName) {
		String prodName = "//h2[contains(text(),'" + sectionName
				+ "')]/ancestor::div[@class='sc-dAlyuH hNlDMy']/following-sibling::div//div[@data-qa='product-name']/span";
		System.out.println(prodName);
		String next = "//h2[text()='" + sectionName
				+ "']/ancestor::div[@class='sc-dAlyuH hNlDMy']/following-sibling::div//div[contains(@class,'swiper-button-next')]";

		// swiper-button-disabled"
		Set<String> prodSet = new TreeSet<String>();
		List<WebElement> prodList = driver.findElements(By.xpath(prodName));
		System.out.println(prodList.size());
		WebElement nextIcon = driver.findElement(By.xpath(next));
		while (!nextIcon.getAttribute("class").contains("swiper-button-disabled")) {

			for (WebElement e : prodList) {
				prodSet.add(e.getText().trim());
			}
			nextIcon.click();
			prodList = driver.findElements(By.xpath(prodName));
		}

		for (String pname : prodSet) {
			System.out.println(pname + " ");
		}

	}

}
