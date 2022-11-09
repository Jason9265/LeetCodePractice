public class LeetCode1323 {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                return Integer.valueOf(s.substring(0, i) + '9' + s.substring(i + 1));
            }
        }
        return num;
    }
}
