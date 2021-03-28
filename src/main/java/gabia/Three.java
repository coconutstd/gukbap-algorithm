package gabia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Coffee implements Comparable<Coffee>{
    int number;
    int time;

    public Coffee(int number, int time) {
        this.number = number;
        this.time = time;
    }

    @Override
    public int compareTo(Coffee c){
        if(this.time == c.time){
            return this.number - c.number;
        } else {
            return this.time - c.time;
        }
    }
}

public class Three {

    public static int[] solution(int N, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];
        int index = 0;

        PriorityQueue<Integer> coffeeMachine = new PriorityQueue<>();
        PriorityQueue<Coffee> coffee = new PriorityQueue<>();

        for(int i = 0; i < N; ++i){
            coffeeMachine.offer(0);
        }

        for(int i = 0; i < coffee_times.length; ++i){
            int fatestEndTime = coffeeMachine.poll();
            int completeTime = fatestEndTime + coffee_times[i];
            coffee.offer(new Coffee(i + 1, completeTime));
            coffeeMachine.offer(completeTime);
        }

        for(int i = 0; i < coffee_times.length; ++i){
            answer[i] = coffee.poll().number;
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

/*
import java.util.*;

class Solution {
   class Coffee implements Comparable<Coffee> {
       int number;
       int time;
       public Coffee(int number, int time) {
           this.number = number;
           this.time = time;
       }

      public int compareTo(Coffee c) {
         int comp = this.time - c.time;
         if (comp == 0) {
            comp = this.number - c.number;
         }
         return comp;
      }
   }

    public int[] solution(int N, int[] coffee_times) {
       int M = coffee_times.length;
       int[] answer = new int[M];
       PriorityQueue<Coffee> coffee_made_time = new PriorityQueue<>();
       PriorityQueue<Integer> coffee_machine = new PriorityQueue<>();

       for (int i = 0; i < N; i++) {
         coffee_machine.add(0);
      }

       for (int i = 0; i < M; i++) {
         int fastest_end_time = coffee_machine.poll();
         int end_time = fastest_end_time + coffee_times[i];
         coffee_made_time.add(new Coffee(i+1, end_time));
         coffee_machine.add(end_time);
      }

       for (int i = 0; i < M; i++) {
         answer[i] = coffee_made_time.poll().number;
      }

        return answer;
    }


    public static void main(String[] args) {
       int N = 3;
       int[] coffee_times = {4,2,2,5,3};
       Solution sol = new Solution();
      System.out.println(Arrays.toString(sol.solution(N, coffee_times)));
   }
}
 */