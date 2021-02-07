package graph2;

import java.util.Scanner;

public class 탑승구 {
    static int n;
    static int m;
    static int[] p;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = new int[n + 1];
        for(int i = 1; i < n + 1; ++i){
            p[i] = i;
        }
        int answer = 0;
        for(int i = 0; i < m; ++i){
            int plane = sc.nextInt();
            int j = 0;
            for(j = plane; j >= 0; --j){
                if(j == 0) {
                    System.out.println(answer);
                    return;
                }
                if(p[j] != 0){
                    break;
                }
            }
            p[j] = 0;
            answer++;
        }
        System.out.println(answer);
    }
}
