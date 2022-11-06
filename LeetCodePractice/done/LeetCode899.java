import java.util.Arrays;

public class LeetCode899 {
    //
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String str = s + s;
            String tempAns = s;
            for (int i = 0; i < s.length(); i++) {
                String temp = str.substring(i, i + s.length());
                if (temp.compareTo(tempAns) <0) {
                    tempAns = temp;
                }
            }
            return tempAns;
        } else {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }
}
