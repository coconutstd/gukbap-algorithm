package greedy;

import java.util.*;

class Node3 implements Comparable<Node3>{
    int from, to, cost;

    public Node3(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Node3 o){
        return this.cost - o.cost;
    }

}

class 섬연결하 {

    static int[] p;

    public static int find(int x){
        if(x != p[x]){
            return p[x] = find(p[x]);
        } else return p[x];
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            p[b] = a;
        } else {
            p[a] = b;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        p = new int[n + 1];
        for(int i = 0; i < n + 1; ++i){
            p[i] = i;
        }

        ArrayList<Node3> graph = new ArrayList<>();
        for(int i = 0; i < costs.length; ++i){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            graph.add(new Node3(a, b, c));
        }

        Collections.sort(graph);

        for(Node3 node : graph){
            if(find(node.from) != find(node.to)){
                union(node.from, node.to);
                answer += node.cost;
            }
        }

        return answer;
    }
}