package soma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] use = new int[n + 1];
        for(int i = 0; i < k; ++i){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            if(hour > h) continue;
            use[num] += hour;
        }

        for(int i = 1; i <= n; ++i){
            if(use[i] != 0){
                if(use[i] > h){
                    bw.write(i + " " + 1000 * h);
                } else {
                    bw.write(i + " " + 1000 * use[i]);
                }
            } else {
                bw.write(i + " " + 0 + "\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

/*
2 7 4
1 10
1 5
1 7
2 10
2 1
2 3
2 7

 */
