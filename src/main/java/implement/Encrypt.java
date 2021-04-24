package implement;

import java.util.*;
import java.io.*;

public class Encrypt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String sentence = "encrypt this sentence";
//        String keyword = "something";
//        int[] skips = {0, 1, 3, 2, 1, 2, 0, 3, 0, 2, 4, 1, 3};

        String sentence = "i love coding";
        String keyword = "model";
        int[] skips = {0, 10};
        String answer = "";

        int prev = 0;
        int next = 0;
        int index = 0;
        for(int i = 0; i < skips.length; ++i){
            next += skips[i];
            if(next > sentence.length())
                break;
            boolean pauseCheck = false;
            int pause = 0;
            for(int j = prev; j < next; ++j) {
                if (sentence.charAt(j) == keyword.charAt(index)) {
                    pause = j;
                    pauseCheck = true;
                    break;
                }
            }

            if(pauseCheck){
                answer += sentence.substring(prev, pause + 1) + keyword.charAt(index);
                if(pause < next)
                answer += sentence.substring(pause + 1, next);
            } else {
                answer += sentence.substring(prev, next) + keyword.charAt(index);
            }
            index = (index + 1) % keyword.length();
            prev = next;
        }

        if(next < sentence.length()){
            answer += sentence.substring(next, sentence.length());
        }

        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}

