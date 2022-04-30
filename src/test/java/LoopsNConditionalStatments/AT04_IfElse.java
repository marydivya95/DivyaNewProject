package LoopsNConditionalStatments;

import org.junit.Test;

public class AT04_IfElse {
    @Test
    public void IfElseLoopLearn(){
        String browser = "CHROMEe";
        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("test case will execute on chrome");

        }
        else{
            System.out.println("test case will not execute on chrome");
        }
    }
}
