public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length, halfr = len / 2, halfc = len / 2;
        if (len % 2 != 0) {
            halfc++;
        }
        int temp_1, temp_2, temp_3, temp_4;
        for (int i = 0; i < halfr; i++) {
            for (int j = 0; j < halfc; j++) {
                temp_1 = matrix[i][j];
                temp_2 = matrix[j][len - i - 1];
                temp_3 = matrix[len - i - 1][len - j - 1];
                temp_4 = matrix[len - j - 1][i];
                matrix[j][len - i - 1] = temp_1;
                matrix[len - i - 1][len - j - 1] = temp_2;
                matrix[len - j - 1][i] = temp_3;
                matrix[i][j] = temp_4;
            }
        }
    }
}
