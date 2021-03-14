package dp;

import java.util.*;
import java.io.*;

public class 하노이 {

    public static void hanoi(char s, char d, char e, int n){
        if(n <= 0) return;
        hanoi(s, e, d, n - 1);
        System.out.printf("%d 원반을 %c 에서 %c 으로 옮깁니다\n", n, s, d);
        hanoi(e, d, s, n - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        hanoi('s', 'd', 'e', 4);

        bw.flush();
        bw.close();
        br.close();
    }
}

