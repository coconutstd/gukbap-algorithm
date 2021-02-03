package shortestpath;

import java.util.Scanner;

/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */

public class 플로이드워셜 {

    static final int INF = (int) 1e9;
    static int n;
    static int m;
    static int[][] graph;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= n; ++j){
                graph[i][j] = INF;
                if(i == j) graph[i][j] = 0;
            }
        }

        for(int i = 0; i < m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        for(int k = 1; k < n + 1; ++k){
            for(int a = 1; a < n + 1; ++a){
                for(int b = 1; b < n + 1; ++b){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int a = 1; a < n + 1; ++a){
            for(int b = 1; b < n + 1; ++b){
                if(graph[a][b] == INF){
                    System.out.print("INF ");
                }else{
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
