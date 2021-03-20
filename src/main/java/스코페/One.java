package 스코페;

import java.util.*;
import java.io.*;

public class One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int startMax = Integer.MIN_VALUE;
        int endMin = Integer.MAX_VALUE;
        String MaxTime = "";
        String MinTime = "";
        for(int i = 0; i < N; ++i){
            String input = br.readLine();
            int startTime = 0, endTime = 0;

            startTime += (input.charAt(0) - '0') * 1000;
            startTime += (input.charAt(1) - '0') * 100;
            startTime += (input.charAt(3) - '0') * 10;
            startTime += (input.charAt(4) - '0') * 1;
            endTime += (input.charAt(8) - '0') * 1000;
            endTime += (input.charAt(9) - '0') * 100;
            endTime += (input.charAt(11) - '0') * 10;
            endTime += (input.charAt(12) - '0') * 1;
            if(startTime > startMax) {
                startMax = startTime;
                MaxTime = "";
                for(int j = 0; j < 5; ++j){
                    MaxTime += input.charAt(j);
                }
            }
            if(endTime < endMin) {
                endMin = endTime;
                MinTime = "";
                for(int j = 8; j < 13; ++j){
                    MinTime += input.charAt(j);
                }
            }
        }
        if(endMin < startMax){
            bw.write(-1 + "\n");
        } else {
            bw.write(MaxTime + " ~ " + MinTime);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
3
12:00 ~ 23:59
11:00 ~ 18:00
14:00 ~ 20:00
 */

