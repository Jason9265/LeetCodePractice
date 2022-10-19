import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        List<List<Integer>> pacific = new ArrayList<>();
        List<List<Integer>> atlantic = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(0);
            pacific.add(temp);
        }
        for (int j = 1; j < col; j++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(j);
            pacific.add(temp);
        }
        for (int i = 0; i < pacific.size(); i++) {
            int r = pacific.get(i).get(0), c = pacific.get(i).get(1);
            searchHill(heights, pacific, row, col, r, c);
        }
        // atlantic
        for (int i = 0; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(col - 1);
            atlantic.add(temp);
        }
        for (int j = 0; j < col - 1; j++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(row - 1);
            temp.add(j);
            atlantic.add(temp);
        }
        for (int i = 0; i < atlantic.size(); i++) {
            int r = atlantic.get(i).get(0), c = atlantic.get(i).get(1);
            searchHill(heights, atlantic, row, col, r, c);
        }

        pacific.retainAll(atlantic);
        return pacific;
    }

    private void searchHill(int[][] heights, List<List<Integer>> pacific, int row, int col, int r, int c) {

        if (r < row - 1 && heights[r + 1][c] >= heights[r][c]) {
            List<Integer> temp = new ArrayList<>();
            temp.add(r + 1);
            temp.add(c);
            if (!pacific.contains(temp)) {
                pacific.add(temp);
            }
        }
        if (c < col - 1 && heights[r][c + 1] >= heights[r][c]) {
            List<Integer> temp = new ArrayList<>();
            temp.add(r);
            temp.add(c + 1);
            if (!pacific.contains(temp)) {
                pacific.add(temp);
            }
        }
        if (r > 0 && heights[r - 1][c] >= heights[r][c]) {
            List<Integer> temp = new ArrayList<>();
            temp.add(r - 1);
            temp.add(c);
            if (!pacific.contains(temp)) {
                pacific.add(temp);
            }
        }
        if (c > 0 && heights[r][c - 1] >= heights[r][c]) {
            List<Integer> temp = new ArrayList<>();
            temp.add(r);
            temp.add(c - 1);
            if (!pacific.contains(temp)) {
                pacific.add(temp);
            }
        }
    }
}
