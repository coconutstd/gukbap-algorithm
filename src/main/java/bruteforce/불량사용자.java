package bruteforce;

import java.util.*;
import java.io.*;

class Permutation{
    private int n, r;
    private String[] now;
    private ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new String[r];
        this.result = new ArrayList<>();
    }

    public void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(String[] arr, int depth){
        if(depth == r){
            ArrayList<String> temp = new ArrayList<>();
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

public class 불량사용자 {

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        Permutation perm = new Permutation(user_id.length, banned_id.length);
        perm.permutation(user_id, 0);
        ArrayList<ArrayList<String>> result = perm.getResult();
        
        Set<ArrayList<String>> list = new HashSet<>();
        for(int i = 0; i < result.size(); ++i){
            boolean check = true;
            for(int j = 0; j < result.get(i).size(); ++j){
                String id = result.get(i).get(j);
                String ban = banned_id[j];
                for(int k = 0; k < ban.length(); ++k){
                    if(id.length() > ban.length() || k >= id.length() || ban.charAt(k) != '*' && ban.charAt(k) != id.charAt(k)){
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                Collections.sort(result.get(i));
                list.add(result.get(i));
            }
        }
        answer = list.size();
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannded_id = new String[]{"*rodo", "*rodo", "******"};
        solution(user_id, bannded_id);
        bw.flush();
        bw.close();
        br.close();
    }
}

