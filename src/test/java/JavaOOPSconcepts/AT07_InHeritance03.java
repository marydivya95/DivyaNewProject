package JavaOOPSconcepts;

import org.junit.Test;

public class AT07_InHeritance03 {

    // as this class AT06_InHeritance02, has inherited all the methods from parent AT05_InHeritance01,
    // now we can use all of these in another class

    @Test
    public void inhMethod05(){
        AT06_InHeritance02 obj = new AT06_InHeritance02();
        obj.inhMethod01();
        obj.inhMethod02();
        obj.inhMethod03();
        obj.inhMethod04();

    }

    @Test
    public void inhMethod06() {
//  As we called this method03 from parent, whatever the logic in it will be printed but it wont print logic from child(InHeritance02)- method03
        AT05_InHeritance01 obj = new AT05_InHeritance01();
        obj.inhMethod03();
    }


}
