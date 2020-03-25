package test;

import java.util.Arrays;

public class KMP {

    public int[] getNextArray(String subString) {
        int[] next = new int[subString.length()];
        next[0] = -1;
        int j=0, k=-1;

        while (j < subString.length() - 1) {
            if (k == -1 || subString.charAt(j) == subString.charAt(k)) {
                k ++;
                j ++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int getMaxPrepostFixLength(String s) {
        int commonLength;
        int maxCommonLength = 0;

        for (int i=1; i<s.length() - 1; i++) {
            commonLength = 0;
            for (int j=0; j<i; j++) {
                if (s.charAt(j) == s.charAt(s.length() - i + j)) {
                    commonLength ++;
                }
            }
            System.out.println(commonLength);
            if (commonLength > maxCommonLength) {
                maxCommonLength = commonLength;
            }
        }
        return maxCommonLength;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String s = "ABCCABC";
        System.out.println(Arrays.toString(kmp.getNextArray(s)));
    }
}
