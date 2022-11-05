import java.lang.reflect.Array;
import java.util.*;

public class LeetCode49 {
    // 45mins
    List<String> lc = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for (String s : strs) {
            char[] tempChar = s.toCharArray();
            Arrays.sort(tempChar);
            String temps = String.valueOf(tempChar);
            if (ans.isEmpty()) {
                ans.add(new ArrayList<>());
                ans.get(0).add(s);
                lc.add(temps);
            } else {
                int index = -1;
                for (int i = 0; i < lc.size(); i++) {
                    if (lc.get(i).equals(temps)) {
                        index = i;
                        break;
                    }
                }
                if (index < 0) {
                    lc.add(temps);
                    ans.add(new ArrayList<>());
                    ans.get(ans.size() - 1).add(s);
                } else
                    ans.get(index).add(s);
            }
        }
        return ans;
    }
}

