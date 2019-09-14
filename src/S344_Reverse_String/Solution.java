package S344_Reverse_String;

public class Solution {
//	public static String reverseString(String s) {
//        char[] s_char = s.toCharArray();
//        char t;
//        int i = 0;
//        int j = s_char.length - 1;
//        while(i != j){
//        	if(i > j){
//        		break;
//        	}
//        	t = s_char[i];
//        	s_char[i] = s_char[j];
//        	s_char[j] = t;
//        	i ++;
//        	j --;
//        }
//        String str = "";
//        for(int n=0;n<s_char.length;n++){
//        	str += s_char[n];
//        }
//        return str;
//    }

    public static String reverseString(String s) {
        char[] s_char = s.toCharArray();
        String str = "";
        for(int i = s_char.length - 1;i >= 0;i--){
            str += s_char[i];

        }

        return str;
    }

    public static void main(String[] args){
        String str = "Helloo";
        System.out.println(reverseString(str));

    }
}
