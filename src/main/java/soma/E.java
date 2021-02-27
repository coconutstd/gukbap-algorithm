package soma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = n * n;

        HashMap<Integer, ArrayList<Integer>> secondsInfo = new HashMap<>();

        for(int i = 0; i < size; ++i){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int iter = Integer.parseInt(st.nextToken());
            for(int j = 0; j < iter; ++j){
                int second = Integer.parseInt(st.nextToken());
                if(!secondsInfo.containsKey(second)){
                    secondsInfo.put(second, new ArrayList<>());
                    secondsInfo.get(second).add(k);
                } else {
                    secondsInfo.get(second).add(k);
                }
            }
        }
        int answer = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : secondsInfo.entrySet()){
            int maxVal = Integer.MIN_VALUE;
            ArrayList<Integer> game = entry.getValue();
            for(int i = 0; i < game.size(); ++i){
                if(maxVal < game.get(i)) maxVal = game.get(i);
            }
            answer += maxVal;
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
2
1 3 1 3 5
2 2 2 4
3 2 1 2
4 1 3
 */
