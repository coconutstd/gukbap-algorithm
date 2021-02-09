package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Class implements Comparable<Class>{
    int s, t;
    public Class(int s, int t){
        this.s = s;
        this.t = t;
    }

    public int compareTo(Class o){
        return this.t - o.t;
    }
}

public class 강의실배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Class> meetings = new ArrayList<>();
        PriorityQueue<Class> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n; ++i){
            int s = sc.nextInt();
            int t = sc.nextInt();
            meetings.add(new Class(s, t));
        }
        Collections.sort(meetings, (a, b) -> {
            return a.s - b.s;
        });
        int answer = 1;
        pq.offer(meetings.get(0));
        for(int i = 1; i < n; ++i){
            if(pq.peek().t > meetings.get(i).s){
                pq.offer(meetings.get(i));
                answer++;
            } else {
                pq.poll();
                pq.offer(meetings.get(i));
            }
        }
        System.out.println(answer);
    }
}
