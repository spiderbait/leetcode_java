package S7_Reverse_Integer;

public class Solution {
    public static int reverse(int x) {
        int flag = 0;
        String x_str  = Integer.toString(x);
        String y_str = "";
        char[] x_char = x_str.toCharArray();
        if(x < 0){
            for(int i = x_str.length() - 1;i > 0;i--){
                y_str  += x_char[i];
            }
            flag = 1;
        }else{
            for(int i = x_str.length() - 1;i >= 0;i--){
                y_str  += x_char[i];
            }
        }
        double y_d = Double.parseDouble(y_str);
        if(y_d > Integer.MAX_VALUE){
            return 0;
        }
        int y = Integer.parseInt(y_str);
        if(flag == 1){
            y *= -1;
            flag = 0;
        }
        return y;
    }
    public static int advanceReverse(int x){
        String x_str = Integer.toString(x);
        char[] x_char = x_str.toCharArray();
        char t;
        int flag = 0;
        int i = 0;
        int j = x_str.length() - 1;
        if(x < 0){
            flag = 1;
            i = 1;
        }
        while(i!=j){
            if(i > j){
                break;
            }
            t = x_char[j];
            System.out.println("t --> "+t);
            x_char[j] = x_char[i];
            x_char[i] = t;
            i++;
            j--;
        }
        String y_str = "";//此处不要定义成null！！
        if(x < 0){
            i = 1;
        }
        for(;i < x_str.length();i++){
            y_str += x_char[i];
        }
        System.out.println(y_str);
        double y_d = Double.parseDouble(y_str);
        if(y_d > Integer.MAX_VALUE){
            return 0;
        }
        int y = Integer.parseInt(y_str);
        if(flag == 1){
            y *= -1;
            flag = 0;
        }
        return y;
    }
    public static void main(String args[]){
        int x = -214748364;
        long start = System.currentTimeMillis();
        int y = reverse(x);
        System.out.println(y);
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: "+(end - start));
        start = System.currentTimeMillis();
        System.out.println("advanceReverse(x) --> "+advanceReverse(x));
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: "+(end - start));
    }
}
