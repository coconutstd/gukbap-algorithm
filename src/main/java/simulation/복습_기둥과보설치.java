package simulation;

import java.beans.PropertyEditorSupport;
import java.util.*;
import java.io.*;

class Frame{
    int x, y, a;
    public Frame(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return x == frame.x &&
                y == frame.y &&
                a == frame.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, a);
    }
}

public class 복습_기둥과보설치 {

    static boolean[][][] frame;
    static ArrayList<Frame> result = new ArrayList<Frame>();
    static int N;

    static boolean checkFrame(){
        for(int i = 0; i < result.size(); ++i){
            Frame cur = result.get(i);
            if(cur.a == 0){
                // 기둥이면
                if(cur.y == 0 || (cur.x - 1 >= 0 && frame[cur.x - 1][cur.y][1]) || frame[cur.x][cur.y][1] || (cur.y - 1 >= 0 && frame[cur.x][cur.y - 1][0])) continue;
                else return false;
            } else{
                // 보이면
                if(cur.x + 1 < N + 1 && cur.y - 1 >= 0 && frame[cur.x + 1][cur.y - 1][0]) continue;
                if(cur.y - 1 >= 0 && frame[cur.x][cur.y - 1][0]) continue;
                if(cur.x + 1 < N + 1 && cur.x - 1 >= 0 && frame[cur.x + 1][cur.y][1] && frame[cur.x - 1][cur.y][1]) continue;
                return false;
            }
        }
        return true;
    }

    public static int[][] solution(int n, int[][] build_frame) {
        N = n;
        frame = new boolean[n + 10][n + 10][2];
        for(int i = 0; i < build_frame.length; ++i){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            boolean check = false;
            if(b == 0){
                frame[x][y][a] = false;
                result.remove(result.indexOf(new Frame(x, y, a)));
                if(!checkFrame()){
                    result.add(new Frame(x, y, a));
                    frame[x][y][a] = true;
                }
            }else{
                frame[x][y][a] = true;
                result.add(new Frame(x, y, a));
                if(!checkFrame()){
                    frame[x][y][a] = false;
                    result.remove(result.size() - 1);
                }
            }
        }

        Collections.sort(result, (a, b) -> {
           if(a.x == b.x && a.y == b.y){
               return a.a - b.a;
           } else if(a.x == b.x){
               return a.y - b.y;
           } else{
               return a.x - b.x;
           }
        });

        int[][] answer = new int[result.size()][3];
        for(int i = 0; i < answer.length; ++i){
            answer[i][0] = result.get(i).x;
            answer[i][1] = result.get(i).y;
            answer[i][2] = result.get(i).a;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int[][] build_frame = new int[][]{
//                {1,0,0,1},
//                {1,1,1,1},
//                {2,1,0,1},
//                {2,2,1,1},
//                {5,0,0,1},
//                {5,1,0,1},
//                {4,2,1,1},
//                {3,2,1,1}
//        };
        int[][] build_frame = new int[][]{
                {0,0,0,1},
                {2,0,0,1},
                {4,0,0,1},
                {0,1,1,1},
                {1,1,1,1},
                {2,1,1,1},
                {3,1,1,1},
                {2,0,0,0},
                {1,1,1,0},
                {2,2,0,1},
                {6,0,0,1}
        };
        solution(5, build_frame);
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
n^2 시간복잡도

정확성  테스트
테스트 1 〉	통과 (1.07ms, 52.2MB)
테스트 2 〉	통과 (3.83ms, 52.2MB)
테스트 3 〉	통과 (1.12ms, 52.4MB)
테스트 4 〉	통과 (1.20ms, 52.6MB)
테스트 5 〉	통과 (1.32ms, 53.4MB)
테스트 6 〉	통과 (1.65ms, 53.1MB)
테스트 7 〉	통과 (1.02ms, 52.3MB)
테스트 8 〉	통과 (1.02ms, 52.5MB)
테스트 9 〉	통과 (1.08ms, 52.3MB)
테스트 10 〉	통과 (10.67ms, 55MB)
테스트 11 〉	통과 (21.68ms, 56.7MB)
테스트 12 〉	통과 (8.69ms, 53.2MB)
테스트 13 〉	통과 (26.74ms, 57.4MB)
테스트 14 〉	통과 (24.59ms, 54.9MB)
테스트 15 〉	통과 (19.17ms, 55MB)
테스트 16 〉	통과 (12.23ms, 54.1MB)
테스트 17 〉	통과 (23.94ms, 54.1MB)
테스트 18 〉	통과 (18.60ms, 54.2MB)
테스트 19 〉	통과 (22.28ms, 54.5MB)
테스트 20 〉	통과 (17.04ms, 54.1MB)
테스트 21 〉	통과 (20.70ms, 53.7MB)
테스트 22 〉	통과 (15.45ms, 53.8MB)
테스트 23 〉	통과 (18.69ms, 54.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */

