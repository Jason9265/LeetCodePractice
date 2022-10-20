import java.util.Arrays;

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        // 二分查找
        int len = nums.length, left = 0, right = len, middle = (left + right) / 2;
        while (left + 1 != right) {
            if (nums[middle] < 1) {
                left = middle;
                if (middle == (left + right) / 2) {
                    break;
                }
            } else {
                right = middle;
            }
            middle = (left + right) / 2;
        }
        if (nums[middle] > 1) {
            return 1;
        }
        if (middle == len - 1) {
            if (nums[middle] == 1) {
                return 2;
            } else {
                return 1;
            }
        }

        if (nums[middle] < 1)
            nums[middle] = 0;
        for (int i = middle; i < len - 1; i++) {
            if (nums[i + 1] != nums[i] && nums[i + 1] != nums[i] + 1) {
                return nums[i] + 1;
            }
        }

        return nums[len - 1] + 1;
    }
}
