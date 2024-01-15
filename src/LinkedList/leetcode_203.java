package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_203 {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {





    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode fakedNode=new ListNode(-1,head);
        ListNode preNode = fakedNode;
        ListNode curNode = head;

        while(curNode!=null){
            if(curNode.val == val){
                preNode.next=curNode.next;
            }else{
                preNode=curNode;
            }
            curNode=curNode.next;
        }

        return fakedNode.next;
    }


}
