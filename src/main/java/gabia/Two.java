package gabia;

import java.util.*;
import java.io.*;

public class Two {
    public static int solution(String s){
        int answer = 0;
        Set<Character> set = new HashSet<>();
        Set<String> subStringSet = new HashSet<>();
        for(int i = 0; i < s.length(); ++i) set.add(s.charAt(i));
        answer = set.size();
        int size = s.length();
        boolean[] alpha = new boolean[26];
        for(int len = s.length(); len >= 2; --len){
            for(int start = 0; start <= size - len; ++start){
                boolean check = true;
                for(int i = start; i < start + len; ++i){
                    if(!alpha[s.charAt(i) - 'a']){
                        alpha[s.charAt(i) - 'a'] = true;
                    }else{
                        check = false;
                        break;
                    }
                }
                String temp = s.substring(start, start + len);
                if(check && !subStringSet.contains(temp)){
                    answer++;
                    subStringSet.add(temp);
                }
                alpha = new boolean[26];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solution("zxzxz") + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

