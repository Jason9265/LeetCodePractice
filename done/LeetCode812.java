public class LeetCode812 {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double max = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    max = Math.max(max, calculateTriangle(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return max;
    }

    private double calculateTriangle(int a1, int a2, int b1, int b2, int c1, int c2) {
        return Math.abs(((double) (a1 * b2 - a2 * b1) + (b1 * c2 - b2 * c1) + (c1 * a2 - c2 * a1)) / 2);
    }
}
