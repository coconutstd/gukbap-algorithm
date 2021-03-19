package dp;

import java.util.*;
import java.io.*;

public class 복습_1로만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        for(int i = 0; i <= x; ++i) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 1; i <= x; ++i){
            if(i - 1 >= 0){
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if(i % 5 == 0){
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }
        bw.write(dp[x] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
26
 */

