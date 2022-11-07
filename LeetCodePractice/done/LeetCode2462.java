import java.util.*;
import java.util.stream.Collectors;

public class LeetCode2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        long c = 0;
        List<Integer> l = Arrays.stream(costs).boxed().collect(Collectors.toList());
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(l);
        if (set.size() == 1) {
            return (long) k * costs[0];
        }
        int leng = costs.length;
        for (int i = 0; i < candidates; i++) {
            l1.add(costs[i]);
            l2.add(costs[leng - candidates + i]);
        }
        List<Integer> o1 = new ArrayList<>();
        List<Integer> o2 = new ArrayList<>();
        o1.addAll(l1);
        o2.addAll(l2);
        Collections.sort(o1);
        Collections.sort(o2);
        int t = leng - 2 * candidates;
        for (int r = 0; r < k; r++) {
            if (t >= 0) {
                int i1 = o1.get(0);
                int i2 = o2.get(0);
                if (i1 <= i2) {
                    c += i1;
                    int ti = l1.indexOf(i1);
                    l.remove(ti);
                    l1.remove(ti);
                    l1.add(l.get(candidates - 1));
                    o1.remove(0);
                    addOne(o1, l.get(candidates - 1));
                } else {
                    c += i2;
                    int ti = l2.indexOf(i2);
                    l.remove(l.size() - candidates + ti);
                    l2.remove(ti);
                    l2.add(0, l.get(l.size() - candidates));
                    o2.remove(0);
                    addOne(o2, l.get(l.size() - candidates));
                }
                t--;
            } else {
                Collections.sort(l);
                for (int j = 0; j < k - r; j++) {
                    c += l.get(j);
                }
                break;
            }
        }
        return c;
    }

    public void addOne(List<Integer> o, int k) {
        if (o.isEmpty()) {
            o.add(k);
            return;
        }
        int l = 0, r = o.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
//            System.out.println(l + ":" + m + ":" + r + "   " + o.get(m));
            if (o.get(m) > k) {
                r = m - 1;
            } else if (o.get(m) < k) {
                l = m + 1;
            } else {
                o.add(m, k);
                return;
            }
        }
        if (l >= o.size()) {
            o.add(k);
            return;
        }

        o.add(l, k);
    }
}
