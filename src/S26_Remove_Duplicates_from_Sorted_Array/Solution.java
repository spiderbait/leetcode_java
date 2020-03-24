package S26_Remove_Duplicates_from_Sorted_Array;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int lastNum = nums[0];
        int currentIndex = 1;
        for (int i=1; i<length; i++) {
            if (nums[i] != lastNum) {
                lastNum = nums[i];
                nums[currentIndex] = lastNum;
                currentIndex ++;
            }
        }
        return currentIndex;
    }

    public void printArray(int[] nums) {
        for (int n: nums) {
            System.out.print(n + "\t");
        }
    }

    public static void main(String[] args) {
        int[] case_1 = {1,1,2};
        int[] case_2 = {0,0,1,1,1,2,2,3,3,4};

        Solution s = new Solution();
        int r = s.removeDuplicates(case_2);
        System.out.println(r);
        s.printArray(case_2);

    }

}
