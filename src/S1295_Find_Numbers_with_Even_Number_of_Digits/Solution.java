package S1295_Find_Numbers_with_Even_Number_of_Digits;

public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n: nums) {
            int nLen = String.valueOf(n).length();
            if (nLen % 2 == 0) {
                count ++;
            }
        }
        return count;
    }
}
