package S116_Populating_Next_Right_Pointers_in_Each_Node;

public class Node {
    public char val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(char _val) {
        val = _val;
    }

    public Node(char _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(char _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
