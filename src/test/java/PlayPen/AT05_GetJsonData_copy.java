package PlayPen;


import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AT05_GetJsonData_copy {
    @Test
    public  void jsondata() throws IOException, InterruptedException {
        String path = "C:\\Users\\etikalaj\\eclipse-workspace\\morningBatchProject\\src\\test\\java\\PlayPen\\test.json";
        // Read file into a string
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);

        }
// delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

//        String content = stringBuilder.toString();
////// convert to json array
////        JSONArray json = new JSONArray();
////        System.out.println(json);
////        System.out.println(json.add(content));

        JSONObject obj = new JSONObject(stringBuilder.toString());
        JSONArray objArry = obj.getJSONArray("tournamentHierarchies");
        System.out.println(objArry);
        System.out.println(objArry.length());
        System.out.println(objArry.getJSONObject(0));
        System.out.println(objArry.getJSONObject(0).getJSONObject("tournament").getString("name"));
        System.out.println(objArry.getJSONObject(0).getJSONArray("contestHierarchies").getJSONObject(
                0).getJSONArray("marketHierarchies").getJSONObject(
                0).getJSONObject("market").getString("name"));
        System.out.println(objArry.getJSONObject(0).getJSONArray("contestHierarchies").getJSONObject(
                0).getJSONArray("marketHierarchies").getJSONObject(
                0).getJSONObject("market").getString("displayName"));
        System.out.println(objArry.getJSONObject(0).getJSONArray("contestHierarchies").getJSONObject(
                0).getJSONArray("marketHierarchies").getJSONObject(
                0).getJSONObject("market").getString("marketStatus"));
for (int i=0; i<objArry.length();i++){



    System.out.println(objArry.getJSONObject(i).getJSONObject("venueHierarchy").names());
    System.out.println(objArry.getJSONObject(i).names());
    for(int j=0; j<objArry.getJSONObject(i).names().length();j++){
        System.out.println(objArry.getJSONObject(i).names().get(i));

    }
}
    }
}