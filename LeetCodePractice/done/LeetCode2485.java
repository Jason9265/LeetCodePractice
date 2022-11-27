public class LeetCode2485 {
    public int pivotInteger(int n) {
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp += i;
        }
        int tempR = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (tempR == temp) {
                return i + 1;
            }
            tempR += i + 1;
            temp -= i;
        }
        return -1;
    }
}
