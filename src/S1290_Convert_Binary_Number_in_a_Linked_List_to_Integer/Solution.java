package S1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        List<Integer> binaryList = new ArrayList<Integer>();
        ListNode p = head;
        int decimalValue = 0;
        while(p != null) {
            binaryList.add(p.val);
            p = p.next;
        }
        int binaryLength = binaryList.size();
        for (int i=0; i < binaryLength; i++) {
            decimalValue += binaryList.get(i) * Math.pow(2, binaryLength - 1 - i);
        }
        return decimalValue;
    }
}