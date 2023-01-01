import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        String[] list1 = pattern.split("");
        String[] list2 = s.split(" ");
        if (list1.length != list2.length) return false;
        Map<String, String> map = new HashMap<>();
        map.put(list1[0], list2[0]);
        for (int i = 1; i < list1.length; i++) {
            if (map.containsKey(list1[i])) {
                if (!list2[i].equals(map.get(list1[i]))) return false;
            } else {
                if (map.containsValue(list2[i])) return false;
                map.put(list1[i], list2[i]);
            }
        }
        return true;
    }
}
