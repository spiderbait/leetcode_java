package S217_Contains_Duplicate;

import java.util.Arrays;

public class Solution {
//	 public static boolean containsDuplicate(int[] nums) {
//	       int index[] = new int [10000];
//	       for(int i:index){
//	    	  i = 0;
//	       }
//	       for(int n:nums){
//	    	   index[n] ++;
//	       }
//	       for(int i:index){
//	    	   if(i > 1){
//	    		   return true;
//	    	   }
//	       }
//	       return false;
//	    }

//	public static boolean containsDuplicate(int[] nums) {
//	       for(int i=0;i<nums.length;i++){
//	    	   for(int j=i+1;j<nums.length;j++){
//	    		   if(nums[i] == nums[j]){
//	    			   return true;
//	    		   }
//	    	   }
//	       }
//	       return false;
//	    }

    //	public static boolean containsDuplicate(int[] nums) {
//		int i = 0;
//	      Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//	      for(int n:nums){
//	    	  if(map.containsValue(n)){
//	    		  return true;
//	    	  }else{
//	    		  map.put(i, n);
//	    		  i++;
//	    	  }
//	      }
//	      return false;
//	    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int nums[] = {2,3,5,1};
        System.out.println("containsDuplicate(nums) --> "+containsDuplicate(nums));
    }
}
