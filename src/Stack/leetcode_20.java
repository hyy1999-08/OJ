package Stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:Yaoye Huang
 * @create 2024- 07- 01 21:29
 */
public class leetcode_20 {

    @Test
    public void test() {

    }

    public boolean isValid(String s) {
        char[] charArrays=s.toCharArray();
        Stack<Character> myStack=new Stack<>();
        for(char i:charArrays){
            if(i=='('||i=='{'||i=='['){
                myStack.push(i);
                continue;
            }
            if(myStack.isEmpty()){
                return false;
            }
            Character top = myStack.peek();
            if((i==')' && top=='(')||(i=='}'&&top=='{')||(i==']'&&top=='[')){
                myStack.pop();
            }else{
                return false;
            }
        }

        return myStack.isEmpty();
    }
}
