
package simulation;

import soma.B;

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

class Traffic{
    int start, end;
    public Traffic(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class 추석트래픽 {

    public static int solution(String[] lines){
        int answer = 0;
        if(lines.length == 1) return 1;
        int len = lines.length;
        StringTokenizer st;
        Traffic[] traffic = new Traffic[len];
        for(int i = 0; i < len; ++i){
            st = new StringTokenizer(lines[i]);
            st.nextToken();
            String S = st.nextToken();
            String T = st.nextToken();
            int time = Integer.parseInt(S.substring(0, 2)) * 3600 * 1000 + Integer.parseInt(S.substring(3, 5)) * 60 * 1000 + (int)(Double.parseDouble(S.substring(6, S.length())) * 1000);
            int t = (int)(Double.parseDouble(T.substring(0, T.length() - 1)) * 1000);
            traffic[i] = new Traffic(time - t + 1, time);
        }
        Arrays.sort(traffic, (a, b) -> {
            return a.start - b.start;
        });
        int left = 0, right = 1;
        int cnt = 1;
        int slideStart = traffic[0].start;
        int slideEnd = traffic[0].start + 1000 - 1;
        while(left < len && right < len){
            if((traffic[right].start < slideStart && traffic[right].end < slideStart) || (traffic[right].start > slideEnd && traffic[right].end > slideEnd)){
                cnt--;
                left++;
                if(left != len){
                    slideStart = traffic[left].start;
                    slideEnd = slideStart + 1000 - 1;
                }
            } else {
                cnt++;
                if(cnt > answer) answer = cnt;
                right++;
            }
        }

        Arrays.sort(traffic, (a, b) -> {
            return a.end - b.end;
        });
        left = 0;
        right = 1;
        cnt = 1;
        slideStart = traffic[0].end;
        slideEnd = traffic[0].end + 1000 - 1;
        while(left < len && right < len){
            if((traffic[right].start < slideStart && traffic[right].end < slideStart) || (traffic[right].start > slideEnd && traffic[right].end > slideEnd)){
                cnt--;
                left++;
                if(left != len){
                    slideStart = traffic[left].end;
                    slideEnd = slideStart + 1000 - 1;
                }
            } else {
                cnt++;
                if(cnt > answer) answer = cnt;
                right++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = new String[]{"2016-09-15 21:00:03.000 0.0s", "2016-09-15 21:00:03.000 0.0s", "2016-09-15 21:00:2.400 0.0s"};
        bw.write(solution(input) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

