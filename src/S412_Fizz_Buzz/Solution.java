package S412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> fizzBuzz(int n) {
        List<String> str_list = new ArrayList<String>();
        String str = null;
        for(int i=1;i<=n;i++){
            if((i%3 == 0 && i/3 > 0)  && (i%5 == 0 && i/5 > 0)){
                str = "FizzBizz";
                str_list.add(str);
            }else if(i%5 == 0){
                str = "Buzz";
                str_list.add(str);
            }else if(i%3 == 0){
                str = "Fizz";
                str_list.add(str);
            }else{
                str = Integer.toString(i);
                str_list.add(str);
            }
        }
        return str_list;
    }

    public static void main(String[] args){
//		int n = 15;
//		String[] str = fizzBuzz(n);
//		for(int i=0;i<str.length;i++){
//			System.out.println(str[i]);
//		}
    }
}
