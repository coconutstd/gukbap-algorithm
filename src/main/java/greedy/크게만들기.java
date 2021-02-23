package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 크게만들기 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        Deque<Character> dq = new LinkedList<>();
        for(int i = 0; i < number.length(); ++i){
            while(k > 0 && !dq.isEmpty() && dq.getLast() < number.charAt(i)){
                dq.removeLast();
                k--;
            }
            dq.addLast(number.charAt(i));
        }
        String answer = "";
        while(dq.size() > k){
            answer += dq.removeFirst();
        }

        System.out.println(answer);

        br.close();
    }
}
