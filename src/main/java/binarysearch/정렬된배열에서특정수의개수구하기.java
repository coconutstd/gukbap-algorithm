package binarysearch;

public class 정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) {
        int n = 7, x = 4;
        int[] arr = {1, 1, 2, 2, 2, 2, 3};

        int left = 0;
        int right = n - 1;

        boolean check = false;
        int leftIndex = 0;
        while(left <= right){
            int mid = (int) (left + right) / 2;
            if((mid == 0 || arr[mid - 1] < x) && arr[mid] == x){
                leftIndex = mid;
                check = true;
                break;
            // 찾는 값과 같지만 제일 왼쪽 값이 아닐 경우 왼쪽으로 이동
            } else if(arr[mid] >= x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = n - 1;
        int rightIndex = 0;
        while(left <= right){
            int mid = (int) (left + right) / 2;
            if((mid == n - 1 || arr[mid + 1] > x) && arr[mid] == x){
                rightIndex = mid;
                break;
            } else if(arr[mid] > x){
                right = mid - 1;
            // 찾는 값과 같지만 제일 오른쪽 값이 아닌 경우 오른쪽으로 이동
            } else {
                left = mid + 1;
            }
        }

        if(!check) {
            System.out.println(-1);
            return;
        }
        System.out.println(rightIndex - leftIndex + 1);
    }
}
