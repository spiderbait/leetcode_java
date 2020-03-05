package S860_Lemonade_Change;
//开始没有考虑20可以找零3张5的场景。

public class Solution {

    private boolean lemonadeChange(int[] bills){

        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;

        for (int i = 0;i < bills.length; i++){

            int total = 5 * fiveCount + 10 * tenCount + 20 * twentyCount;

            System.out.println("Bill #" + i
                    + " value is " + bills[i]
                    + ", fiveCount = " + fiveCount
                    + ", tenCount = " + tenCount
                    + ", twentyCount = " + twentyCount
                    + ", total is " + total
                    + ".");

            if (bills[i] == 5){
                fiveCount ++;
            }else if (bills[i] == 10){
                if (fiveCount > 0){
                    fiveCount --;
                    tenCount ++;
                }else{
                    return false;
                }
            }else if (bills[i] == 20){
                if (fiveCount > 0 && tenCount > 0){
                    fiveCount --;
                    tenCount --;
                    twentyCount ++;
                }else if (fiveCount >= 3){
                    fiveCount -= 3;
                    twentyCount ++;
                }else{
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
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//			int[] bills = {5, 5, 5, 10, 20};
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
//			int[] bills = {10, 10};
//			int[] bills = {5, 5, 10, 10, 20};

//			int i = 0;
//			for(int bill: bills){
//				System.out.println(bill + " " + i);
//				i ++;
//			}

        Solution s = new Solution();
        System.out.println(s.lemonadeChange(bills));
    }

}
