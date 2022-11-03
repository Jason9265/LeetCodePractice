import java.util.ArrayList;
import java.util.List;

public class LeetCode2131 {
    // 48mins
    public int longestPalindrome(String[] words) {
        int ans = 0, max = 0;
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (String s : words) {
            if (l1.contains(s)) {
                int x = l1.indexOf(s);
                l1.set(x, s);
                l2.set(x, l2.get(x) + 1);
            } else {
                l1.add(s);
                l2.add(1);
            }
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l2.get(i) != 0) {
                StringBuilder sb = new StringBuilder(l1.get(i));
                String tx = sb.reverse().toString();
                if (l1.contains(tx)) {
                    if (tx.equals(l1.get(i))) {
                        int n = l2.get(i) / 2;
                        l2.set(i, l2.get(i) - (n * 2));
                        ans += n * 2 * l1.get(i).length();
                    } else {
                        int t1 = l1.indexOf(tx);
                        int n = Math.min(l2.get(t1), l2.get(i));
                        l2.set(t1, l2.get(t1) - n);
                        l2.set(i, l2.get(i) - n);
                        ans += n * 2 * l1.get(i).length();
                    }
                }
            }
            if (l2.get(i) % 2 == 1 && check(l1.get(i))) {
                max = Math.max(max, l1.get(i).length());
            }
        }
        return ans + max;
    }

    private boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
