package PlayPen;


import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class AT05_GetJsonData {
    @Test
    public <object> void jsondata() throws IOException, ParseException, InterruptedException {
        String path = "C:\\Users\\etikalaj\\eclipse-workspace\\morningBatchProject\\src\\test\\java\\PlayPen\\test.json";
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONObject userloginsJsonobj = (JSONObject) obj;
        JSONArray userloginsArray = (JSONArray) userloginsJsonobj.get("tournamentHierarchies");
        //    String arr[]=new String[userloginsArray.size()];
        //        System.out.println(userloginsArray.size());
        for (int i = 0; i < userloginsArray.size(); i++) {
            JSONObject users = (JSONObject) userloginsArray.get(i);
            Object user = users.get("contestHierarchies");
            System.out.println("user : " + user);



        }
    }
}