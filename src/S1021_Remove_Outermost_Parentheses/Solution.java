package S1021_Remove_Outermost_Parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String S) {    // time complexity O(n), space complexity O(n)
        Stack<Character> stack = new Stack<>();
        String newS = "";
        List<Integer> indexS = new ArrayList<>();

        for(int i=0; i<S.length(); i++) {
            if (stack.empty()) {
                indexS.add(i);
            }
            if (S.charAt(i) == '(') {
                stack.push('(');
            }
            if (S.charAt(i) == ')') {
                stack.pop();
            }
            if (stack.empty()) {
                indexS.add(i);
            }
        }

        for (int i=0; i<S.length(); i++) {
            if (indexS.contains(i)) {
                continue;
            }
            newS += S.charAt(i);
        }

        return newS;
    }

    public static void main(String[] args) {
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";
        String s4 = "((()))";

        Solution s = new Solution();
        System.out.println(s.removeOuterParentheses(s2));

    }
}
