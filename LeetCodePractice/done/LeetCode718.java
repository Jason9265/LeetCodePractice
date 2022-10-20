public class LeetCode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[][] table1 = new int[l1][l2];

        table1[0][0] = countMax(nums1, nums2, 0, 0);
        for (int j = 1; j < l2; j++) {
            if (table1[0][j - 1] > l2 - j) {
                table1[0][j] = table1[0][j - 1];
            } else {
                int temp = countMax(nums1, nums2, 0, j);
                table1[0][j] = Math.max(table1[0][j - 1], temp);
            }
        }
        for (int i = 1; i < l1; i++) {
            if (table1[i - 1][0] > l1 - i) {
                table1[i][0] = table1[i - 1][0];
            } else
                table1[i][0] = Math.max(table1[i - 1][0], countMax(nums1, nums2, i, 0));
            for (int j = 1; j < l2; j++) {
                if (table1[i][j - 1] > l2 - j) {
                    table1[0][j] = table1[0][j - 1];
                } else if (table1[i - 1][0] > l1 - i) {
                    table1[i][0] = table1[i - 1][0];
                } else {
                    table1[i][j] = countMax(nums1, nums2, i, j);
                }
                table1[i][j] = Math.max(table1[i - 1][j], Math.max(table1[i][j - 1], table1[i][j]));
            }
        }
        return table1[l1 - 1][l2 - 1];
    }

    private int countMax(int[] nums1, int[] nums2, int a, int b) {
        int ans = 0;
        while (a < nums1.length && b < nums2.length && nums1[a] == nums2[b]) {
            ans++;
            a++;
            b++;
        }
        return ans;
    }
}
