package PlayPen;
import java.net.Socket;
import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

public class AT01_MeetingAvailableByJurisdiciton {
    @Test
    public void getcall() throws InterruptedException, NoSuchFieldException {

          Response response= RestAssured.given()
                .when()
                .get("https://api.congo.beta.tab.com.au/v1/tab-info-service/racing/dates/2022-05-17/meetings?jurisdiction=VIC")
                .then()
                //.statusCode(StatusCode1)
                .and()
                .log().all()
                .extract().response()
                ;

        Thread.sleep(1000);
        //get one key value from output
        JsonPath jsXpath = new JsonPath(response.asString());

        //Get Race Number [This is a Array]
        Object MeetingName= jsXpath.get("meetings.meetingName");
        System.out.println("MeetingName is : " + MeetingName);

        //Get venueMnemonic [This is a Array]
        List venueMnemonic= jsXpath.get("meetings.venueMnemonic");
        System.out.println("venueMnemonic is : " + venueMnemonic);
        int venueMnemonicCount=  venueMnemonic.size();
        System.out.println("RaceTypeCount is : " + venueMnemonicCount);

        //Get raceType [This is a Array]
        List raceType = jsXpath.get("meetings.raceType");
        System.out.println("raceType is : " + raceType);
        int RaceTypeCount=  raceType.size();
        System.out.println("RaceTypeCount is : " + RaceTypeCount);
        for(int i=0;i<RaceTypeCount;i++){
            System.out.println(raceType.get(i));

        }

// put into hashmap
        Map<Object, Object> map = new HashMap<>();

        for (int i = 0; i <RaceTypeCount; i++) {
            System.out.println(i);
            map.put(venueMnemonic.get(i), raceType.get(i));
            System.out.println(map);
        }

        //get data from hashmap
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {

                Object k = entry.getKey();
                Object v = entry.getValue();
                System.out.println("Key: " + k + ", Value: " + v);

                String url = "https://api.congo.beta.tab.com.au/v1/tab-info-service/racing/dates/2022-05-17/meetings/" + v + "/" + k + "/races/1?jurisdiction=VIC";
                System.out.println("url : "+url);
// second part
                Response response1= RestAssured.given()
                        .when()
                    //    .get("https://api.congo.beta.tab.com.au/v1/tab-info-service/racing/dates/2022-05-11/meetings/R/GUN/races/1?jurisdiction=VIC")
                        .get(url)
                        .then()
                        //.statusCode(StatusCode1)
                        .and()
                        .log().all()
                        .extract().response()
                        ;


                Thread.sleep(1000);
                //get one key value from output
                JsonPath jsXpath1 = new JsonPath(response1.asString());

                //Get Race Name
                Object raceName1= jsXpath1.get("raceName");
                System.out.println("raceName is : " + raceName1);

                //Get Meeting Name
                Object MeetingName1= jsXpath1.get("meeting.meetingName");
                System.out.println("MeetingName is : " + MeetingName1);

                //Get venueMnemonic
                Object venueMnemonic1= jsXpath1.get("meeting.venueMnemonic");
                System.out.println("venueMnemonic is : " + venueMnemonic1);

                //Get all runners
                Object runnerNumber1 = jsXpath1.get("runners.runnerNumber");
                System.out.println("runnerNumber is : " + runnerNumber1);

                //Get all runners
                Object RunnerName1 = jsXpath1.get("runners.runnerName");
                System.out.println("RunnerName is : " + RunnerName1);

                //Get all the pools
                Object BetTypes = jsXpath1.get("betTypes.wageringProduct");

                if (BetTypes != null){
                    System.out.println("All Bets Available for this race are : "+ BetTypes);
                    break;
                }



            }
        }

    }

}