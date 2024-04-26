package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {


    }

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode targetNode = head;

        while (targetNode!=null) {
            ListNode nextNode = targetNode.next;
            targetNode.next = preNode;
            preNode = targetNode;
            targetNode = nextNode;
        }
        return preNode;
    }


}
