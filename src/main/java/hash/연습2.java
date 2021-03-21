package hash;

import java.util.*;
import java.io.*;

public class 연습2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> hashmap = new HashMap<>();

        String special = "~!@#$%^&*";
        for(int i = 0; i < 26; ++i){
             hashmap.put((char)('a' + i), 0);
             hashmap.put((char)('A' + i), 0);
        }
         for(int i = 0; i < 10; ++i){
             hashmap.put((char)('0' + i), 0);
         }
         for(int i = 0; i < special.length(); ++i){
             hashmap.put(special.charAt(i), 0);
         }

        bw.flush();
        bw.close();
        br.close();
    }
}

