package dfsbfs;

import java.util.*;
import java.io.*;

public class bfs출력연습 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visit;

    static void bfs(int start){
        visit[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph.get(cur)){
                if(!visit[next]){
                    q.offer(next);
                    visit[next] = true;
                    System.out.print(next + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        for(int i = 0; i < n + 1; ++i){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i < n + 1; ++i){
            Collections.sort(graph.get(i));
        }

        bfs(1);

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
/*
8 9
1 2
2 7
7 6
8 7
1 8
1 3
3 5
3 4
4 5
 */

