package 스코페;

import java.util.*;
import java.io.*;

public class Three {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; ++i){
            String input = br.readLine();
            for(int j = 0; j < N; ++j){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int size = 1; size <= N; ++size){
            int sum = 0;
            for(int i = 0; i <= N - size; ++i){
                for(int j = 0; j <= N - size; ++j){
                    boolean check = true;
                    for(int x = i; x < i + size; ++x){
                        for(int y = j; y < j + size; ++y){
                            if(map[x][y] == 0){
                                check = false;
                            }
                        }
                    }

                    if(check){
                        sum++;
                    }
                }
            }
            answer.add(sum);
        }
        int total = 0;
        for(Integer a : answer){
            total += a;
        }
        bw.write("total: " + total + "\n");
        for(int i = 0; i < answer.size(); ++i){
            if(answer.get(i) != 0)
                bw.write("size[" + (i + 1) + "]: " + answer.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
4
1110
1110
0110
0000
 */

