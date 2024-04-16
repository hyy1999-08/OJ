package others;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author:Yaoye Huang
 * @create 2024- 29- 02 20:29
 */
public class LRUCache_146 {

    @Test
    public void test() {
        LRUCache temp = new LRUCache(2);
        temp.put(1,1);
        temp.put(2,2);
        temp.get(1);
        temp.put(3,3);
        temp.get(2);
        temp.put(4,4);
        temp.get(1);
        temp.get(3);
        temp.get(4);
    }

    class LRUCache {

        class Node{
            private int key;
            private int value;

            private Node pre;
            private Node next;

            public Node(int key, int value, Node pre, Node next) {
                this.key = key;
                this.value = value;
                this.pre = pre;
                this.next = next;
            }
        }


        //  关键字->节点值
        Map<Integer, Node> myDict;

        // 指向链表头节点
        Node head;

        // 指向链表尾节点
        Node tail;

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity=capacity;
            myDict = new HashMap<>(capacity);
            head = new Node(-1, -1, null, null);
            tail = new Node(-1, -1, head, null);
            head.next = tail;
        }

        public int get(int key) {
            if (!myDict.containsKey(key)) {
                return -1;
            }

            Node oldNode = myDict.get(key);
            int oldkey = oldNode.key;
            int value = oldNode.value;
            addNext(tail.pre, oldkey, value);
            removeNode(oldNode);
            return value;
        }

        public void put(int key, int value) {
            if(myDict.containsKey(key)){
                Node oldNode = myDict.get(key);
                int oldkey = oldNode.key;
                addNext(tail.pre, oldkey, value);
                removeNode(oldNode);
            }else{
                addNext(tail.pre, key, value);
            }

        }

        public void addNext(Node curNode,int key, int value){
            Node newNode = new Node(key, value, curNode, curNode.next);
            curNode.next = newNode;
            newNode.next.pre = newNode;
            myDict.put(key, newNode);
            if (myDict.size() > capacity) {
                Node nextNode = head.next;
                myDict.remove(nextNode.key);
                removeNode(nextNode);
            }
        }

        public void removeNode(Node target){
            Node preNode=target.pre;
            Node nextNode=target.next;
            nextNode.pre = preNode;
            preNode.next=nextNode;
        }

    }
}
