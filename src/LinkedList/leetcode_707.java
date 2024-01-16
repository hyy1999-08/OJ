package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_707 {
    public static void main(String[] args) {





    }

}


class MyLinkedList {

    ListNode fakedHead;

    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public MyLinkedList() {
        fakedHead=new ListNode(-1,null);
    }

    public int get(int index) {
        ListNode cur=fakedHead.next;
        int num=0;
        while(num!=index){
            if(cur==null){
                return -1;
            }
            cur=cur.next;
            num++;
        }
        if(cur==null){
            return -1;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode cur=fakedHead;
        ListNode newNode=new ListNode(val,cur.next);
        cur.next=newNode;
    }

    public void addAtTail(int val) {

        ListNode cur=fakedHead;

        while(cur.next!=null){
            cur=cur.next;
        }
        ListNode newNode=new ListNode(val,cur.next);
        cur.next=newNode;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur=fakedHead;
        int num=0;
        while(cur.next!=null){
            if(num==index){
                ListNode newNode=new ListNode(val,cur.next);
                cur.next=newNode;
                return;
            }
            cur=cur.next;
            num++;
        }
        if(num == index){
            ListNode newNode=new ListNode(val,cur.next);
            cur.next=newNode;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode cur=fakedHead;
        int num=0;
        while(cur.next!=null){
            if(num==index){
                cur.next=cur.next.next;
                return;
            }
            cur=cur.next;
            num++;
        }
    }
}