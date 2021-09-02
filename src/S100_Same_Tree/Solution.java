package S100_Same_Tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

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



//    public boolean isSameTree(TreeNode p, TreeNode q) {
//
//
//        if (p == null && q == null) {
//            list.add(true);
//        }
//
//        list.add(isSameTree(p.left, q.left));
//
//        if (p.val != q.val) {
//            list.add(false);
//        }
//
//        isSameTree(p.right, q.right);
//
//        return this.flag;
//
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        List<String> pList = levelTraversal(p);
        List<String> qList = levelTraversal(q);

        if (pList.size() == qList.size()) {
            for (int i = 0; i < pList.size(); i++) {
                if (!pList.get(i).equals(qList.get(i))) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;

    }


    public void inOrderTraversal(TreeNode root, List<String> list) {

        if (root == null) {
            list.add("null");
        } else {
            if(!(root.left == null && root.right == null)) {
                if (root.left != null) {
                    inOrderTraversal(root.left, list);
                } else {
                    list.add("Lnull");
                }

                list.add(Integer.toString(root.val));

                if (root.right != null) {
                    inOrderTraversal(root.right, list);
                } else {
                    list.add("Rnull");
                }
            }
        }

    }

    public List<String> levelTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        while(queue.size() > 0) {
            TreeNode p = queue.poll();
            output.add(Integer.toString(p.val));
            if (p.left != null) {
                queue.add(p.left);
            } else {
                output.add("Lnull");
            }
            if (p.right != null) {
                queue.add(p.right);
            } else {
                output.add("Rnull");
            }
        }
        return output;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));

//        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
//        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(2));

//        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

//        TreeNode p = new TreeNode(0, new TreeNode(-5), null);
//        TreeNode q = new TreeNode(0, new TreeNode(-8), null);

//        TreeNode p = null;
//        TreeNode q = null;

//        TreeNode p = new TreeNode(1, new TreeNode(1), null);
//        TreeNode q = new TreeNode(1, null, new TreeNode(1));

//        TreeNode p = new TreeNode(5,
//                new TreeNode(4,
//                        null, new TreeNode(1,
//                        new TreeNode(2), null)),
//                new TreeNode(1,
//                        null, new TreeNode(4,
//                        new TreeNode(2), null)));
//        TreeNode q = new TreeNode(5,
//                new TreeNode(1,
//                        new TreeNode(4,
//                                null,
//                                new TreeNode(2)), null),
//                new TreeNode(4,
//                        new TreeNode(1,
//                                null,
//                                new TreeNode(2)), null));




        System.out.print(s.isSameTree(p, q));

//        List<String> list = s.levelTraversal(q);
//        s.inOrderTraversal(p, list);

//        for (String str: list) {
//            System.out.println(str);
//        }
    }
}