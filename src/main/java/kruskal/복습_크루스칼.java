package kruskal;

import java.util.*;
import java.io.*;

public class 복습_크루스칼 {

    static int[] p;
    static int find(int x){
        if(x != p[x]){
            return p[x] = find(p[x]);
        } else return p[x];
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            p[b] = a;
        } else{
            p[a] = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        for(int i = 0; i < n + 1; ++i) p[i] = i;
        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i < e; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(from, to, cost));
        }
        Collections.sort(graph, (a, b) -> {
            return a.cost - b.cost;
        });

        for(Node next : graph){
            if(find(next.from) != find(next.to)){
                answer += next.cost;
                union(next.from, next.to);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
 */

