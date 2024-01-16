package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_206 {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {





    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode pre=null;
        ListNode cur=head;
        ListNode next;

        while(cur!=null){
            // 记录
            next=cur.next;
            cur.next = pre;
            pre=cur;
            cur = next;
        }
        return pre;

    }


}
