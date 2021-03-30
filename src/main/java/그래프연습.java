import java.util.*;
import java.io.*;

public class Main {

    static int[] p;
    static int[] indegree;
    static int[] count;


    static int find(int x){
        count[x]++;
        if(x != p[x]){
            return find(p[x]);
        }else return x;
    }

    static void union(int a, int b){

        if(a < b){
            p[b] = a;
        } else {
            p[a] = b;
        }
    }

    public static int[] solution(int total_sp, int[][] skills){
        int N = skills.length + 1;
        int[] answer = new int[N];
        p = new int[N + 1];
        count = new int[N + 1];
        for(int i = 1; i < N + 1; ++i) p[i] = i;
        indegree = new int[N + 1];
        for(int i = 0; i < skills.length; ++i){
            int parent = skills[i][0];
            int child = skills[i][1];
            indegree[parent]++;
            union(parent, child);
        }
        for(int i = 1; i < N + 1; ++i){
            if(indegree[i] == 0){
                find(i);
            }
        }

        int total_cnt = 0;
        for(int i = 1; i < N + 1; ++i){
            total_cnt += count[i];
        }

        for(int i = 0; i < N; ++i){
            answer[i] = total_sp / total_cnt * count[i + 1];
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] skills = new int[][]{
                {1, 2},
                {1, 3},
                {3, 6},
                {3, 4},
                {3, 5}
        };
        solution(121, skills);
        bw.flush();
        bw.close();
        br.close();
    }
}

