package S387_First_Unique_Character_in_a_String;

public class Solution {
    public static int  firstUniqChar(String s) {
        char s_char[] = s.toCharArray();
        int count[] = new int[200];
        for(int n:count){
            n = 0;
        }
        for(char c:s_char){
            int i = (int)c;
            count[i]++;
        }
        int res =0;
        for(int i=0;i<s_char.length;i++){
            for(int j=0;j<200;j++){
                res = j;
                char c = (char)res;
                if(s_char[i] == c&& count[j] == 1){
                    for(int k=0;k<s_char.length;k++){
                        if(s_char[i] == c){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]){
        String s = "leetcode";
//		 System.out.println("firstUniqChar(s) --> "+firstUniqChar(s));
        int x = firstUniqChar(s);
        System.out.println(x);

    }
}
