public class LeetCode1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
