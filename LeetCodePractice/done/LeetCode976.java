import java.util.Arrays;

public class LeetCode976 {
    public int largestPerimeter(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            for (int j = i - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[i] < nums[j] + nums[k]) {
                        return nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return 0;
    }
}
