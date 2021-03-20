package 스코페;

import java.util.*;
import java.io.*;

public class Two {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long[] arr = new long[N];
        for(int i = 0; i < N; ++i){
            arr[i] = input.charAt(i) - '0';
        }
        long[] dp = new long[N];
        dp[0] = 1;

        for(int i = 1; i < N; ++i){
            if(i - 1 >= 0 && arr[i - 1] != 0){
                dp[i] += dp[i - 1];
            }
            if(i - 2 >= 0 && arr[i - 2] != 0){
                dp[i] += dp[i - 2];
            }
        }

        bw.write(dp[N - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
1101
1111
50
11111111111111111111111111111111111111111111111111
 */
