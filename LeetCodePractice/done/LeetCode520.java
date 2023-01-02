public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) < 97) {
            if (word.length() > 1) {
                if (word.charAt(1) < 97) {
                    for (int i = 2; i < word.length(); i++) {
                        if (word.charAt(i) > 96) return false;
                    }
                } else {
                    for (int i = 2; i < word.length(); i++) {
                        if (word.charAt(i) < 97) return false;
                    }
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 97) return false;
            }
        }
        return true;
    }
}
