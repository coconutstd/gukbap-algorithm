package kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node{
    int from;
    int to;
    int cost;
    public Node(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class 크루스칼 {
    static int v, e;
    static int[] parent;
    static ArrayList<Node> graph;

    static int find(int x){
        if(parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        parent = new int[v + 1];
        for(int i = 1; i < v + 1; ++i){
            parent[i] = i;
        }
        graph = new ArrayList<>();
        for(int i = 0; i < e;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.add(new Node(a, b, cost));
        }
        Collections.sort(graph, (a, b) -> {
            return a.cost - b.cost;
        });

        int result = 0;
        for(Node n : graph){
            int cost = n.cost;
            int a = n.from;
            int b = n.to;
            if(find(a) != find(b)){
                union(a, b);
                result += cost;
            }
        }
        System.out.println(result);
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