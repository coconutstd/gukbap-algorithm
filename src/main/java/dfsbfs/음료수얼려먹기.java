package dfsbfs;

import static org.junit.Assert.assertEquals;

public class 음료수얼려먹기 {
    public static void main(String[] args) {
        n = 4;
        m = 5;
        assertEquals(solve(input, 4, 5), 3);
    }
    static int[][] input = new int[][]{
            {0, 0, 1, 1, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
    };
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int n;
    private static int m;


    public static void dfs(int x, int y, int[][] visit) {
        if(x < 0 || x >= n || y < 0 || y >= m ) return;
        if(input[x][y] == 1) return;

        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && visit[nx][ny] == 0){
                visit[nx][ny] = 1;
                dfs(nx, ny, visit);
            }
        }
    }

    public static int solve(int[][] input, int n, int m){
        int answer = 0;
        int[][] visit = new int[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(visit[i][j] == 0 && input[i][j] == 0) {
                    answer++;
                    dfs(i, j, visit);
                }
            }
        }
        return answer;
    }
}
