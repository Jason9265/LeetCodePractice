public class LeetCode1544 {
    //    15mins
    public String makeGood(String s) {
        boolean f = true;
        while (f) {
            f = false;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1) + 32 || s.charAt(i) == s.charAt(i + 1) - 32) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    i--;
                    f = true;
                }
            }
        }
        return s;
    }
}
