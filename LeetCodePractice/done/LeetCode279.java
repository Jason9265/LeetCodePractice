import java.util.*;

public class LeetCode279 {
    List<Integer> arr = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        if (arr.size() == 0) {
            c1();
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() && arr.get(i) <= n; i++) {
            int tempans = c2(n, i);
            ans = Math.min(ans, tempans);
        }
        map.put(n, ans);
        return ans;
    }

    private void c1() {
        int i = 1, j = 0;
        while (j < 10000) {
            j = (int) Math.pow(i, 2);
            arr.add(j);
            i++;
        }
    }

    private int c2(int n, int i) {
        int a = n / arr.get(i);
        while (a <= 0) {
            i--;
            a = n / arr.get(i);
        }
        n %= arr.get(i);
        if (n == 0) {
            return a;
        }
        return a + numSquares(n);
    }
}
