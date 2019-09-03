package S13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static final Map<Character, Integer> ROM2INT_MAP = new HashMap<Character, Integer>();
    {
        ROM2INT_MAP.put('I', 1);
        ROM2INT_MAP.put('V', 5);
        ROM2INT_MAP.put('X', 10);
        ROM2INT_MAP.put('L', 50);
        ROM2INT_MAP.put('C', 100);
        ROM2INT_MAP.put('D', 500);
        ROM2INT_MAP.put('M', 1000);
    }

    public static final Map<Character, Integer> ROMAN_WEIGHT = new HashMap<Character, Integer>();
    {
        ROMAN_WEIGHT.put('I', 1);
        ROMAN_WEIGHT.put('V', 2);
        ROMAN_WEIGHT.put('X', 3);
        ROMAN_WEIGHT.put('L', 4);
        ROMAN_WEIGHT.put('C', 5);
        ROMAN_WEIGHT.put('D', 6);
        ROMAN_WEIGHT.put('M', 7);
    }


    public String getStrWeight(String s) {

        String sWeight = "";

        for (int i = 0; i < s.length(); i++){
            sWeight += ROMAN_WEIGHT.get(s.charAt(i)).toString();
        }

        System.out.println(sWeight);

        return sWeight;
    }

    public int romanToInt(String s) {

        int rst = 0;

        if (s.length() == 1){
            return ROM2INT_MAP.get(s.charAt(0));
        }

        for (int i = 0; i < s.length() - 1; i++){
            System.out.println("i = " + i);

            if (ROMAN_WEIGHT.get(s.charAt(i)) < ROMAN_WEIGHT.get(s.charAt(i + 1))){
                System.out.println("if");
                rst += (ROM2INT_MAP.get(s.charAt(i + 1)) - ROM2INT_MAP.get(s.charAt(i)));
                i ++;
                if((i + 1) == s.length() - 1){
                    rst += ROM2INT_MAP.get(s.charAt(i + 1));
                }
            }else{
                if (i == s.length() - 2){
                    rst += ROM2INT_MAP.get(s.charAt(i + 1));
                    rst += ROM2INT_MAP.get(s.charAt(i));
                }else{
                    System.out.println("else");
                    rst += ROM2INT_MAP.get(s.charAt(i));
                }
            }

        }

        return rst;
    }
    public int romanToIntEasy(String s) {
        int len = s.length(), result = ROM2INT_MAP.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (ROM2INT_MAP.get(s.charAt(i)) >= ROM2INT_MAP.get(s.charAt(i + 1)))
                result += ROM2INT_MAP.get(s.charAt(i));
            else
                result -= ROM2INT_MAP.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args){

        Solution s = new Solution();

//		 String s = "III";
//		 String s = "IV";
//		 String s = "IX";
//		 String s = "LVIII";
//		 String s = "MCMXCIV";
//		 String s = "MDCXCV";		//1695
        String romanStr = "D";

        s.getStrWeight(romanStr);

        System.out.println(s.romanToIntEasy(romanStr));


    }
}
