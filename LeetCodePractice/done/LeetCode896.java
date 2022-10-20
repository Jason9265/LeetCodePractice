public class LeetCode896 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return true;
        }
        if (nums[i] > nums[i - 1]) {
            while (i < nums.length) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
                i++;
            }
        } else {
            while (i < nums.length) {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
