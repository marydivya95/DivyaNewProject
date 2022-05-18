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
public class AT06_RadioButtonSelect {

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
        driver.get("http://www.echoecho.com/htmlforms10.htm");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // we took similar webelements into a list
        List<WebElement> RadioButtonsList = driver.findElements(By.xpath("//input[@name='radio1']"));
        //Size of RadioButtonsList
        int RadioSize = RadioButtonsList.size();
        System.out.println("RadioSize : " + RadioSize);



//        for(int i=0; i<RadioSize;i++){
//            // this will click on each radio button in the list
//           // RadioButtonsList.get(i).click();
//
//            String RadioTxt=RadioButtonsList.get(i).getAttribute("name");
//            System.out.println("RadioTxt : "+RadioTxt);
//
//            if(RadioTxt.equalsIgnoreCase("radio1")){
//                RadioButtonsList.get(i).click();
//                //this will break the loop
//                break;
//                            }
//
//        }

        //another way of same example
        for(int i=0; i<RadioSize;i++){
            Boolean RadioTxt=  RadioButtonsList.get(i).isSelected();
            System.out.println("RadioTxt : "+RadioTxt); //false
            if(RadioTxt==false){
                RadioButtonsList.get(i).click();
                //this will break the loop
                break;
            }
        }
    }
}