package nhn;
import java.util.*;

public class Main {
    public static void main(String[] args) {


    }

    private static int bfs(int x, int y, int[][] map, int[][] visited) {
        Queue<Coord> queue = new LinkedList<>();
        int[][] direc = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        int cnt = 0;

        queue.offer(new Coord(x, y));
        visited[x][y] = 1;

        while(!queue.isEmpty()) {
            Coord cur = queue.poll();
            for(int i = 0; i < 4; ++i){
                int nx = cur.x + direc[i][0];
                int ny = cur.y + direc[i][1];

            }
        }

    }

    private static class Coord{
        int x, y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
