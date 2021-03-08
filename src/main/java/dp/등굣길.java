//class Solution {
//
//    static int[][] puddle;
//    static int M, N, cnt;
//
//    static void findPathCount(int m, int n){
//        if(m > M || n > N) return;
//        if(m == M && n == N){
//            cnt++;
//            cnt %= 1000000007;
//            return;
//        }
//        for(int i = 0; i < puddle.length; ++i){
//            if(m == puddle[i][1] && n == puddle[i][0]) return;
//        }
//
//        findPathCount(m + 1, n);
//        findPathCount(m, n + 1);
//    }
//
//    public int solution(int m, int n, int[][] puddles) {
//        int answer = 0;
//        puddle = puddles;
//        M = m;
//        N = n;
//        findPathCount(1, 1);
//        return cnt;
//    }
//}