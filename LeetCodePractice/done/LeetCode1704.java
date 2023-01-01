
public class LeetCode1704 {
    public boolean halvesAreAlike(String s) {
        int num = 0, i = 0;
        while (i < s.length() / 2) {
            if (checkC(s.charAt(i))) {
                num++;
            }
            i++;
        }
        while (i < s.length()) {
            if (checkC(s.charAt(i))) {
                num--;
            }
            i++;
        }
        if (num == 0)
            return true;
        return false;
    }

    private boolean checkC(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

}
