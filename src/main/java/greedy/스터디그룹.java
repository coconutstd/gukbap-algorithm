package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    int power;
    int[] list;
    public Student(int power, int[] list) {
        this.power = power;
        this.list = list;
    }

    @Override
    public int compareTo(Student o) {
        return this.power - o.power;
    }
}

public class 스터디그룹 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Student[] students = new Student[n];
        int[] algos = new int[k + 1];
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());
            int[] list = new int[num];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; ++j){
                list[j] = Integer.parseInt(st.nextToken());
            }
            students[i] = new Student(power, list);
        }
        Arrays.sort(students);

        for(int num : students[0].list){
            algos[num]++;
        }

        int answer = 0;
        int minIdx = 0, maxIdx = 0;
        for(int i = 1; i < n; ++i){
            maxIdx = i;
            while(students[maxIdx].power - students[minIdx].power > d){
                for(int num : students[minIdx].list){
                    algos[num]--;
                }
                minIdx++;
            }

            for(int num : students[maxIdx].list){
                algos[num]++;
            }

            int allKnow = 0;
            int sameKnow = 0;
            for(int j = 1; j <= k; ++j){
                if(algos[j] == 0) {
                    continue;
                } else if(algos[j] == maxIdx - minIdx + 1){
                    allKnow++;
                    sameKnow++;
                } else {
                    allKnow++;
                }
            }
            answer = Math.max(answer, (allKnow - sameKnow) * (maxIdx - minIdx + 1));
        }
        System.out.println(answer);
        br.close();
    }
}


/*
3 3 10
1 20
1
1 10
2
1 0
3
 */