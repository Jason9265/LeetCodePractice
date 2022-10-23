import java.util.Arrays;

public class LeetCode645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[]{0, nums.length};
        Arrays.sort(nums);
        if (nums[0] != 1)
            ans[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans[0] = nums[i];
            }
            if (nums[i] > nums[i - 1] + 1) {
                ans[1] = nums[i] - 1;
            }
        }
        return ans;
    }
}
