package S807_Max_Increase_to_Keep_City_Skyline;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int heightSum = 0;
        int[] leftRightView = new int[grid.length];
        int[] topBottomView = new int[grid[0].length];
        int[][] increaseGrid = new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] > leftRightView[i]) {
                    leftRightView[i] = grid[i][j];
                }
                if(grid[i][j] > topBottomView[j]) {
                    topBottomView[j] = grid[i][j];
                }
            }

        }

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                int maxHeight = leftRightView[i]<topBottomView[j]?leftRightView[i]:topBottomView[j];
                heightSum += (maxHeight - grid[i][j]);
            }
        }

        return heightSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        s.maxIncreaseKeepingSkyline(grid);
    }
}
