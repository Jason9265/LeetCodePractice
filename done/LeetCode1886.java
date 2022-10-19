public class LeetCode1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int len = mat.length;
        int[][] copyMat = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                copyMat[i][j] = mat[i][j];
            }
        }
        if (checkMatrix(target, copyMat, len)) {
            return true;
        }
        rotate(copyMat);
        if (checkMatrix(target, copyMat, len)) {
            return true;
        }
        rotate(copyMat);
        if (checkMatrix(target, copyMat, len)) {
            return true;
        }
        rotate(copyMat);
        if (checkMatrix(target, copyMat, len)) {
            return true;
        }

        return false;
    }

    private boolean checkMatrix(int[][] mat, int[][] target, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    private void rotate(int[][] matrix) {
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
