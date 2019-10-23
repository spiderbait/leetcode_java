package S938_Range_Sum_of_BST;

import java.util.List;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        TreeNode p = root;
        int sum = 0;

        if(p != null) {
            sum += rangeSumBST(p.left, L, R);
            if(p.val >= L && p.val <= R) {
                sum += p.val;
            }
            sum += rangeSumBST(p.right, L, R);

        }
        return sum;
    }

    public void traverse(TreeNode root) {
        TreeNode p = root;
        if(p != null) {
            traverse(p.left);
            System.out.println(p.val);
            traverse(p.right);
        }
    }


    public static void main(String[] args) {
        //todo 1: non-recursion traverse implements
        //todo 2: array list to BTree implements

        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                null, null),
                        new TreeNode(7,
                                null, null)),
                new TreeNode(15,
                        null,
                        new TreeNode(18,
                                null, null)
                ));
        Solution s = new Solution();
        s.traverse(root);
        System.out.println(s.rangeSumBST(root, 7, 15));


    }
}
