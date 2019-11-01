package leetcode.recursion1;

public class SwappingNodesInPairs {

    public static void main(String[] args) {
        ListNode No = new ListNode(5);
        No.next = new ListNode(1);
        No.next.next = new ListNode(3);
        No.next.next.next = new ListNode(10);

        System.out.println("[" + No.val + ", " + No.next.val + ", " + No.next.next.val + ", " + No.next.next.next.val + "]");

        No = swapPairs(No);

        System.out.println("[" + No.val + ", " + No.next.val + ", " + No.next.next.val + ", " + No.next.next.next.val + "]");
    }

//    Definition for singly-linked list.
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        else {
            ListNode temp = head.next;
            head.next = swapPairs(temp.next);
            temp.next = head;
            return temp;
        }
    }

}
