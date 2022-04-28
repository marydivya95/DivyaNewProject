package BasicsOfJav;

import org.junit.Test;

public class AT04_GlobalVariables {
    //global variables
    int i = 10;
    int j = 20;
    String abc = "testlab";

    @Test
    public void test05() {
        //local variables
        int l = 30;
        //data for this variable k is comming from the global variables
        int k = i + j;
        System.out.println("Value of k is : " + k); //output 30
        System.out.println("Value of k is : " + (k + l)); //output 60
    }

    @Test
    public void test06() {
        //local variables
        int k = i * j;
        System.out.println("value of k is  : " + k); //output 200
        System.out.println(" value of abc is : " + abc);
    }
}