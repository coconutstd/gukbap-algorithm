package shortestpath;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

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

class Node2 implements Comparable<Node2>{
    int cost;
    int from;
    public Node2(int cost, int from){
        this.cost = cost;
        this.from = from;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.cost - o.cost;
    }
}

public class 개선된다익스트라 {

    static final int INF = (int) 1e9;
    static int n;
    static int m;
    static int start;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static PriorityQueue<Node2> q = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 최단 거리를 저장할 거리 배열
        distance = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            distance[i] = INF;
        }
        visited = new boolean[n + 1];

        // 그래프를 인접리스트로 표현
        graph = new ArrayList<>();
        for(int i = 0; i <= n; ++i){
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        dijkstra(start);

        for(int i = 1; i < n + 1; ++i){
            if(distance[i] == INF){
                System.out.println("INFINITY");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static void dijkstra(int start){
        distance[start] = 0;
        q.offer(new Node2(0, start));
        while(!q.isEmpty()){
            Node2 cur = q.poll();
            if(distance[cur.from] < cur.cost){
                continue;
            }
            for(Node node : graph.get(cur.from)){
                int cost = cur.cost + node.cost;
                if(cost < distance[node.to]){
                    distance[node.to] = cost;
                    q.offer(new Node2(cost, node.to));
                }
            }
        }
    }
}
