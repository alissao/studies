package leetcode;


//    Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode(int x) { val = x; }

    public ListNode createListNode(String[] numAndValueOfNodes, ListNode node, int i) {
        if (i == numAndValueOfNodes.length-1) {
            node = new ListNode(Integer.parseInt(numAndValueOfNodes[i]));
            return node;
        }
        node.setNext(createListNode(numAndValueOfNodes, new ListNode(Integer.parseInt(numAndValueOfNodes[i+1])), i+1));
        return node;
    }

    public static String printNode(ListNode node){
        if (node.getNext() != null){
            String pNode = node.getVal() + "->" + printNode(node.getNext());
            return pNode;
        }
        String pNode = String.valueOf(node.getVal());
        return pNode;

    }
}
