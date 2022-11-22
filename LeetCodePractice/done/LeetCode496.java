public class LeetCode496 {
    // 5m
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            ans[i] = -1;
            while (j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    break;
                }
                j++;
            }
            while (j < nums2.length) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}
