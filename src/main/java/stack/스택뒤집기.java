package stack;

import java.util.*;

public class 스택뒤집기 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        solution(stack);
        System.out.println(stack);
    }

    private static void solution(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int temp = stack.pop();
        solution(stack);
        insertAtBottom(stack, temp);
    }

    private static void insertAtBottom(Stack<Integer> stack, int number){
        if (stack.isEmpty()) {
            stack.push(number);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, number);
            stack.push(temp);
        }
    }
}
