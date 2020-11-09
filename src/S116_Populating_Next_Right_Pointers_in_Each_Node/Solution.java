package S116_Populating_Next_Right_Pointers_in_Each_Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

public class Solution {
    public Node connect(Node root) {

        return root;
    }

    public void traverse(Node root) {
        if (root != null) {
            System.out.println(root.val);
            if(root.left != null && root.right != null) {
                root.left.next = root.right;
            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
            traverse(root.left);
            traverse(root.right);
        }
    }

    public static void main(String[] args) {
//        Node root = new Node('A', new Node('B'), new Node('C'));
//        Node root = new Node('A');
        Node root = new Node('A',
                new Node('B',
                        new Node('D'),
                        new Node('E')),
                new Node('C',
                        new Node('F'),
                        new Node('G')));
        Solution s = new Solution();
        s.traverse(root);
//        if(root.left.left == null) {
//            System.out.println("NULL");
//        }
    }
}