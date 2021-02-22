package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 통나무건너뛰기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int t = 0; t < testCase; ++t){
            int n = sc.nextInt();
            int[] arr = new int[n];

            int left = 0, right = n - 1;
            for(int i = 0; i < n; ++i){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int answer = 0;
            for(int i = 0, j = 1; i < n - 1; i += 2, j += 2){
                int diff1 = Math.abs(arr[i + 2] - arr[i]);
                int diff2 = 0;
                if(j + 2 >= n){
                    diff2 = Math.abs(arr[n - 1] - arr[j]);
                } else {
                    diff2 = Math.abs(arr[j + 2] - arr[j]);
                }
                if(diff1 > answer){
                    answer = diff1;
                }
                if(diff2 > answer){
                    answer = diff2;
                }

            }
            System.out.println(answer);

        }
    }
}


/*
3
7
13 10 12 11 10 11 12
5
2 4 5 7 9
8
6 6 6 6 6 6 6 6
 */