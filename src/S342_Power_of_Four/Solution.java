package S342_Power_of_Four;

public class Solution {
//	 public static boolean isPowerOfFour(int num) {
//		 double d_1 = Math.sqrt(num);
////		 System.out.println(d_1);
//		 double d_2 = Math.sqrt(d_1);
////		 System.out.println(d_2);
//		 int i_2 = (int)d_2;
////		 System.out.println(d_2 - i_2);
//		 if((d_2 - i_2) == 0){
//			 return true;
//		 }
//		 return false;
//	 }

    public static boolean isPowerOfFour(int num) {
        double n = 0;
        n = Math.log(num) / Math.log(4);
        System.out.println(n);

        if(n - (int)n == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        System.out.println(isPowerOfFour(-2));
        Math.pow(16,1/4);
    }
}
