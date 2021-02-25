package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Station {
    int loc, fuel;
    public Station(int loc, int fuel) {
        this.loc = loc;
        this.fuel = fuel;
    }
}

public class 연료채우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Station[] stations = new Station[N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());
            stations[i] = new Station(loc, fuel);
        }
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Arrays.sort(stations, (a, b) -> {
            return a.loc - b.loc;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;
        int index = 0;
        while(P < L){
            while(index < N && stations[index].loc <= P){
                pq.offer(stations[index].fuel);
                index++;
            }
            if(pq.isEmpty()) break;
            answer++;
            P += pq.poll();
        }
        if(P < L){
            bw.write(-1 + "\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
4
4 4
5 2
11 5
15 10
25 10
 */
