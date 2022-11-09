import java.util.ArrayList;
import java.util.List;

public class LeetCode901 {
//    10mins
    List<Integer> list;

    public LeetCode901() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int temp = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > price) {
                break;
            } else {
                temp++;
            }
        }
        return temp;
    }
}
