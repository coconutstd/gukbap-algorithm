package adhoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; ++i) arr[i] = i;
        for(int i = 0; i < M; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]++;
            arr[b]--;
        }



        boolean[] visit = new boolean[N + 1];
        for(int i = 1; i <= N; ++i){
            if(arr[i] > N || arr[i] < 0) {
                System.out.println(-1);
                return;
            }
            if(visit[arr[i]]){
                System.out.println(-1);
                return;
            }
            visit[arr[i]] = true;
        }

        for(int i = 1; i <= N; ++i){
            System.out.print(arr[i] + " ");
        }

        br.close();
    }
}

/*
5 5
1 2
1 5
3 4
3 5
4 5
 */

/*
5 6
1 2
1 3
1 5
2 5
3 4
3 5
 */