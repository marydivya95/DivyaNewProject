//package PlayPen;
//
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.junit.Test;
//
//
//public class ExtraDataFromJson_Consumer {
//
//    @Test
//    public void extract() throws IOException, ParseException, IOException, ParseException {
//        JSONParser jsonParser = new JSONParser();
//        FileReader reader = new FileReader("C:\\Users\\etikalaj\\eclipse-workspace\\morningBatchProject\\src\\test\\java\\PlayPen\\test.json");
//        Object obj = (jsonParser).parse(reader);
//        JSONObject getsomething = (JSONObject) obj;
//       // System.out.println(getsomething.get("tournamentHierarchies"));
//
//        JSONArray array = (JSONArray) getsomething.get("tournamentHierarchies");
//         System.out.println(array);
//         String abc = (String) array.get("venue");
//        System.out.println(abc);
////        // System.out.println(jsXpath);
////        JSONArray array = (JSONArray) getsomething.get("tournamentHierarchies");
////        for (int i=0; i<array.size(); i++) {
////            JSONObject marketHierarchies = (JSONObject) array.get(i);
////
////            String displayName = (String) marketHierarchies.get("displayName");
////            System.out.println(displayName);
////        }
//    }
//}