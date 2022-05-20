package SeleniumLearning;
import PropertiesFile.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Xls_Reader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AT12_ExcelDataUsage {

    @Test
    public void table() throws IOException {
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
        //driver.get("https://www.harveynorman.com.au/customer/account/create/");
        driver.get(ReadPropertiesFile.PropFile("CreateAccount"));

        //implicit wait
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Here we are giving the path of excel sheet
        //Xls_Reader reader = new Xls_Reader("D:\\SeleniumMaterial-StudentsDistribution\\06_DataDrivenTesting\\05_SeleniumParameterization\\TestDataHN1.xlsx");
        Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\Resouces\\TestDataHN1.xlsx");
          // count of rows in the excel sheet
        int rowcount=reader.getRowCount("RegTestData");
        System.out.println("rowcount :"+rowcount);
        for(int j=2; j<=rowcount;j++){
            //Here we picked up data for Firstname from excel
           String FirstName=reader.getCellData("RegTestData","FirstName",j);
           //Here we enter First Name
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(FirstName);

            //Here we picked up data for Firstname from excel
            String lastname=reader.getCellData("RegTestData","LastName",j);
            //Here we enter First Name
            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys(lastname);

            //Here we picked up data for Firstname from excel
            String email_address=reader.getCellData("RegTestData","EmailAddress",j);
            //Here we enter First Name
            driver.findElement(By.id("email_address")).clear();
            driver.findElement(By.id("email_address")).sendKeys(email_address);

            //Here we picked up data for Firstname from excel
            String password=reader.getCellData("RegTestData","Password",j);
            //Here we enter First Name
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);

            //Here we picked up data for Firstname from excel
            String confirmation=reader.getCellData("RegTestData","RePassword",j);
            //Here we enter First Name
            driver.findElement(By.id("confirmation")).clear();
            driver.findElement(By.id("confirmation")).sendKeys(confirmation);

            String textName=driver.findElement(By.xpath("//*[contains(text(),'Create an account')]")).getText();
            reader.setCellData("RegTestData","Result",j,textName);





        }


    }
}