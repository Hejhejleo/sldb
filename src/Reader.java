import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileReader;
import java.util.Map;

/**
 * Created by root on 11/2/16.
 */
public class Reader {
    public void readJsonToMap(Memory memory) {
        try {
            Map<String, String> map = (JSONObject) JSONValue.parse(new FileReader("SLDbInstance.json"));
            memory.setMemoryMap(map);
            System.out.println("Loaded the saved instance...");
            System.out.println("Displaying loaded data...");
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
