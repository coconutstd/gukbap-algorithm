package greedy;

import java.util.*;
import java.io.*;

class Food implements Comparable<Food>{
    int time, number;

    public Food(int time, int number) {
        this.time = time;
        this.number = number;
    }

    @Override
    public int compareTo(Food o) {
        return this.time - o.time;
    }
}

public class 복습_무지의먹방라이브 {

    public static int solution(int[] food_times, long k) {
        long total = 0;
        for(int i = 0; i < food_times.length; ++i){
            total += food_times[i];
        }
        if(total <= k) return - 1;
        PriorityQueue<Food> q = new PriorityQueue<>();
        for(int i = 0; i < food_times.length; ++i){
            q.offer(new Food(food_times[i], i + 1));
        }

        total = 0;
        long prev = 0;
        long len = food_times.length;

        while(total + ((q.peek().time - prev) * len) <= k){
            int now = q.poll().time;
            total += (now - prev) * len;
            len--;
            prev = now;
        }

//        ArrayList<Food> result = new ArrayList<>();
//        while(!q.isEmpty()){
//            result.add(q.poll());
//        }
//        Collections.sort(result, new Comparator<Food>() {
//            @Override
//            public int compare(Food a, Food b) {
//                return Integer.compare(a.number, b.number);
//            }
//        });

        Food[] result2 = q.stream().sorted((a, b) -> {
            return a.number - b.number;
        }).toArray(Food[]::new);

        return result2[(int)((k - total) % len)].number;

//        return result.get((int)((k - total) % len)).number;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = new int[]{3, 1, 2, 2};
        solution(input, 5);
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
스트림이 평균적으로 느린 성능, 다만 효율성 테스트에서는 빠름
 */
/*
스트림 사용했을
정확성  테스트
테스트 1 〉	통과 (13.58ms, 54.8MB)
테스트 2 〉	통과 (6.09ms, 52MB)
테스트 3 〉	통과 (3.77ms, 52.3MB)
테스트 4 〉	통과 (8.62ms, 52.3MB)
테스트 5 〉	통과 (3.73ms, 52.6MB)
테스트 6 〉	통과 (8.53ms, 53.2MB)
테스트 7 〉	통과 (11.53ms, 52.2MB)
테스트 8 〉	통과 (7.06ms, 53MB)
테스트 9 〉	통과 (16.73ms, 52.9MB)
테스트 10 〉	통과 (8.57ms, 52.1MB)
테스트 11 〉	통과 (6.87ms, 52.6MB)
테스트 12 〉	통과 (6.11ms, 54.2MB)
테스트 13 〉	통과 (5.17ms, 52.9MB)
테스트 14 〉	통과 (13.43ms, 53.6MB)
테스트 15 〉	통과 (6.67ms, 53.2MB)
테스트 16 〉	통과 (0.03ms, 52.3MB)
테스트 17 〉	통과 (17.94ms, 53.5MB)
테스트 18 〉	통과 (8.21ms, 52.4MB)
테스트 19 〉	통과 (0.02ms, 52MB)
테스트 20 〉	통과 (0.02ms, 52.1MB)
테스트 21 〉	통과 (5.80ms, 53MB)
테스트 22 〉	통과 (3.76ms, 52.5MB)
테스트 23 〉	통과 (0.02ms, 52.9MB)
테스트 24 〉	통과 (13.00ms, 52.9MB)
테스트 25 〉	통과 (9.60ms, 53.7MB)
테스트 26 〉	통과 (12.26ms, 53.1MB)
테스트 27 〉	통과 (14.62ms, 54.3MB)
테스트 28 〉	통과 (3.31ms, 53.2MB)
테스트 29 〉	통과 (9.74ms, 53.3MB)
테스트 30 〉	통과 (9.06ms, 52.6MB)
테스트 31 〉	통과 (8.67ms, 52.6MB)
테스트 32 〉	통과 (3.28ms, 53.4MB)
효율성  테스트
테스트 1 〉	통과 (178.35ms, 73.6MB)
테스트 2 〉	통과 (51.98ms, 70.6MB)
테스트 3 〉	통과 (155.97ms, 72MB)
테스트 4 〉	통과 (170.26ms, 71.9MB)
테스트 5 〉	통과 (188.62ms, 73.6MB)
테스트 6 〉	통과 (173.92ms, 73.7MB)
테스트 7 〉	통과 (177.73ms, 72.9MB)
테스트 8 〉	통과 (164.25ms, 73.9MB)
 */

/*
ArrayList 사용했을
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (1.13ms, 52.1MB)
테스트 2 〉	통과 (1.23ms, 53.2MB)
테스트 3 〉	통과 (1.18ms, 53MB)
테스트 4 〉	통과 (1.21ms, 52.1MB)
테스트 5 〉	통과 (0.99ms, 52.7MB)
테스트 6 〉	통과 (1.22ms, 51.9MB)
테스트 7 〉	통과 (1.12ms, 52.6MB)
테스트 8 〉	통과 (1.05ms, 53.1MB)
테스트 9 〉	통과 (1.22ms, 52.7MB)
테스트 10 〉	통과 (1.26ms, 52.2MB)
테스트 11 〉	통과 (1.19ms, 53.5MB)
테스트 12 〉	통과 (1.15ms, 52.6MB)
테스트 13 〉	통과 (1.23ms, 51.6MB)
테스트 14 〉	통과 (1.16ms, 52.8MB)
테스트 15 〉	통과 (1.05ms, 51.8MB)
테스트 16 〉	통과 (0.02ms, 52.6MB)
테스트 17 〉	통과 (1.03ms, 53MB)
테스트 18 〉	통과 (1.31ms, 52.7MB)
테스트 19 〉	통과 (0.02ms, 53MB)
테스트 20 〉	통과 (0.02ms, 53.2MB)
테스트 21 〉	통과 (3.04ms, 52.2MB)
테스트 22 〉	통과 (1.81ms, 52.1MB)
테스트 23 〉	통과 (0.03ms, 53MB)
테스트 24 〉	통과 (7.08ms, 53MB)
테스트 25 〉	통과 (6.53ms, 52.5MB)
테스트 26 〉	통과 (8.51ms, 52.9MB)
테스트 27 〉	통과 (6.86ms, 53.2MB)
테스트 28 〉	통과 (1.21ms, 51.7MB)
테스트 29 〉	통과 (1.24ms, 53MB)
테스트 30 〉	통과 (1.10ms, 52.7MB)
테스트 31 〉	통과 (1.16ms, 52.9MB)
테스트 32 〉	통과 (1.02ms, 52.6MB)
효율성  테스트
테스트 1 〉	통과 (244.40ms, 74.3MB)
테스트 2 〉	통과 (59.97ms, 72MB)
테스트 3 〉	통과 (166.73ms, 71.9MB)
테스트 4 〉	통과 (207.21ms, 73.6MB)
테스트 5 〉	통과 (254.58ms, 74.2MB)
테스트 6 〉	통과 (248.12ms, 74.6MB)
테스트 7 〉	통과 (223.05ms, 74.3MB)
테스트 8 〉	통과 (277.30ms, 75.6MB)
채점 결과
정확성: 42.9
효율성: 57.1
합계: 100.0 / 100.0
 */

