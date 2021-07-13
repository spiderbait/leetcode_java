package S239_Sliding_Window_Maximum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param nums given integer array
     * @param k window size
     * @return result
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i <= nums.length - 1 - k; i ++) {
            int max = Integer.MIN_VALUE;
            for (int j=i; j < 3 ; j ++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            System.out.println(max);
            result.add(max);
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        s.maxSlidingWindow(nums, k);
    }
}
