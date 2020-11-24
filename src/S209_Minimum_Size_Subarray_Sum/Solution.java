package S209_Minimum_Size_Subarray_Sum;

class Solution {


    // brute force
//    public int minSubArrayLen(int s, int[] nums) {
//        for (int l=0; l<nums.length; l++) {
//            for (int n=0; n<nums.length-l; n++) {
//                int sum = 0;
//                for (int i=n; i<=n+l; i++) {
//                    sum += nums[i];
//                }
//                if (sum >= s) {
//                    return l+1;
//                }
//            }
//        }
//        return 0;
//    }

    // some O(n) method
    public int minSubArrayLen(int s, int[] nums) {
        for (int l=0; l<nums.length; l++) {
            for (int n=0; n<nums.length-l; n++) {
                int sum = 0;
                for (int i=n; i<=n+l; i++) {
                    sum += nums[i];
                }
                if (sum >= s) {
                    return l+1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 2, 4, 3};
        int[] nums = {1, 2, 3, 4, 5};
        
        int sum = 12;
        Solution s = new Solution();
        int l = s.minSubArrayLen(sum, nums);
        System.out.println("l = " + l);
    }
}
