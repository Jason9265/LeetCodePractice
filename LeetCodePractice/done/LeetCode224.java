public class LeetCode224 {
    public int calculate(String s) {
        int ans = 0, i = 0;
        boolean addOrMinus = false;
        s = s.replaceAll(" ", "");
        if (s.charAt(0) == '-') {
            s = '0' + s;
        }
        if (s.charAt(0) == '(') {
            s = "0+" + s;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            i++;
        }
        ans = Integer.valueOf(s.substring(0, i));
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                int right = i + getNextBracket(s.substring(i));
                int temp = calculate(s.substring(i + 1, right));
                if (addOrMinus) {
                    ans += temp;
                } else {
                    ans -= temp;
                }
                i = right;
            }
            if (c == '+') {
                addOrMinus = true;
            }
            if (c == '-') {
                addOrMinus = false;
            }
            if (c >= '0' && c <= '9') {
                int l = i, j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                int temp = Integer.valueOf(s.substring(i, j));
                if (addOrMinus) {
                    ans += temp;
                } else {
                    ans -= temp;
                }
                i = j - 1;
            }
            i++;
        }
        return ans;
    }

    private int getNextBracket(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                left--;
            }
            if (left == 0) {
                return i;
            }
        }
        return 0;
    }
}
