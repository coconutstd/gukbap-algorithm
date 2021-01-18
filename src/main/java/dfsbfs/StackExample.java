package dfsbfs;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
