import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1329 {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length, col = mat[0].length, diagonal = row + col - 1;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            List<Integer> temp_list = new ArrayList<>();
            for (int j = 0, k = i; j < col && k < row; j++, k++) {
                temp_list.add(mat[k][j]);
            }
            int[] temp_arr = temp_list.stream().mapToInt(Integer::valueOf).toArray();
            Arrays.sort(temp_arr);
            for (int j = 0, k = i; j < col && k < row; j++, k++) {
                ans[k][j] = temp_arr[j];
            }
        }
        for (int i = 1; i < col; i++) {
            List<Integer> temp_list = new ArrayList<>();
            for (int j = 0, k = i; j < row && k < col; j++, k++) {
                temp_list.add(mat[j][k]);
            }
            int[] temp_arr = temp_list.stream().mapToInt(Integer::valueOf).toArray();
            Arrays.sort(temp_arr);
            for (int j = 0, k = i; j < row && k < col; j++, k++) {
                ans[j][k] = temp_arr[j];
            }

        }
        return ans;
    }
}
