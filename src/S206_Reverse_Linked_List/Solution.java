package S206_Reverse_Linked_List;

//import solutions.common.ListNode;
//
//public class Solution {
//	public static ListNode reverseList(ListNode head) {
//        ListNode t = null;
//        ListNode tail = null;
//
//        while(head != null){
//        	tail = new ListNode(head.val);
//        	tail.next = t;
//        	t = tail;
//        	head = head.next;
//        }
//
//        return tail;
//    }
//
//	public static void main(String[] args){
//		ListNode head = new ListNode(0);
//		ListNode t = head;
//		for(int i = 1;i < 4;i++){
//			ListNode node = new ListNode(i);
//			t.next = node;
//			t = node;
//		}
////		while(head != null){
////			System.out.print(head.val+" --> ");
////			head = head.next;
////		}
//		ListNode tail = reverseList(head);
//		while(tail != null){
//		System.out.print(tail.val+" --> ");
//		tail = tail.next;
//	}
//	}
//}
