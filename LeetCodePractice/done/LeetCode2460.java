import java.util.ArrayList;
import java.util.List;

public class LeetCode2460 {
    public int[] applyOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    list.add(2 * nums[i]);
                    nums[i + 1] = 0;
                } else {
                    list.add(nums[i]);
                }
            }
        }
        if (nums[nums.length - 1] != 0) {
            list.add(nums[nums.length - 1]);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
