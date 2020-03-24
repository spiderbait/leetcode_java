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
        return 0;
    }

    public static void main(String[] args) {
        String haystack = "aaaa";
        String needle = "aaa";

        Solution s = new Solution();
//        int r = s.strStr(haystack, needle);
//        System.out.print(r);

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {

            }
        }
    }
}
