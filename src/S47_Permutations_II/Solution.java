package S47_Permutations_II;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> rs = new ArrayList<>();

        int[] register = new int[nums.length];
        int[][] numsMatrix = new int[nums.length][nums.length];

        Arrays.fill(numsMatrix, nums);
        Arrays.fill(register, 0);

        boolean isBreak = false;

        while (true) {
            List<Integer> eachPermute = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                eachPermute.add(numsMatrix[i][register[i]]);
            }

            register[register.length - 1] += 1;

            for (int i = register.length - 1; i > 0; i--) {
                if (register[i] == register.length) {
                    register[i] = 0;
                    register[i - 1] += 1;
                }
                if (register[0] == register.length) {
                    isBreak = true;
                }
            }

            if (isBreak) {
                break;
            }

            System.out.print(Arrays.toString(eachPermute.toArray()));
            if (!rs.contains(eachPermute)) {
                System.out.print("NO CONTAINS, ADDED!");
                rs.add(eachPermute);
            }
        }


        return rs;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n = {1,1,2};
        List<List<Integer>> rs = s.permuteUnique(n);
        for (List<Integer> q: rs) {
            System.out.print(Arrays.toString(q.toArray()));
        }
    }
}
