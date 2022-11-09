public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
// 28m
        for (int i = 0; i < temperatures.length; i++) {
            if (i > 0 && temperatures[i] == -1) {
                temperatures[i] = temperatures[i - 1] - 1;
            } else {
                int temp = 0, k = i + 1;
                boolean f = true, f1 = true;
                while (k < temperatures.length) {
                    temp++;
                    if (temperatures[k] > temperatures[i]) {
                        f = false;
                        break;
                    }
                    if (temperatures[k] == temperatures[i] && f1) {
                        temperatures[k] = -1;
                    } else {
                        f1 = false;
                    }
                    k++;
                }
                temperatures[i] = temp;
                if (f) {
                    temperatures[i] = 0;
                }
            }
            if (temperatures[i] < 0) {
                temperatures[i] = 0;
            }
        }
        return temperatures;
    }
}
