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
            stack_in = new Stack<>();
            stack_out = new Stack<>();
        }

        public void push(int x) {
            stack_in.push(x);
        }

        public int pop() {
            stumpStackIn();
            return stack_out.pop();
        }


        public int peek() {
            stumpStackIn();
            return stack_out.peek();
        }

        public boolean empty() {
            return stack_in.isEmpty() && stack_out.isEmpty();
        }

        private void stumpStackIn() {
            if (stack_out.isEmpty()) {
                while (!stack_in.empty()) {
                    stack_out.push(stack_in.pop());
                }
            }
        }

    }


}
