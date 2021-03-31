package simulation;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

class Permutation{
    private int n, r;
    private int[] now;
    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth){
        if(depth == r){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < now.length; ++i){
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for(int i = depth; i < n; ++i){
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

public class 외벽점검 {

    public static int solution(int n, int[] weak, int[] dist) {
        int answer = dist.length + 1;
        ArrayList<Integer> weakList = new ArrayList<>();
        for(int i = 0; i < weak.length; ++i) weakList.add(weak[i]);
        for(int i = 0; i < weak.length; ++i) weakList.add(weak[i] + n);

        Permutation perm = new Permutation(dist.length, dist.length);
        perm.permutation(dist, 0);
        ArrayList<ArrayList<Integer>> distList = perm.getResult();

        for(int start = 0; start < weak.length; ++start){
            for(int i = 0; i < distList.size(); ++i){
                int cnt = 1;
                int position = distList.get(i).get(cnt - 1) + weakList.get(start);

                for(int index = start; index < start + weak.length; ++index){
                    if(position < weakList.get(index)){
                        cnt++;
                        if(cnt > dist.length)
                            break;
                        position = distList.get(i).get(cnt - 1) + weakList.get(index);
                    }
                }
                answer = Math.min(answer, cnt);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] weak = new int[]{1, 5, 6, 10};
        int[] dist = new int[]{1, 2, 3, 4};
        bw.write(solution(12, weak, dist));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

 */

