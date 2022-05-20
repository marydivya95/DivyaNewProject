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
public class AT11_WebTables {
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
        driver.get("file:///D:/SeleniumMaterial-StudentsDistribution/04_SeleniumLearning/10_WebTables/webtablehtml.html");
// get columns count
        List<WebElement> colcount = driver.findElements(By.xpath("/html/body/table/thead/tr/th"));
        int colSize = colcount.size();
        System.out.println("colSize :" + colSize); //7

        //get row count
        List<WebElement> rowcount = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
        int rowSize = rowcount.size();
        System.out.println("rowSize :" + rowSize);

        ///row1, data 1 , this is basically like hardcoding to get a specific value
        WebElement CellVal= driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]"));
        System.out.println("print specific value from cell  : "+ CellVal.getText() );

        // to print all the values in the row which has header as "clock tower hotel"
        String sRowVal= "Clock Tower Hotel";


        // get all row headings under structure
        List<WebElement> HeadCount = driver.findElements(By.xpath("/html/body/table/tbody/tr/th"));
        int NumCells  = HeadCount.size();
        System.out.println("NumCells  :" + NumCells ); //4

        //get count of cell values in row
        List<WebElement> row2Count= driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td"));
        int Row2Size = row2Count.size();
        System.out.println("Row2Size :" + Row2Size); //6


        //this code is for finding the headers values in row
        outerloop:
        for(int i=1;i<=NumCells;i++){
           String sValue= driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/th")).getText();
            System.out.println("RowHeaderValue is : "+sValue );

            if(sValue.equalsIgnoreCase(sRowVal)) {
                //this code is for finding the row values associated with header
                for (int m =1; m<=Row2Size; m++) {
                    String RowValue = driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+m+"]")).getText();
                    System.out.println("RowValue  is : " + RowValue);
                    break outerloop;
                }

            }

        }



    }
}