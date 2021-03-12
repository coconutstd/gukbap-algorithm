package hash;

import java.util.*;
import java.io.*;

public class 연습 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();

        char[] c = {'a', 'b', 'c', 'd'};

        for(char ch : c){
            ArrayList<Character> list = new ArrayList<>();
            map.put(ch, list);
        }

        for(Map.Entry<Character, ArrayList<Character>> entry : map.entrySet()){
            bw.write(entry.getKey() + " : " + entry.getValue().size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
