public class LeetCode2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] e1 = new int[2], e2 = new int[2];
        for (int i = 0; i < 2; i++) {
            e1[i] = Integer.valueOf(event1[i].substring(0, 2) + event1[i].substring(3));
            e2[i] = Integer.valueOf(event2[i].substring(0, 2) + event2[i].substring(3));
        }
        return (e1[0] >= e2[0] && e1[0] <= e2[1]) || (e1[1] >= e2[0] && e1[1] <= e2[1]) || (e2[0] >= e1[0] && e2[0] <= e1[1]) || (e2[1] >= e1[0] && e2[1] <= e1[1]);
    }
}
