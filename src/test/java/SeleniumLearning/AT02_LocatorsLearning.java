package SeleniumLearning;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AT02_LocatorsLearning {
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
        driver.get("https://www.thegoodguys.com.au/UserRegistrationForm?myAcctMain=1&new=Y&catalogId=30000&langId=-1&storeId=900");
        // implict wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //By.id
        driver.findElement(By.id("regAddForm_firstName")).sendKeys("test");
        //By.name
        // driver.findElement(By.name("firstName")).sendKeys("test");
        //by.linktext --this is failing because its not able to find element in the focused screen
        driver.findElement(By.linkText("Sitemap")).click();

    }
}