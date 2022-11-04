import java.util.*;

public class LeetCode345 {
    // 11m
    public String reverseVowels(String s) {
        String ans = "";
        Queue<Character> l1 = new LinkedList<>();
        Queue<Integer> l2 = new LinkedList<>();
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
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
                    s1.push(c);
                    break;
                default:
                    l1.add(c);
                    l2.add(i);
            }
        }
        for (int i = 0; i < s.length() && !l2.isEmpty(); i++) {
            if (l2.peek() == i) {
                ans += l1.poll();
                l2.poll();
            } else {
                ans += s1.pop();
            }
        }
        while (!s1.isEmpty()) {
            ans += s1.pop();
        }
        return ans;
    }
}
