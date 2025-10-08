package io.github.jbm.questions.heap;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }        
}

public class MergeSortedLinkedList {

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2)-> Integer.compare(n1.val, n2.val));
        for(ListNode head : lists) {
            pq.offer(head);
        }

        ListNode dummy = new ListNode(); // fake head for LinkedList;
        ListNode tail = dummy;           // Keep track of end of LL, otherwise for each append we have to traverse the whole LL
        
        while (! pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }            
            tail.next = node; // Append the node           
            tail = tail.next; // Move the tail tail = node
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // L0: [1, 4, 5]
        ListNode l0 = new ListNode(1, new ListNode(4, new ListNode(5)));

        // L1: [1, 3, 4]
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // L2: [2, 6]
        ListNode l2 = new ListNode(2, new ListNode(6));

        // Put them in an array for mergeKLists
        ListNode[] lists = new ListNode[] { l0, l1, l2 };

        printList(l0);
        printList(l1);
        printList(l2);

        printList(mergeKLists(lists));
        
    }
}
