import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database instance = null;
    private final Map<String, Integer> dataBase;

    private Database() {
        this.dataBase = new HashMap<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void add(String key, int value) {
        dataBase.put(key, value);
    }

    public int get(String key) {
        return dataBase.get(key);
    }
}
