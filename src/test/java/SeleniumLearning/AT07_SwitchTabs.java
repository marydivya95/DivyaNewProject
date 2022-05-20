package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AT07_SwitchTabs {
    @Test
    public void SwitchTabLearn() throws InterruptedException {
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
        driver.get("https://www.harveynorman.com.au/customer/account/login");
        //implict wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //click on CustomiseMe, new tab will open
        driver.findElement(By.partialLinkText("CustomiseMe")).click();
        //implict wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // System.out.println(" open tabs are : "+tabs);
        int tabSize = tabs.size();
        System.out.println("tabs count " + tabSize);
//// 1st method
//        for(int i=0; i<tabSize; i++){
//            driver.switchTo().window(tabs.get(i));
//            break;
//        }

        //2nd method
        int i = 0;
        do {
            Thread.sleep(20000);
            driver.switchTo().window(tabs.get(i));
            Thread.sleep(20000);
            driver.navigate().refresh();
            i++;
            break;
        } while (i<tabSize) ;

    }
}