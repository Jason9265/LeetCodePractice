public class LeetCode2129 {
    public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        String ans = "";
        for (String s : arr) {
            s = s.toLowerCase();
            if (s.length() > 2) {
                s = s.substring(0, 1).toUpperCase() + s.substring(1);
            }
            ans += " " + s;
        }
        return ans.substring(1);
    }
}
