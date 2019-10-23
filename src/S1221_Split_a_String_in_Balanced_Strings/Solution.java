package S1221_Split_a_String_in_Balanced_Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int balancedStringSplit(String s) {
        int compensate = 0;
        int counter = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'L'){
                compensate ++;
            }
            if(s.charAt(i) == 'R') {
                compensate --;
            }
            if(compensate == 0) {
                counter ++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "LLLLRRRR";
        String s2 = "RLRRLLRLRL";
        String s3 = "RLLLLRRRLR";
        System.out.println(s.balancedStringSplit(s2));
    }
}
