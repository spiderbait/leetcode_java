package S7_Reverse_Integer;

import java.util.Arrays;

public class Solution {
//    public int reverse(int x) {
//        int flag = 0;
//        String x_str  = Integer.toString(x);
//        String y_str = "";
//        char[] x_char = x_str.toCharArray();
//        if(x < 0){
//            for(int i = x_str.length() - 1;i > 0;i--){
//                y_str  += x_char[i];
//            }
//            flag = 1;
//        }else{
//            for(int i = x_str.length() - 1;i >= 0;i--){
//                y_str  += x_char[i];
//            }
//        }
//        double y_d = Double.parseDouble(y_str);
//        if(y_d > Integer.MAX_VALUE){
//            return 0;
//        }
//        int y = Integer.parseInt(y_str);
//        if(flag == 1){
//            y *= -1;
//            flag = 0;
//        }
//        return y;
//    }
//    public static int advanceReverse(int x){
//        String x_str = Integer.toString(x);
//        char[] x_char = x_str.toCharArray();
//        char t;
//        int flag = 0;
//        int i = 0;
//        int j = x_str.length() - 1;
//        if(x < 0){
//            flag = 1;
//            i = 1;
//        }
//        while(i!=j){
//            if(i > j){
//                break;
//            }
//            t = x_char[j];
//            System.out.println("t --> "+t);
//            x_char[j] = x_char[i];
//            x_char[i] = t;
//            i++;
//            j--;
//        }
//        String y_str = "";//此处不要定义成null！！
//        if(x < 0){
//            i = 1;
//        }
//        for(;i < x_str.length();i++){
//            y_str += x_char[i];
//        }
//        System.out.println(y_str);
//        double y_d = Double.parseDouble(y_str);
//        if(y_d > Integer.MAX_VALUE){
//            return 0;
//        }
//        int y = Integer.parseInt(y_str);
//        if(flag == 1){
//            y *= -1;
//            flag = 0;
//        }
//        return y;
//    }

    public int reverse(int x) {

        try {
            boolean minusFlag = false;

            if (x < 0) {
                minusFlag = true;
                x = Math.abs(x);
            }

            char[] charArrayX = String.valueOf(x).toCharArray();
            int j = charArrayX.length - 1;
            char t = ' ';

            for (int i = 0; i < j; i++, j--) {
                t = charArrayX[i];
                charArrayX[i] = charArrayX[j];
                charArrayX[j] = t;
            }

            int reversedX = Integer.parseInt(new String(charArrayX));
            if (minusFlag) {
                return reversedX * -1;
            }

            return reversedX;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.reverse(1534236469));
    }
}
