package PlayPen;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AT03_dateget {

    @Test
    public void dateformat(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
}
