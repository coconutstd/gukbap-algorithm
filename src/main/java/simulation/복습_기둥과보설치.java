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

