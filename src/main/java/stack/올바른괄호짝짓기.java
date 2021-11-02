package stack;
import java.util.*;


public class 올바른괄호짝짓기 {
    public static void main(String[] args) {
        System.out.println(solution("()())()"));
        System.out.println(solution("()())()"));
        System.out.println(solution("(1 + 4) * (2 / 3)"));
    }

    private static boolean solution(String expressions) {
        Stack<Character> brackets = new Stack<>();
        char[] chars = expressions.toCharArray();
        for(char c : chars) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    brackets.push(c);
                    break;
                case ')':
                    if (brackets.isEmpty() || brackets.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (brackets.isEmpty() || brackets.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (brackets.isEmpty() || brackets.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return brackets.isEmpty();
    }
}
