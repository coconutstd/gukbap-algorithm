package stack;

import java.io.*;
import java.util.*;

public class 후위표기식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String eval = br.readLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < eval.length(); ++i){
            if(Character.isAlphabetic(eval.charAt(i))){
                sb.append(eval.charAt(i));
            } else {
                if(eval.charAt(i) == '*' || eval.charAt(i) == '/'){
                    // +, - 는 나중에 pop 하기 위해
                    while(!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')){
                        sb.append(st.pop());
                    }
                    st.push(eval.charAt(i));
                } else if (eval.charAt(i) == '+' || eval.charAt(i) == '-'){
                    // +, -, *, / 모두 pop 하기 위해 단, ( 는 예외
                    while(!st.isEmpty() && st.peek() != '('){
                        sb.append(st.pop());
                    }
                    st.push(eval.charAt(i));
                } else if (eval.charAt(i) == '(') {
                    st.push(eval.charAt(i));
                } else if(eval.charAt(i) == ')'){
                    while(!st.isEmpty() && st.peek() != '('){
                        sb.append(st.pop());
                    }
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
A*(B+C-D)  => ABC+D-*
           => ABC+*D-
A*B*C => AB*C*
      => ABC**

A*(B+C) => ABC+*
        => ABC

A+B*C*D => ABC*D*+
 */