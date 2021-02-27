package soma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1){
            bw.write(arr[0] + "\n");
            return;
        }

        int answer = 0;
        int size = n / 2;
        int left = 0, right = left + size;
        while(size != 0){
            int val1 = Integer.MIN_VALUE;
            for(int i = left; i < left + size; ++i){
                if(val1 < arr[i]){
                    val1 = arr[i];
                }
            }
            int val2 = Integer.MIN_VALUE;
            for(int i = right; i < right + size; ++i){
                if(val2 < arr[i]){
                    val2 = arr[i];
                }
            }

            if(val1 > val2){
                left = right;
                right = right + size / 2;
                answer += val1;
            } else {
                right = left + size / 2;
                answer += val2;
            }
            size /= 2;
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
8
1 3 10 9 6 2 3 2

 */