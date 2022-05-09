package SeleniumLearning;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AT04_AlertHandling {

    @Test
    public void NavHn() throws InterruptedException, IOException {
        //setting up chromedriver
        WebDriverManager.chromedriver().setup();
        //options
        ChromeOptions chromeOptions = new ChromeOptions();
        //we create an object of WebDriver
        WebDriver driver = new ChromeDriver(chromeOptions);
        //At this point browser will be opened
        //maximize browser
        driver.manage().window().maximize();
        //Navigate to HN website
        driver.get("https://www.bigw.com.au");
        Thread.sleep(15000);
// if you find the alert, then jump into below if loop
        if(driver.switchTo().alert() != null)
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.dismiss(); // alert.accept();

        }
    }
}
