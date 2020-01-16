package S20_Valid_Parentheses;

import java.util.*;
import java.util.regex.Pattern;

public class Solution {
//    public boolean isValid(String s) {
//        Stack<Character> parenthesesStack = new Stack<>();
//        Stack<Character> squareBracketsStack = new Stack<>();
//        Stack<Character> bracesStack = new Stack<>();
//
//        for (char c: s.toCharArray()) {
//            switch (c) {
//                case '(': parenthesesStack.push('('); break;
//                case ')': if (parenthesesStack.isEmpty()) {
//                    return false;
//                } else {
//                    parenthesesStack.pop();
//                    break;
//                }
//                case '[': squareBracketsStack.push('['); break;
//                case ']': if (squareBracketsStack.isEmpty()) {
//                    return false;
//                } else {
//                    squareBracketsStack.pop();
//                    break;
//                }
//                case '{': bracesStack.push('{'); break;
//                case '}': if (bracesStack.isEmpty()) {
//                    return false;
//                } else {
//                    bracesStack.pop();
//                    break;
//                }
//            }
//        }
//        return true;
//    }
public boolean isValid(String s) {
    Stack<Character> matchingStack = new Stack<>();
   for (char c: s.toCharArray()) {
       switch (c) {
           case '(':
           case '[':
           case '{': matchingStack.push(c); break;
           case ')': if (matchingStack.isEmpty() || matchingStack.pop() != '(') {
               return false;
           } else {
               break;
           }
           case ']': if (matchingStack.isEmpty() || matchingStack.pop() != '[') {
               return false;
           } else {
               break;
           }
           case '}': if (matchingStack.isEmpty() || matchingStack.pop() != '{') {
               return false;
           } else {
               break;
           }
       }
   }
    return matchingStack.isEmpty();
}

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "[()]";
        System.out.println(s.isValid(str));
    }
}
