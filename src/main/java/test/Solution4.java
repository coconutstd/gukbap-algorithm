package test;

import static org.junit.Assert.assertEquals;

public class Solution4 {
    public static void main(String[] args) {
        assertEquals(ways(4, 3), 5);
    }

    static int cnt, N, K;

    static void dfs(int sum){
        if(sum == N){
            cnt++;
            return;
        }
        if(sum > N){
            return;
        }
        for(int i = 1; i <= K; ++i){
            dfs(sum + i);
        }
    }
    static int ways(int total, int k) {
        cnt = 0;
        N = total;
        K = k;
        dfs(0);
        return cnt;
    }
}
