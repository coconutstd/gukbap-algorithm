package shortestpath;

import java.util.*;
import java.io.*;


public class 복습_다익스트라 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; ++i){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        int[] shortestPath = new int[n + 1];
        for(int i = 2; i <= n; ++i) shortestPath[i] = Integer.MAX_VALUE;
        shortestPath[1] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });
        heap.offer(new Node(start, 0));
        while(!heap.isEmpty()){
            Node cur = heap.poll();
            if(shortestPath[cur.to] < cur.cost){
                continue;
            }
            for(Node next : graph.get(cur.to)){
                int cost = cur.cost + next.cost;
                if(cost < shortestPath[next.to]){
                    shortestPath[next.to] = cost;
                    heap.offer(new Node(next.to, cost));
                }
            }
        }

        for(int i = 1; i < n + 1; ++i){
            bw.write(shortestPath[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */