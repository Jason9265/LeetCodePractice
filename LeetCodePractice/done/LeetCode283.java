public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            int numOfZ = 0;
            for (int i : nums) {
                if (i == 0)
                    numOfZ++;
            }
            for (int i = 0; i < nums.length - numOfZ; i++) {
                if (nums[i] == 0) {
                    int j = i + 1;
                    while (nums[j] == 0) {
                        j++;
                    }
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
