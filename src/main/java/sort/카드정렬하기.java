package sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; ++i){
            pq.add(sc.nextInt());
        }
        if(pq.size() == 1){
            System.out.println("0");
            return;
        }
        int answer = 0;
        while(pq.size() > 1){
            int sum = pq.poll() + pq.poll();
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
