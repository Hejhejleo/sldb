import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 10/28/16.
 */
public class Memory {
    private Map<String, String> memoryMap = new HashMap<>();

    public Boolean iterateMemory(String keyword) {
        boolean flag = false;
            if (memoryMap.containsKey(keyword)){
                flag = true;
            }
        return flag;
    }

    public Map<String, String> getMemoryMap() {
        return memoryMap;
    }

    public void setMemoryMap(Map<String, String> memoryMap) {
        this.memoryMap = memoryMap;
    }
}
