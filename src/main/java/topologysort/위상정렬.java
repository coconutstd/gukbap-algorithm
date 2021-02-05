package topologysort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬 {
    public static void main(String[] args) {
        int v, e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v + 1; ++i){
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[v + 1];
        for(int i = 0; i < e; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b] += 1;
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < v + 1; ++i){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for(Integer i : graph.get(now)){
                indegree[i] -= 1;
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
        }

        for(Integer i : result){
            System.out.print(i + " ");
        }
    }
}
/*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
 */