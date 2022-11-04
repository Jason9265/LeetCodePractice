import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode1239 {
    // 1h

    int max = 0;

    public int maxLength(List<String> arr) {
        addNext(arr, new ArrayList<>(), 0, 0);
        return max;
    }

    private void addNext(List<String> arr, List<Integer> arr1, int index, int sumL) {
        for (int i = index; i < arr.size(); i++) {
            if (!checkOneString(arr.get(i))) {
                if (!checkArr(arr, arr1, i)) {
                    arr1.add(i);
                    sumL += arr.get(i).length();
                    max = Math.max(max, sumL);
                    addNext(arr, arr1, i + 1, sumL);
                    arr1.remove(arr1.size() - 1);
                    sumL -= arr.get(i).length();
                }
            }
        }
    }

    private boolean checkArr(List<String> arr, List<Integer> arr1, int index) {
        if (arr1.isEmpty()) {
            return false;
        }
        for (Integer i : arr1) {
            if (checkString(arr.get(i), arr.get(index))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOneString(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (q.contains(s.charAt(i))) {
                return true;
            } else {
                q.add(s.charAt(i));
            }
        }
        return false;
    }

    private boolean checkString(String a, String b) {
        for (int i = 0; i < b.length(); i++) {
            if (a.contains(b.substring(i, i + 1))) {
                return true;
            }
        }
        return false;
    }


}
