package graph2;

import java.util.*;
import java.io.*;

class City{
    int to, cost;
    public City(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class 다익스트라_복습 {

    private static int[] distance;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        distance = new int[n + 1];
        for(int i = 0; i < n + 1; ++i) distance[i] = Integer.MAX_VALUE;
        ArrayList<ArrayList<City>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; ++i) graph.add(new ArrayList<>());
        for(int i = 0; i < e; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new City(b, c));
            graph.get(b).add(new City(a, c));
        }

        int start = 4;
        distance[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        pq.offer(new City(start, 0));

        while(!pq.isEmpty()){
            City cur = pq.poll();
            if(distance[cur.to] < cur.cost){
                continue;
            }
            for(City next : graph.get(cur.to)){
                int cost = cur.cost + next.cost;
                if(cost < distance[next.to]){
                    distance[next.to] = cost;
                    pq.offer(new City(next.to, cost));
                }
            }
        }
        for(int i = 1; i < n + 1; ++i){
            bw.write(distance[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


/*
6 9
4 1 10
3 5 24
5 6 2
3 1 41
5 1 24
4 6 50
2 4 66
2 3 22
1 6 25
 */

