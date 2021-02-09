package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACMCraft {
    static int n, k;
    static int w;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] times, in;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int testCase = 0; testCase < t; ++testCase){
            n = sc.nextInt();
            k = sc.nextInt();
            times = new int[n + 1];
            in = new int[n + 1];
            edges = new ArrayList<>();
            for(int i = 1; i < n + 1; ++i){
                times[i] = sc.nextInt(); 
            }
            for(int i = 0; i < n + 1; ++i){
                edges.add(new ArrayList<>());
            }
            for(int i = 0; i < k; ++i){
                int from = sc.nextInt();
                int to = sc.nextInt();
                edges.get(from).add(to);
                in[to]++;
            }
            w = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i < n + 1; ++i){
                if(in[i] == 0) q.offer(i);
            }
            int[] result = times.clone();
            while(!q.isEmpty()){
                int now = q.poll();
                for(Integer i : edges.get(now)){
                    result[i] = Math.max(result[i], result[now] + times[i]);
                    in[i]--;
                    if(in[i] == 0){
                        q.offer(i);
                    }
                }
            }

            System.out.println(result[w]);
        }
    }
}


/*
2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7
 */