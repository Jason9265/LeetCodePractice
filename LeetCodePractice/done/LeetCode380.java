import java.util.*;

public class LeetCode380 {
    Map<Integer, Integer> hm;
    Stack<Integer> st;
    Random r;

    public LeetCode380() {
        hm = new HashMap<>();
        st = new Stack<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        }
        hm.put(val, st.size());
        st.push(val);
        return true;
    }


    public boolean remove(int val) {
        if (hm.containsKey(val)) {
            int temp = st.peek();
            int pos = hm.get(val);
            hm.replace(temp, pos);
            st.set(pos, temp);
            st.pop();
            hm.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return st.get(r.nextInt(st.size()));
    }

}
