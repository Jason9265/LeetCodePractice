public class LeetCode1706 {
//    30mins
    public int[] findBall(int[][] grid) {
        int len = grid.length, width = grid[0].length;
        int[] ans = new int[width];
        for (int i = 0; i < width; i++) {
            ans[i] = -1;
        }
        for (int index = 0; index < width; index++) {
            int a = 0, b = index, pre = 0;
            while (b >= 0 && b < width) {
                if (pre == 0) {
                    if (grid[a][b] == 1) {
                        b++;
                        pre = 1;
                    } else {
                        b--;
                        pre = -1;
                    }
                } else if (pre == 1) {
                    if (grid[a][b] == 1) {
                        a++;
                        pre = 0;
                    } else {
                        ans[index] = -1;
                        break;
                    }
                } else {
                    if (grid[a][b] == -1) {
                        a++;
                        pre = 0;
                    } else {
                        ans[index] = -1;
                        break;
                    }
                }
                if (a >= len) {
                    ans[index] = b;
                    break;
                }
            }
        }
        return ans;
    }
}
