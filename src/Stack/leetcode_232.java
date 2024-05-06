package Stack;

import java.util.Stack;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_232 {
    class MyQueue {
        Stack<Integer> stack_in;
        Stack<Integer> stack_out;

        public MyQueue() {
            stack_in=new Stack<>();
            stack_out=new Stack<>();
        }

        public void push(int x) {
            stack_in.push(x);
        }

        public int pop() {
            while (!stack_in.empty()) {
                stack_out.push(stack_in.pop());
            }
            int result = stack_out.pop();

            while (!stack_out.empty()) {
                stack_in.push(stack_out.pop());
            }
            return result;
        }

        public int peek() {
            while (!stack_in.empty()) {
                stack_out.push(stack_in.pop());
            }
            int result = stack_out.peek();
            while (!stack_out.empty()) {
                stack_in.push(stack_out.pop());
            }
            return result;
        }

        public boolean empty() {
            return stack_in.empty();
        }

    }


}
