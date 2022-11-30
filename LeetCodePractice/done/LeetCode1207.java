import java.util.*;

public class LeetCode1207 {
    // 10m
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(map.values());
        Set<Integer> set = new HashSet<>();
        set.addAll(map.values());
        if (list.size() != set.size()) {
            return false;
        }
        return true;
    }
}
