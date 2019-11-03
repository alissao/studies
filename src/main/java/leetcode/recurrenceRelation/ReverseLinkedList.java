package leetcode.recurrenceRelation;

import leetcode.ListNode;

import java.util.Scanner;

import static leetcode.ListNode.printNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite quantos nós você utilizará: ");
        String scanNumRows = scan.nextLine();
        int num = Integer.parseInt(scanNumRows);
        System.out.println("Digite os " + num + " valores que estarão nos seus nós, separados por espaços: ");
        scanNumRows = scan.nextLine();
        String[] arrOfStr = scanNumRows.split(" ", 0);

        ListNode no1= new ListNode(Integer.parseInt(arrOfStr[0]));
        no1 = no1.createListNode(arrOfStr, no1, 0);

        System.out.println(printNode(no1));
        no1 = iterativeReverseList(no1);
        System.out.println(printNode(no1));
        no1 = recursiveReverseList(no1);
        System.out.println(printNode(no1));
    }

    public static ListNode iterativeReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.getNext() == null) return head;
        ListNode p = recursiveReverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return p;
    }

}
