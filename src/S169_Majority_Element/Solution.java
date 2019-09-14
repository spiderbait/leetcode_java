package S169_Majority_Element;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//	public static int majorityElement(int[] nums) {
//        int count_pos[] = new int [1000];
//        int count_neg[] = new int [1000];
//        int res = 0;
//        for(int c:count_pos){
//        	c = 0;
//        }
//        for(int c:count_neg){
//        	c = 0;
//        }
//        for(int i=0;i<nums.length;i++){
//        	if(nums[i] >= 0){
//        		count_pos[nums[i]] ++;
//            	if(count_pos[nums[i]] >= (nums.length / 2)){
//            		res = nums[i];
//            	}
//        	}else{
//        		int t = -nums[i];
//        		count_neg[t] ++;
//            	if(count_neg[t] >= (nums.length / 2)){
//            		res = nums[i];
//            	}
//        	}
//        }
//
//        return res;
//    }

//
//	public static int majorityElement(int[] nums) {
//       List<Integer> list = new ArrayList<Integer>();
//       for(int i=0;i<nums.length;i++){
//    	   list.add(nums[i]);
//       }
//       for(int i=0;i<nums.length;i++){
//    	   int count = 0;
//    	   if(list.contains(nums[i])){
//    		   count ++;
//    	   }
//       }
//
//    }

    public static int majorityElement(int[] num) {
        int main = num[0]; // 用于记录主元素，假设第一个是主元素
        int count = 1; // 用于抵消数的个数

        for (int i = 1; i < num.length; i++) { // 从第二个元素开始到最后一个元素
            if (main == num[i]) { // 如果两个数相同就不能抵消
                count++; // 用于抵消的数据加1
            } else {
                if (count > 0) { // 如果不相同，并且有可以抵消的数
                    count--; // 进行数据抵消
                } else { // 如果不相同，并且没有可以抵消的数
                    main = num[i]; // 记录最后不可以抵消的数
                }
            }
        }
        return main;
    }

    public static void main(String[] args){
        int nums[] = {1,2,0,0,9,2,9,9,9,9};
        System.out.println(majorityElement(nums));
    }
}
