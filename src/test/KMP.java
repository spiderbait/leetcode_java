package test;

public class KMP {

    public int[] getNextArray(String subString) {
        int[] next = new int[subString.length()];
        for (int i=0; i<subString.length(); i++) {
            if (i == 0) {
                next[i] = 0;
            }
        }
        return next;
    }

    public int getMaxPrepostFix(String s) {
        int nextVal = 0;
        for (int i=1; i<s.length() - 1; i++) {
            nextVal = 0;
            for (int j=0; j<i; j++) {
                if (s.charAt(j) == s.charAt(s.length() - i + j)) {
                    nextVal ++;
                } else {
                    nextVal = 0;
                }
            }
        }
        return nextVal;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String s = "ABCCABC";
        System.out.println(kmp.getMaxPrepostFix(s));
    }
}
