public class LeetCode2486 {
    public int appendCharacters(String s, String t) {
        char[] a1 = t.toCharArray();
        int i = 0, j = 0, len = a1.length;
        for (; s.length() > 0 && i < len; i++) {
            for (j = 0; j < s.length(); j++) {
                if (s.charAt(j) == a1[i]) {
                    break;
                }
            }
            if (j == s.length()) {
                return len - i;
            }
            s = s.substring(j + 1);
        }
        if (s.length() == 0) {
            return len - i;
        }
        return 0;
    }
}
