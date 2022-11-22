public class LeetCode503 {
    //    8m
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int j = i, k = i;
            ans[i] = -1;
            boolean flag = true;
            while (j < len) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    flag = false;
                    break;
                }
                j++;
            }
            if (flag) {
                j = 0;
                while (j < k) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        flag = false;
                        break;
                    }
                    j++;
                }
            }
        }
        return ans;
    }
}
