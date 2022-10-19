import java.util.*;

public class LeetCode1394 {
    public int findLucky(int[] arr) {
        int ans = -1;
        boolean flag = true;
        Arrays.sort(arr);
        List<int[]> ll = new ArrayList<>();
        for (int i : arr) {
            if (!ll.isEmpty() && ll.get(ll.size() - 1)[0] == i) {
                ll.get(ll.size() - 1)[1]++;
            } else {
                if (!ll.isEmpty() && ll.get(ll.size() - 1)[0] == ll.get(ll.size() - 1)[1]) {
                    ans = ll.get(ll.size() - 1)[0];
                    flag = false;
                }
                ll.add(new int[]{i, 1});
            }
        }

        if (!ll.isEmpty() && ll.get(ll.size() - 1)[0] == ll.get(ll.size() - 1)[1]) {
            ans = ll.get(ll.size() - 1)[0];
            flag = false;
        }

        if (flag) {
            ans = -1;
        }
        return ans;
    }
}
