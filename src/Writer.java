import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by root on 11/2/16.
 */
public class Writer {
    public void saveMapToJsonFile(Memory memory) {
        try {
            JSONObject obj = new JSONObject(memory.getMemoryMap());
            FileWriter file = new FileWriter("SLDbInstance.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
