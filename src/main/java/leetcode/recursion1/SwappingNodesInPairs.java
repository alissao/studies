package leetcode.recursion1;

import leetcode.ListNode;

public class SwappingNodesInPairs {

    public static void main(String[] args) {
        ListNode no1 = new ListNode(5);
        no1.setNext(new ListNode(1));
        no1.getNext().setNext(new ListNode(3));
        no1.getNext().getNext().setNext(new ListNode(10));

        System.out.println("[" + no1.getVal() + ", " + no1.getNext().getVal() + ", " + no1.getNext().getNext().getVal()
                + ", " + no1.getNext().getNext().getNext().getVal() + "]");

        no1 = swapPairs(no1);

        System.out.println("[" + no1.getVal() + ", " + no1.getNext().getVal() + ", " + no1.getNext().getNext().getVal()
                + ", " + no1.getNext().getNext().getNext().getVal() + "]");
    }

    public static ListNode swapPairs(ListNode head) {
        if (null == head || head.getNext() == null) {
            return head;
        }
        else {
            ListNode temp = head.getNext();
            head.setNext(swapPairs(temp.getNext()));
            temp.setNext(head);;
            return temp;
        }
    }

}
