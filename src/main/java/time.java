public class time {
    public static void main(String[] args){
        long beforeTime = System.currentTimeMillis();

        int N = (int)1e5;
        int sum = 0;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                sum += i;
            }
        }
        System.out.println(sum);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("time : " + secDiffTime);
    }
}
