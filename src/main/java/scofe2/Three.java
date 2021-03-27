package scofe2;

import java.util.*;
import java.io.*;

public class Three {

    static int[] p;

    static boolean find(int parent, int x){
        if(x == p[x]) return false;
        if(p[x] == parent){
            return true;
        } else {
            return find(parent, p[x]);
        }
    }

    static void union(int a, int b){
        p[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        p = new int[n + 1];
        for(int i = 1; i < n + 1; ++i) p[i] = i;
        for(int i = 0; i < n - 1; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for(int i = 0; i < q; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a, b)){
                bw.write("yes\n");
            } else{
                bw.write("no\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}


/*
6 6
6 4
6 5
4 1
4 2
4 3
1 4
4 1
6 5
1 6
6 3
5 4
 */

/*
no
yes
yes
no
yes
yes
 */
