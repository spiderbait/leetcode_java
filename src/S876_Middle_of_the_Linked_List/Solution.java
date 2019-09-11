//// 整型变量计算完结果还是整型变量 如 int 5 ／ int 2 = int 2。
//
//
//import solutions.common.ListNode;
//
//public class Solution_876_Middle_of_the_Linked_List {
//
//	public ListNode middleNode(ListNode head){
//
//		ListNode node = head;
//		double n = 0;
//		while(true){
//			if (node == null){
//				break;
//			}
//			n ++;
//			System.out.println(node.val + " --> " + n);
//			node = node.next;
//		}
//		int middleIndex = (int) Math.ceil(((n + 1) / 2));
//		System.out.println("middleIndex = " + middleIndex);
//		int i = 1;
//		node = head;
//		while(true){
//			if (i == middleIndex){
////				System.out.println("yes");
//				return node;
//			}else{
////				System.out.println("no");
//				node = node.next;
//				i ++;
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ListNode node = new ListNode(1);
//		ListNode head = node;
//		ListNode rst;
//		for (int i=2; i < 5; i++){
//			node.next = new ListNode(i);
//			node = node.next;
//		}
//
//		Solution_876_Middle_of_the_Linked_List sol = new Solution_876_Middle_of_the_Linked_List();
//		rst = sol.middleNode(head);
//		System.out.println("rst = " + rst.val);
//
////		int n = 5;
////		System.out.println(n/2);
////		System.out.println(Math.ceil(n));
////		System.out.println(Math.rint(n));
////		System.out.println(Math.floor(n));
//
//
//	}
//
//}
