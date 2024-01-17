package LinkedList;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_02_07 {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempNode = headA;
        int numA = 1;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            numA++;
        }
        int numB = 1;
        tempNode = headB;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            numB++;
        }

        if (numA > numB) {
            ListNode aNode = headA;
            ListNode bNode = headB;
            // 移动numA
            for (int i = 0; i < numA - numB; i++) {
                aNode = aNode.next;
            }
            while (aNode != null) {
                if (aNode == bNode) {
                    return aNode;
                }
                aNode = aNode.next;
                bNode = bNode.next;
            }

        } else {
            ListNode aNode = headA;
            ListNode bNode = headB;
            // 移动numA
            for (int i = 0; i < numB - numA; i++) {
                bNode = bNode.next;
            }
            while (aNode != null) {
                if (aNode == bNode) {
                    return aNode;
                }
                aNode = aNode.next;
                bNode = bNode.next;
            }

        }


        return null;
    }
}
