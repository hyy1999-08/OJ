package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fakeNode = new ListNode(-1, head);

        ListNode preNode = fakeNode;
        ListNode curNode = head;

        // 先移动
        for (int i = 1; i < n; i++) {
            // 如果还没移动那么多，就到头了就直接返回表明不用删除
            if (curNode == null) {
                return head;
            }
            curNode = curNode.next;
        }

        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }

        // 删除
        preNode.next = preNode.next.next;

        return fakeNode.next;
    }
}
