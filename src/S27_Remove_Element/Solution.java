package S27_Remove_Element;

import java.util.Arrays;

public class Solution {
    //import java.util.ArrayList;
//import java.util.List;
//
//public class Solution_27_Remove_Element {
//
//	public static int removeElement(int[] nums, int val) {
//
//		int newLength = nums.length;
//		List<int> list = new ArrayList<int>();
//
//		for(int i=0; i<nums.length; i++){
//			if(nums[i] != val){
//				list.add(nums[i]);
//			}
//		}
//		nums = (Integer[])list.toArray();
//
//	        return newLength;
//	}
//
//	public static void main(String[] args){
//
////		int[] nums = {3,2,2,3};		//val = 3, length = 2
//		int[] nums = {0,1,2,2,3,0,4,2};		//val = 2, length = 5
//		System.out.println(removeElement(nums, 2));
//	}
//
////}
//    public int removeElement(int[] nums, int val) {
//        String numsStr = Arrays.toString(nums);
//        numsStr = numsStr.replace("[", "");
//        numsStr = numsStr.replace("]", "");
//        String[] numsStrSplit = numsStr.split(", ");
//        System.out.println(numsStr);
//        for (String s: numsStrSplit) {
//            System.out.println(s);
//
//        }
//        return 1;
//    }

    public int removeElement(int[] nums, int val) {
        int ceilPtr = nums.length - 1;
        int i = 0;
        while(i < nums.length && ceilPtr >= i) {
            if (nums[i] == val) {
                int t = nums[i];
                nums[i] = nums[ceilPtr];
                nums[ceilPtr] = t;
                ceilPtr --;
            } else {
                i ++;
            }
        }
        return ceilPtr + 1;
    }

    public void printArray(int[] nums) {
        for (int n: nums) {
            System.out.print(n + "\t");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3};
        System.out.println(s.removeElement(nums, 3));
        s.printArray(nums);
    }

}
