package BasicsOfJav;

import org.junit.Test;

import java.io.IOException;

public class ymlusageInClassFile {
    @Test
    public void jagantest() throws IOException {
        System.out.println(PropertiesFileExtractor.initializeTestData("RegistrationData.FirstName"));
    }

}
