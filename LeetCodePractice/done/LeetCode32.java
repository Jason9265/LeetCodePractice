import java.util.Stack;

public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> s1 = new Stack<>();
        s1.push(-1);
        Stack<Character> q1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            s1.push(i);
            if (s.charAt(i) == '(') {
                q1.push('(');
            } else {
                if (!q1.isEmpty() && q1.peek() == '(') {
                    q1.pop();
                    s1.pop();
                    s1.pop();
                }
            }
        }
        s1.push(s.length());
        for (int i = 0; i < s1.size() - 1; i++) {
            ans = Math.max(ans, s1.get(i + 1) - s1.get(i));
        }
        return ans - 1;
    }
}
