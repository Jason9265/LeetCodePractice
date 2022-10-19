import java.util.*;

public class LeetCode2094 {
    public int[] findEvenNumbers(int[] digits) {
        int len = digits.length;
        Set<Integer> set = new HashSet<>(); // 排除重复

        for (int i = 0; i < len; i++) {
            if (digits[i] % 2 == 0) {
                for (int j = 0; j < len; j++) {
                    if (j != i && digits[j] != 0) {
                        for (int k = 0; k < len; k++) {
                            if (k != i && k != j) {
                                set.add(Integer.valueOf("" + digits[j] + digits[k] + digits[i]));
                            }
                        }
                    }
                }
            }
        }

        int[] ans = set.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ans);
        return ans;
    }
}
