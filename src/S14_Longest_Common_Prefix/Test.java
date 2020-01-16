package S14_Longest_Common_Prefix;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"aca","cba"};
        System.out.println(s.longestCommonPrefix(strs));
        System.out.println(s.getCommonPrefix("aca", "cba"));
    }
}
