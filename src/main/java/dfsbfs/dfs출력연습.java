package dfsbfs;

import java.util.*;
import java.io.*;

public class dfs출력연습 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;

    static void dfs(int node){
        //방문 순서
        System.out.println(node);
        visit[node] = true;
        for(int next : graph.get(node)){
            if(!visit[next]){
                dfs(next);
            }
        }
        // 스택에서 빠지는순서
//        System.out.println(node);
        return;
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

        dfs(1);
        bw.flush();
        bw.close();
        br.close();
    }
}

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

