package LinkedList;

import java.util.Scanner;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_24 {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {





    }

    public ListNode swapPairs_initial(ListNode head) {
        ListNode preNode=new ListNode(-1,head);
        ListNode result=preNode;
        ListNode curNode=head;

        while(curNode!=null){
            ListNode nextNode=curNode.next;
            if(nextNode==null){break;}
            ListNode futureNode=nextNode.next;
            preNode.next=nextNode;
            nextNode.next=curNode;
            curNode.next=futureNode;

            preNode=curNode;
            curNode=curNode.next;
        }

        return result.next;
    }


    public ListNode swapPairs(ListNode head) {
        ListNode fakeNode=new ListNode(-1,head);

        // 把curNode指向头节点就不会把fakeNode本身参与进来，因为这是单向链表
        ListNode curNode = fakeNode;

        while(curNode!=null){
            ListNode firstNode=curNode.next;
            if(firstNode==null){break;}
            ListNode secondNode=firstNode.next;
            if(secondNode==null){break;}
            curNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            curNode=firstNode;
        }
        return fakeNode.next;
    }
}
