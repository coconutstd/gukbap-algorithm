package shortestpath;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int to;
    int cost;
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
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

public class 간단한다익스트라 {

    static final int INF = (int) 1e9;
    static int n;
    static int m;
    static int start;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;

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

    // 최단 거리가 가장 짧은 노드를 선택
    static int getSmallestNode(){
        int minVal = INF;
        int index = 0;
        for(int i = 1; i < n + 1; ++i){
            if(distance[i] < minVal && !visited[i]){
                minVal = distance[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start){
        distance[start] = 0;
        visited[start] = true;
        // 처음 출발점에서 각 노드까지의 거리를 초기화 step 1
        for(Node j :  graph.get(start)){
            distance[j.to] = j.cost;
        }

        for(int i = 0; i < n - 1; ++i){
            // 음의 간선이 없으므로 항상 방문한 노드는 최단거리가 보장
            int now = getSmallestNode();
            visited[now] = true;
            for(Node j : graph.get(now)){
                int cost = distance[now] + j.cost;
                if(cost < distance[j.to]){
                    distance[j.to] = cost;
                }
            }
        }
    }
}
