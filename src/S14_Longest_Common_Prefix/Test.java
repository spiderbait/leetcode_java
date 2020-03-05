package S14_Longest_Common_Prefix;

public class Test{

    public String mergeStrings(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i=0; i < strs.length - 1; i ++) {
            strs[i + 1] = strs[i] + strs[i + 1];
        }
        return strs[strs.length - 1];
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"aca","cba"};
//        System.out.println(s.longestCommonPrefix(strs));
//        System.out.println(s.getCommonPrefix("aca", "cba"));
//        Test t = new Test();
//        String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno"};
//        String mergedStrs = t.mergeStrings(strs);
//        System.out.println(mergedStrs);
//        System.out.println(strs[strs.length - 1]);

        String[] alphabet = new String[]{"a", "b", "c", "d", "f"};
        String sum = "";
        for (String a: alphabet) {
            sum += a;
        }
        System.out.println(sum);

    }
}
