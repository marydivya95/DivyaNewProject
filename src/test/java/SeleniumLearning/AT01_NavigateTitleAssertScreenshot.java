package SeleniumLearning;
import BaseClass.OpenBrowser;
import PropertiesFile.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AT01_NavigateTitleAssertScreenshot {
@Test
    public void NavHn() throws IOException {
//        //setting up chromedriver
//        WebDriverManager.chromedriver().setup();
//        //options
//        ChromeOptions chromeOptions = new ChromeOptions();
//        //we create an object of WebDriver
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        //At this point browser will be opened
//        //maximize browser
//        driver.manage().window().maximize();
//        //navigate to HN website
//       // driver.get("https://www.harveynorman.com.au");
//      driver.get(ReadPropertiesFile.PropFile("OpenBrowser"));
// all above lines replaced by this below line
        OpenBrowser.NavToWebsite(ReadPropertiesFile.PropFile("HNWebsite"));

       // implicit wait
    OpenBrowser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get title
        String ActualTitle = OpenBrowser.driver.getTitle();
        System.out.println("HNTitle : "+ActualTitle);
        String ExpectedTitle = "Harvey Norman | Shop Online for Computers, Electrical, Furniture, Bedding, Bathrooms & Flooring | Harvey Norman Australia";
        //Assertion Version-1
        Assert.assertEquals(ExpectedTitle,ActualTitle);

        //Assert version-2
         Assert.assertTrue(ActualTitle.contains("Computers"));

         //Screenshot
        File screenshotFile = ((TakesScreenshot)OpenBrowser.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("C:\\Users\\username\\screenshot.png"));



    }
}
