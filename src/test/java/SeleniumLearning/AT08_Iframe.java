package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AT08_Iframe {

    @Test
    public void iframeListSelect() throws IOException {
        //setting up chromedriver
        WebDriverManager.chromedriver().setup();
        //options
        ChromeOptions chromeOptions = new ChromeOptions();
        //we create an object of WebDriver
        WebDriver driver = new ChromeDriver(chromeOptions);
        //At this point browser will be opened
        //maximize browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Navigate to HN website
        driver.get("https://www.harveynorman.com.au/signup");

        List<WebElement> ListOfIframes = driver.findElements((By.tagName("iframe")));
        int IframeCount=ListOfIframes.size();
        System.out.println("IframeCount : "+IframeCount);
        for(int i=0;i<IframeCount;i++){
            driver.switchTo().frame(1);
            driver.findElement(By.id("firstName")).sendKeys("test");
            break;
        }

    }



}
