package S1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] allCount = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            int count = 0;
            for (int m: nums) {
                if (nums[i] > m) {
                    count ++;
                }
            }
            allCount[i] = count;
        }
        return allCount;
    }
}
