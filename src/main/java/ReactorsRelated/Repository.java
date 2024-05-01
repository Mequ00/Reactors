package ReactorsRelated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    Map<String, List<Reactor>> map = new HashMap<>();

    public void addToMap(String key, List<Reactor> reactors) {
        map.put(key, reactors);
    }

    public Map<String, List<Reactor>> getMap() {
        return map;
    }
}
