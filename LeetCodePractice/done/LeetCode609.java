import java.util.*;

public class LeetCode609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String s : paths) {
            String[] sa = s.split(" ");
            for (int i = 1; i < sa.length; i++) {
                String content = sa[i].substring(sa[i].indexOf("(") + 1, sa[i].length() - 1);
                if (!hm.containsKey(content)) {
                    hm.put(content, new LinkedList<>());
                }
                hm.get(content).add(sa[0] + "/" + sa[i].substring(0, sa[i].indexOf("(")));
            }
        }

        List<List<String>> ans = new LinkedList<>();

        for (List<String> l : hm.values()) {
            if (l.size() > 1) {
                ans.add(l);
            }
        }

        return ans;
    }
}
