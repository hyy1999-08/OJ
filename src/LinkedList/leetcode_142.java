package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_142 {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {


    }


    // 快慢指针法
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node1 = head;
        ListNode node2 = fast;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

}
