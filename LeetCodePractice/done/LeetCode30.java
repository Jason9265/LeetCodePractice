import java.util.ArrayList;
import java.util.List;

public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int unitLeng = words[0].length(), totalLeng = unitLeng * words.length;
        List<String> l1 = new ArrayList<>();
        for (String s1 : words) {
            l1.add(s1);
        }
        for (int i = 0; i <= s.length() - totalLeng; i++) {
            List<String> l2 = new ArrayList<>();
            l2.addAll(l1);
            String temp = s.substring(i, i + totalLeng);
            while (temp.length() > 0) {
                String temp2 = temp.substring(0, unitLeng);
                if (l2.contains(temp2)) {
                    l2.remove(temp2);
                    temp = temp.substring(unitLeng);
                } else {
                    break;
                }
            }
            if (temp.length() == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
