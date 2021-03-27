package scofe2;

import java.util.*;
import java.io.*;

class Music{
    int time;
    int number;
    public Music(int time, int number) {
        this.time = time;
        this.number = number;
    }
}

public class One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String t = st.nextToken();
        int exerciseTime = Integer.parseInt(t.substring(0, 2)) * 3600 + Integer.parseInt(t.substring(3, 5)) * 60 + Integer.parseInt(t.substring(6, 8));

        ArrayList<Music> times = new ArrayList<>();
        for(int i = 1; i < n + 1; ++i){
            t = br.readLine();
            int music = Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3, 5));
            times.add(new Music(music, i));
        }
        int start = Integer.MAX_VALUE;
        int cnt = 0;
        int maxValue = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 1; i < n + 1; ++i){
            int j = i;
            int startJ = j;
            int remain = exerciseTime;
            cnt = 0;
            while(j - 1 != n && remain > 0){
                cnt++;
                remain -= times.get(j - 1).time;
                j++;
            }
            if(cnt > maxValue) {
                start = startJ;
                maxValue = cnt;
            }
        }

        bw.write(maxValue + " " + start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
7 00:05:48
02:14
03:34
02:34
03:45
05:43
01:34
02:33
 */