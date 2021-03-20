package 스코페;

import java.util.*;
import java.io.*;

class Info{
    char genre;
    int priority;
    double score;
    int x, y;
    public Info(char genre, int priority, double score, int x, int y) {
        this.genre = genre;
        this.priority = priority;
        this.score = score;
        this.x = x;
        this.y = y;
    }
}

public class Four {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double[] scores = new double[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; ++i){
            scores[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] contents = new char[n][m];
        for(int i = 0; i < n; ++i){
            String input = br.readLine();
            for(int j = 0; j < m; ++j){
                contents[i][j] = input.charAt(j);
            }
        }

        char[][] tag = new char[n][m];
        for(int i = 0; i < n; ++i){
            String input = br.readLine();
            for(int j = 0; j < m; ++j){
                tag[i][j] = input.charAt(j);
            }
        }

        ArrayList<Info> answer = new ArrayList<>();

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(contents[i][j] == 'W') continue;
                else if(contents[i][j] == 'Y'){
                    answer.add(new Info(tag[i][j],0, scores[tag[i][j] - 'A'] ,i, j));
                } else if(contents[i][j] == 'O'){
                    answer.add(new Info(tag[i][j],1, scores[tag[i][j] - 'A'] ,i, j));
                }
            }
        }

        Collections.sort(answer, (a, b) -> {
            if(a.priority == b.priority){
                if(a.score == b.score){
                    if(a.x == b.x){
                        return a.y - b.y;
                    } else return a.x - b.x;
                } else return Double.compare(b.score, a.score);
            } else return a.priority - b.priority;
        });

        for(Info i : answer){
            bw.write(i.genre + " " + i.score + " " + i.x + " " + i.y + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


/*
4.0 3.0 2.1 4.3 5.0
2 3
WYO
YYO
ABC
DCE
 */
