package S100_Same_Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    boolean flag = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {

        try {
            if (p == null && q == null) {
                return true;
            }

            this.flag = isSameTree(p.left, q.left);


            if (p.val != q.val || p.left != q.left || q.left != q.right) {
                this.flag = false;
            }

            this.flag = isSameTree(p.right, q.right);
        } catch (NullPointerException e) {
            this.flag = false;
        }


        return this.flag;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        TreeNode p = new TreeNode(1, new TreeNode(2), null);
//        TreeNode q = new TreeNode(1, null, new TreeNode(2));

        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        System.out.print(s.isSameTree(p, q));

    }
}