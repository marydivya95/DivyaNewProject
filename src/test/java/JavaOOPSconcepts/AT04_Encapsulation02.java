package JavaOOPSconcepts;

import org.junit.Test;

public class AT04_Encapsulation02 {

    @Test
    public void envMethod03(){
        AT03_Encapsulation01 obj = new AT03_Encapsulation01();
        obj.envMethod01(900,900);

        //usage of return value
       int l = obj.envMethod02(20,20);
        System.out.println("return value + my value , total : " + (l+50));

    }
}
