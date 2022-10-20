public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int nu = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nu--;
            }
        }
        int left = 0, right = nums.length - 1;
        while (left < nu) {
            if (nums[left] == val) {
                while (nums[right] == val) {
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            left++;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
        return nu;
    }
}
