package Stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_225 {

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top();
        myStack.pop();
        myStack.empty();


    }

    class MyStack {

        Queue<Integer> queueIn;
        Queue<Integer> queueOut;

        public MyStack() {
            queueIn = new LinkedList<>();
            queueOut = new LinkedList<>();
        }

        public void push(int x) {
            if (queueOut.isEmpty()) {
                queueOut.add(x);
                while (!queueIn.isEmpty()) {
                    queueOut.offer(queueIn.poll());
                }
            } else {
                queueIn.add(x);
                while (!queueOut.isEmpty()) {
                    queueIn.offer(queueOut.poll());
                }
            }
        }

        public int pop() {
            if (queueIn.isEmpty()) {
                return queueOut.poll();
            } else {
                return queueIn.poll();
            }
        }

        public int top() {
            if (queueIn.isEmpty()) {
                return queueOut.peek();
            } else {
                return queueIn.peek();
            }
        }

        public boolean empty() {
            return queueOut.isEmpty() && queueIn.isEmpty();
        }
    }

}
