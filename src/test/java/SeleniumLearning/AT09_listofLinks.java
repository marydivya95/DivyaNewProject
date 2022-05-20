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

public class AT09_listofLinks {

    @Test
    public void linkList() throws IOException {
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

        List<WebElement> ListOfLinks  = driver.findElements((By.tagName("a")));
        int Linkslst=ListOfLinks .size();
        System.out.println("Linkslst : "+Linkslst);
        for(int i=0;i<Linkslst;i++){
            String LinkNames=ListOfLinks.get(i).getText().trim();
            System.out.println("LinkNames :"+LinkNames);

            if(LinkNames.equalsIgnoreCase("SHOP ALL PRODUCTS")){
                ListOfLinks.get(i).click();
                break;
            }

        }
        driver.quit();
    }



}
