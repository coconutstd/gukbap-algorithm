package kakao;

import java.util.*;

public class 신규아이디추천 {
    public static void main(String[] args) {
        String input_param = "...!@BaT#*..y.abcdefghijklm";
        solution(input_param);
    }
    public static String solution(String new_id) {
        String answer = "";
        String processing_id = new_id;
        processing_id.toLowerCase();

        String temp_id = "";
        for(int i = 0; i < processing_id.length(); ++i){
            Character ch = processing_id.charAt(i);
//            if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9' || ch == '-' || ch == '_' || ch == '.') {
//                temp_id += ch;
//            }
        }
        System.out.println(temp_id);
        return answer;
    }
}
