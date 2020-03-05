package S1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));

        int result = s.getDecimalValue(head);
        System.out.println(result);

    }
}
