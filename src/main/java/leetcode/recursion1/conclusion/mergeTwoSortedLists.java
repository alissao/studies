package leetcode.recursion1.conclusion;

import leetcode.ListNode;

public class mergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.getVal() < l2.getVal())
        {
            l1.setNext(mergeTwoLists(l1.getNext(), l2));
            return l1;
        }
        else
        {
            l2.setNext(mergeTwoLists(l1, l2.getNext()));
            return l2;
        }
    }

}
