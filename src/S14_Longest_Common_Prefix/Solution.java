package S14_Longest_Common_Prefix;

public class Solution {

    public String getCommonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i ++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String[] temp = strs;
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i + 1] = getCommonPrefix(temp[i], temp[i + 1]);
        }
        return temp[temp.length - 1];
    }
}
