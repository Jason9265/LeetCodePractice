import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode2197 {
    //
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < list.size() - 1; i++) {
            if (1 != calNum(list.get(i), list.get(i + 1))) {
                int newInt = lcm(list.get(i), list.get(i + 1));
                if (newInt == list.get(i)) {
                    list.remove(i + 1);
                } else {
                    list.remove(i);
                    list.remove(i);
                    list.add(i, newInt);
                }
                int j = i - 1;
                while (j >= 0 && 1 != calNum(list.get(i), list.get(j))) {
                    int tempInt = lcm(list.get(i), list.get(j));
                    list.remove(j);
                    list.remove(j);
                    list.add(j, tempInt);
                    j--;
                    i--;
                }
                i--;

            }
        }
        return list;
    }

    private int lcm(int a, int b) {
        int c = calNum(a, b);
        return (a / c) * b;
    }

    private int calNum(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        int max = Math.max(a, b), min = Math.min(a, b);
        return calNum(max % min, min);
    }
}
