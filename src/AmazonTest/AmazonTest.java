package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    public static void main(String[] args) throws IOException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to Amazon.in
        driver.get("https://www.amazon.in");

        // Find the search box and enter "samsung mobile"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung mobile");
        searchBox.submit();
        TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("test.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
       
        
          
        List<WebElement> product_names = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
        List<WebElement> currency = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-symbol']"));
        List<WebElement> price = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-whole']"));
        
      
        for(int i=1;i<product_names.size();i++) {
        	
        	System.out.println("Name: " +product_names.get(i).getText()+ " || Price: " + currency.get(i).getText()+price.get(i).getText()) ;
        	
        	}
      
       

        // Close the browser
        //driver.quit();
    }
}
