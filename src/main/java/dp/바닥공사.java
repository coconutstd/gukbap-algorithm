package dp;

import java.util.Scanner;

public class 바닥공사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 1) {
            System.out.println("1");
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i <= n; ++i){
            dp[i] = (dp[i- 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] % 10007);
    }
}
