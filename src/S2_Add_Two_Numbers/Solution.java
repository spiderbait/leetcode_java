package S2_Add_Two_Numbers;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//        System.out.println("addTwoNumbers();");
        List<Character> charList1 = listToCharArray(l1);
        List<Character> charList2 = listToCharArray(l2);
        List<Character> sumCharList = new ArrayList<>();

//        System.out.println("charList1: " + charList1.toString());
        boolean carryBit = false;
        int bitSum = 0;
        char c;
        int i = charList1.size() - 1, j = charList2.size() - 1;

        while(i >= 0 || j >= 0) {

            bitSum = Character.digit(charList1.get(i), 10)
                    + Character.digit(charList2.get(j), 10);
//            System.out.println("i = " + i + ", j = " + j + ", bitSum = " + bitSum);
            if (carryBit) {
                bitSum += 1;
                carryBit = false;
            }
            if (bitSum >= 10) {
                carryBit = true;
                c = String.valueOf(bitSum).charAt(String.valueOf(bitSum).length() - 1);
            } else {
                c = String.valueOf(bitSum).charAt(0);
            }

            System.out.println(c);

        }

        return l1;
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

    public List<Character> listToCharArray(ListNode listNode) {

        ListNode p = listNode;
        List<Character> charList = new ArrayList<>();

        while(p != null) {
            charList.add(Character.forDigit(p.val, 10));
            p = p.next;
        }

        return charList;
    }

    public ListNode charArrayToList(List<Character> charList) {

        ListNode head = new ListNode(Character.digit(charList.get(0), 10));
        ListNode p = head;
        for (int i=1; i<charList.size(); i++) {
            p.next = new ListNode(Character.digit(charList.get(i), 10));
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
        Solution s = new Solution();

        s.addTwoNumbers(s.longToList(342L), s.longToList(65L));
    }
}