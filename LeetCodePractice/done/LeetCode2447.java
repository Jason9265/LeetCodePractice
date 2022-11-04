import java.util.*;

public class LeetCode2447 {
    int stat = 0;

    public int subarrayGCD(int[] nums, int k) {
        int ans = 0, len = nums.length;
        List<Integer> list1 = new ArrayList<>();
        for (int i : nums) {
            list1.add(i);
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (stat == 2 && nums[j - 1] == k) {
                    ans++;
                } else {
                    stat = 0;
                    if (j == i + 1) {
                        if (nums[i] == k) {
                            ans++;
                        }
                    } else {
                        if (check(list1.subList(i, j), k)) {
                            stat = 2;
                            ans++;
                        }
                        if (stat == 1) {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(List<Integer> list1, int k) {
        Set<Integer> s = new HashSet<>();
        s.addAll(list1);
        List<Integer> l = new ArrayList<>();
        l.addAll(s);
        l.sort(Comparator.reverseOrder());
        if (l.size() == 1) {
            if (l.get(0) == k)
                return true;
            else if (l.get(0) < k) {
                stat = 1;
                return false;
            } else return false;
        }
        int a = l.get(0), b = l.get(1);
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        if (b < k) {
            stat = 1;
            return false;
        }
        if (l.size() > 2) {
            for (int i = 2; i < l.size(); i++) {
                a = b;
                b = l.get(i);
                if (b < k) {
                    stat = 1;
                    return false;
                }
                while (a % b != 0) {
                    int temp = a % b;
                    a = b;
                    b = temp;
                }
            }
        }
        if (b == k) {
//            System.out.println(list1);
            return true;
        }
        return false;
    }

    public long makeSimilar(int[] nums, int[] target) {
        long ans = 0;
        return ans;
    }

    public long minCost(int[] nums, int[] cost) {
        long ans = Long.MAX_VALUE;
        long tempC;
        for (int i = 0; i < nums.length; i++) {
            tempC = 0;
            int tar = nums[i];
            for (int j = 0; j < nums.length; j++) {
                tempC += (long) Math.abs(nums[j] - tar) * (long) cost[j];
                if (tempC >= ans) {
                    break;
                }
            }
            ans = Math.min(ans, tempC);
        }
        return ans;
    }
}
