import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new Hashtable<>();
        map.put(s.charAt(0), t.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) return false;
            } else {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}
