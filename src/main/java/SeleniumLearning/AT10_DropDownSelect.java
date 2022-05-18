package SeleniumLearning;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
public class AT10_DropDownSelect {

    @Test
    public void iframeReg() throws InterruptedException {

        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/hp-15-6-inch-i7-1195g7-8gb-256gb-ssd-laptop.html");
        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Select DropDownList=new Select(driver.findElement(By.id("select_999999900")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        int sizeofEle=DropDownList.getOptions().size();

        for(int i=0;i<sizeofEle;i++){
            String TxtVal=DropDownList.getOptions().get(i).getText().trim();
            System.out.println("TxtVal :"+TxtVal);

            if(TxtVal.equalsIgnoreCase("2 years Product Care Replacement")){
                DropDownList.getOptions().get(i).click();
                break;
            }
        }
 // 2nd method , this 2years warranty will be selected
     //        DropDownList.selectByVisibleText("2 years Product Care Replacement");

        //3rd method
       // DropDownList.selectByIndex(2);



    }
}