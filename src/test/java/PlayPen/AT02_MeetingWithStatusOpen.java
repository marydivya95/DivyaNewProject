package PlayPen;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class AT02_MeetingWithStatusOpen {
    @Test
    public void getcall() throws  InterruptedException, NoSuchFieldException {

          Response response= RestAssured.given()
                .when()
                .get("https://api.congo.beta.tab.com.au/v1/tab-info-service/racing/dates/2022-05-11/meetings/R/GUN/races/1?jurisdiction=VIC")
                .then()
                //.statusCode(StatusCode1)
                .and()
                .log().all()
                .extract().response()
                ;

        Thread.sleep(1000);
        //get one key value from output
        JsonPath jsXpath = new JsonPath(response.asString());

        //Get Race Number
        Object RaceNumber= jsXpath.get("raceNumber");
        System.out.println("RaceNumber is : " + RaceNumber);

        //Get Race Name
        Object raceName= jsXpath.get("raceName");
        System.out.println("raceName is : " + raceName);

        //Get Meeting Name
        Object MeetingName= jsXpath.get("meeting.meetingName");
        System.out.println("MeetingName is : " + MeetingName);

        //Get venueMnemonic
        Object venueMnemonic= jsXpath.get("meeting.venueMnemonic");
        System.out.println("venueMnemonic is : " + venueMnemonic);

        //Get all the pools
        Object BetTypes = jsXpath.get("betTypes.wageringProduct");
        System.out.println("All Bets Available for this race are : "+ BetTypes);

    }

}
