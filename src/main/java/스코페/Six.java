package 스코페;

import java.util.*;
import java.io.*;

public class Six {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];

        for(int i = 0; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[m][n];

        dp[0][0] = map[0][0];
        for(int i = 1; i < m; ++i){
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for(int i = 1; i < n; ++i){
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]) + map[i][j];
            }
        }
        bw.write(dp[m - 1][n - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
3 5
3 4 5
2 3 9
3 9 3
4 5 1
1 3 6
 */