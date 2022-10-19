public class LeetCode2210 {
    public int countHillValley(int[] nums) {
        int len = nums.length, i = 1, upnum = 0, downnum = 0, flag = 0;
        if (nums[1] > nums[0]) {
            upnum++;
            flag = 1;
        } else if (nums[1] < nums[0]) {
            downnum++;
            flag = -1;
        } else {
            while (i < len && nums[i] == nums[i - 1]) {
                i++;
            }
            flag = 0;
            if (i >= len - 1) {
                return 0;
            }
        }
        while (i < len) {
            if (nums[i] > nums[i - 1]) {
                if (flag != 1) {
                    upnum++;
                }
                flag = 1;
            }
            if (nums[i] < nums[i - 1]) {
                if (flag != -1) {
                    downnum++;
                }
                flag = -1;
            }
            i++;
        }
        return upnum + downnum - 1;
    }
}
