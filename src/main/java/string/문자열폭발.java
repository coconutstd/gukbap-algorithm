package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 문자열폭발 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder(str);
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < sb.length(); ++i){
            st.push(sb.charAt(i));
            boolean check = true;
            if(st.size() >= bomb.length()){
                for(int j = 0; j < bomb.length(); ++j){
                    if(st.get(st.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int j = 0; j < bomb.length(); ++j){
                        st.pop();
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < st.size(); ++i){
            answer.append(st.get(i));
        }
        if(answer.length() == 0){
            bw.write("FRULA");
        } else {
            bw.write(answer.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
