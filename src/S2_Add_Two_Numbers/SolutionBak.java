package S2_Add_Two_Numbers;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SolutionBak {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = listToLong(l1);
        long n2 = listToLong(l2);
        long sum = n1 + n2;

        return longToList(sum);
    }

    public long listToLong(ListNode listNode) {

        String listToStr = "";
        while(listNode != null) {
            listToStr += String.valueOf(listNode.val);
            listNode = listNode.next;
        }

        return Long.parseLong(listToStr);
    }

    public ListNode longToList(long n) {

        String longToStr = String.valueOf(n);
        ListNode head = new ListNode(Character.digit(longToStr.charAt(0), 10));
        ListNode p = head;
        for (int i=1; i<longToStr.length(); i++) {
            p.next = new ListNode(Character.digit(longToStr.charAt(i), 10));
            p = p.next;
        }

        return head;
    }

    public void printListNode(ListNode head) {
        ListNode p = head;
        while(p != null) {
            if(p.next == null) {
                System.out.print(p.val);
            } else {
                System.out.print(p.val + " -> ");
            }
            p = p.next;
        }
    }

    public static void main(String[] args) {
        SolutionBak s = new SolutionBak();

        s.printListNode(s.addTwoNumbers(s.longToList(243L), s.longToList(564L)));
    }
}