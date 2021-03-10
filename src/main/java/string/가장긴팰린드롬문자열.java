package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 가장긴팰린드롬문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = new String(br.readLine());

        char[] chr = s.toCharArray();

        // 가장 긴 문자열부터 팰린드롬 검사
        for (int leng = s.length(); leng > 1; leng--) {

            // 시작 인덱스
            for (int start = 0; start + leng <= s.length(); start++) {
                boolean chk = true;

                // 처음부터 문자열 길이의 반틈만큼 문자가 같은지 비교
                for (int i = 0; i < leng/2; i++) {
                    if (chr[start + i] != chr[start + leng  - i - 1]) {
                        chk = false;
                        break;
                    }
                }

                if (chk) {
                    bw.write(leng + "\n");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }

        bw.write(1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
abab
 */
