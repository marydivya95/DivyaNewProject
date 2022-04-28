package BasicsOfJav;

import org.junit.Test;

public class AT06_createAnObjectAndUseIt02 {

    @Test
    public void test10(){
        //whichever class we are calling we have to create an object of that class
        AT02_LearnAboutMethod_JUnit obj = new AT02_LearnAboutMethod_JUnit();
        obj.test01();
        obj.test02();

        AT05_createAnObjectAndUseIt01 obj1= new AT05_createAnObjectAndUseIt01();
        obj1.test07();
        obj1.test08();
        obj1.test09();
    }
}
