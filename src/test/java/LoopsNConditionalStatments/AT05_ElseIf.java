package LoopsNConditionalStatments;

import org.junit.Test;

public class AT05_ElseIf {
    @Test
    public void ElseIfLoopLearn(){
        String browser = "FIREdfgdsFOX";
        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("test case will execute on chrome");
        }
        else if(browser.equalsIgnoreCase("ie")){
            System.out.println("test case will execute on ie");
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.out.println("test case will execute on firefox");
        }
        else{
            System.out.println("Browser is not in the list ");
        }
    }
}
