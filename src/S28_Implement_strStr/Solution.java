package S28_Implement_strStr;

public class Solution {
    // brute implements
//    public int strStr(String haystack, String needle) {
//
//        char[] haystackCharArray = haystack.toCharArray();
//        char[] needleCharArray = needle.toCharArray();
//
//        if (needle.equals("")) {
//            return 0;
//        }
//
//        for(int i=0; i<haystackCharArray.length; i++) {
//            if (haystackCharArray[i] == needleCharArray[0]) {
//                int j=0;
//                while((j+i)<haystackCharArray.length && j<needleCharArray.length) {
////                    System.out.println("i = " + i + ", j = " + j);
//                    if (haystackCharArray[i+j] != needleCharArray[j]) {
//                        break;
//                    }
//                    j++;
//                }
//                if (j == needleCharArray.length) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int[] next = getNextArray(needle);

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            } else {
                i = next[j];
                j = 0;
            }
        }

        if (j >= needle.length()) {
            return i - needle.length();
        } else {
            return -1;
        }
    }

    public int[] getNextArray(String subString) {
        int[] next = new int[subString.length()];
        next[0] = 0;
        int j = 0, k = 0;

        while (j < subString.length() - 1) {
            if (k == 0 || subString.charAt(j) == subString.charAt(k)) {
                k ++;
                j ++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        Solution s = new Solution();
        int r = s.strStr(haystack, needle);
        System.out.print(r);

    }
}
