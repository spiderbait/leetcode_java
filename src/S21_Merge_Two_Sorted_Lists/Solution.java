package S21_Merge_Two_Sorted_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null && l2 == null) {
//            return null;
//        }
//            List<Integer> sortList = new ArrayList<>();
//            while (l1 != null) {
//            sortList.add(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            sortList.add(l2.val);
//            l2 = l2.next;
//        }
//        Collections.sort(sortList);
//
//        ListNode head = new ListNode(sortList.get(0));
//        ListNode p = head;
//        for (int i=1; i < sortList.size(); i ++) {
//            p.next = new ListNode(sortList.get(i));
//            p = p.next;
//        }
//        return head;
//    }
    // define two pointer
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sentinel = 0;
        if(p1.val > p2.val) {
            sentinel = p2.val;
            p2 = p2.next;
        } else {
            sentinel = p1.val;
            p1 = p1.next;
        }
        ListNode result = new ListNode(sentinel);
        ListNode p = result;

        while(p1 != null || p2 != null) {
            if(p1 == null) {
                while(p2 != null) {
                    p.next = new ListNode(p2.val);
                    p = p.next;
                    p2 = p2.next;
                }
                break;
            } else if (p2 == null) {
                while(p1 != null) {
                    p.next = new ListNode(p1.val);
                    p = p.next;
                    p1 = p1.next;
                }
                break;
            }
            if(p1.val > p2.val) {
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            } else if (p1.val < p2.val) {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        Solution s = new Solution();
        ListNode p = s.mergeTwoLists(l1, l2);
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
