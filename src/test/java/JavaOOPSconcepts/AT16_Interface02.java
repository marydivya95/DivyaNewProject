package JavaOOPSconcepts;

import org.junit.Test;

public class AT16_Interface02 implements AT15_Interface01 {
@Test
    public void add(){
        int y = 20+x;
        System.out.println("value of y is : "+y);
    }
    @Test
    public void su(){
        System.out.println("This is sub method");
    }
    @Test
    public void div(){
        System.out.println("This is div method");
        // static value
        System.out.println(AT15_Interface01.x);
    }

}
