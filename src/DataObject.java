import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObject {
    public static void jsonFileWriter(String f) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("firstName", "Cameron");
        obj.put("lastName", "Howell");

        Files.write(Paths.get(f), obj.toJSONString().getBytes());
    }

    public static Object jsonFileReader(String f) throws Exception{
        FileReader r = new FileReader(f);
        JSONParser jParse = new JSONParser();
        return jParse.parse(r);
    }
}
