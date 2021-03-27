package gabia;

import java.util.*;
import java.io.*;

class Coffee{
    int number;
    int time;
    public Coffee(int number, int time) {
        this.number = number;
        this.time = time;
    }
}

public class Three {

    public static int[] solution(int N, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];
        int index = 0;
        PriorityQueue<Coffee> heap = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time){
                return a.number - b.number;
            } else return a.time - b.time;
        });
        Queue<Coffee> queue = new LinkedList<>();
        int curTime = Integer.MAX_VALUE;
        for(int i = 0; i < coffee_times.length; ++i){
            if(coffee_times[i] < curTime) curTime = coffee_times[i];
            queue.offer(new Coffee(i + 1, coffee_times[i]));
        }
        boolean check = false;

        for(int i = 0; i < N; ++i){
            heap.offer(queue.poll());
        }

        while(!queue.isEmpty() && !heap.isEmpty()){
            Coffee coffee = heap.poll();
            answer[index++] = coffee.number;
            int tempTime = coffee.time;
            while(!heap.isEmpty() && coffee.time == heap.peek().time){
                answer[index++] = heap.poll().number;
            }
            if(!heap.isEmpty()){
                int min = heap.peek().time;
                while(!queue.isEmpty() && !heap.isEmpty() && min - tempTime > queue.peek().time){
                    answer[index++] = queue.poll().number;
                }
                while(!queue.isEmpty() && heap.size() != N){
                    heap.offer(queue.poll());
                }
            }
        }

        while(!heap.isEmpty()){
            answer[index++] = heap.poll().number;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = new int[]{4, 2, 2, 5, 3};
        solution(3, input);
        bw.flush();
        bw.close();
        br.close();
    }
}

