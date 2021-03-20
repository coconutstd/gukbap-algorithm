import java.util.*;
import java.io.*;

class Coord{
    int x, y;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    // 상, 하, 우,
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[m][n];
        ArrayList<Coord> startCoord = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            String input = br.readLine();
            for(int j = 0; j < n; ++j){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'c'){
                    startCoord.add(new Coord(i, j));
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(Coord start : startCoord){
            Coord[][] parent = new Coord[m][n];
            parent[start.x][start.y] = start;
            Queue<Coord> q = new LinkedList<>();
            q.offer(start);
            boolean[][] visit = new boolean[m][n];
            visit[start.x][start.y] = true;
            boolean check = false;
            Coord end = new Coord(start.x, start.y);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; ++i) {
                    Coord cur = q.poll();
                    if (cur.x == m - 1) {
                        check = true;
                        end = new Coord(cur.x, cur.y);
                        break;
                    }
                    for (int j = 0; j < 4; ++j) {
                        int nx = cur.x + dx[j];
                        int ny = cur.y + dy[j];
                        if (0 <= nx && nx < m && 0 <= ny && ny < n && !visit[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'c')) {
                            visit[nx][ny] = true;
                            q.offer(new Coord(nx, ny));
                            parent[nx][ny] = new Coord(cur.x, cur.y);
                        }
                    }
                }
                if (check) {
                    break;
                }
            }

            if(!check){
                bw.write(-1 + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            ArrayList<Coord> path = new ArrayList<>();
            while(check && !(parent[end.x][end.y].x == end.x && parent[end.x][end.y].y == end.y)){
                end = parent[end.x][end.y];
                path.add(end);
            }
            int cnt = 0;
            int cx = path.get(0).x;
            int cy = path.get(0).y;
            for(int i = 1; i < path.size(); ++i){
                if(path.get(i).y != cy){
                    cnt++;
                }
                cx = path.get(i).x;
                cy = path.get(i).y;
            }
            if(answer > cnt) answer = cnt;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
4 5
c.xc
....
xx..
...x
x..x
 */

