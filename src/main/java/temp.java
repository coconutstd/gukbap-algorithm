import java.util.*;
import java.io.*;

public class temp {

    static int[] a = new int[]{1, 2, 3, 4, 5, 6};
    static int[] b = new int[a.length];

    public static void recur(int n){
        if(n == a.length){
            return;
        }
        if(n == 0){
            b[0] = a[0];
        } else {
            b[n] = b[n - 1] + a[n];
         }
        recur(n + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        recur(0);

        bw.flush();
        bw.close();
        br.close();
    }
}
