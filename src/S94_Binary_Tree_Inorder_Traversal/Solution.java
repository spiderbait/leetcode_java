package S94_Binary_Tree_Inorder_Traversal;


import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> list;

    Solution() {
        this.list = new ArrayList<>();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = s.inorderTraversal(new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)));

        for (int i: list) {
            System.out.print(i);
        }

    }
}


