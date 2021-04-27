import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static final Map<String, String> direction = new HashMap<>();

    static {
        direction.put("N", "North");
        direction.put("E", "East");
        direction.put("W", "West");
        direction.put("S", "South");
    }
}
