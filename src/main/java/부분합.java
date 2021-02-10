import java.util.Scanner;

public class 부분합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        final int INF = (int) 1e9;
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; ++i){
            arr[i] = sc.nextInt();
        }
        int low = 0;
        int high = 0;
        int sum = arr[low];
        int answer = INF;
        while(low <= high && high < n){
            if(sum < s){
                sum += arr[++high];
            } else if (sum == s){
                answer = Math.min(answer, (high - low + 1));
                sum += arr[++high];
            } else {
                answer = Math.min(answer, (high - low + 1));
                sum -= arr[low];
                low++;
            }
        }
        if(answer == INF){
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
