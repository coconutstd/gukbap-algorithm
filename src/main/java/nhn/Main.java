package nhn;
import java.util.Scanner;
import java.util.*;

class Main {
    private static int size;
    private static int bfs(int x, int y, int[][] matrix, int[][] visited){
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(x, y));
        visited[x][y] = 1;
        int[][] direc = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };
        int cnt = 1;

        while(!queue.isEmpty()){
            Coord cur = queue.poll();
            for(int i = 0; i < 4; ++i){
                int nx = cur.x + direc[i][0];
                int ny = cur.y + direc[i][1];
                if (0 <= nx && nx < size && 0 <= ny && ny < size && visited[nx][ny] == 0 && matrix[nx][ny] == 1){
                    visited[nx][ny] = 1;
                    cnt++;
                    queue.offer(new Coord(nx, ny));
                }
            }
        }
        return cnt;
    }

    private static void solution(int sizeOfMatrix, int[][] matrix) {
        Main.size = sizeOfMatrix;
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] visited = new int[sizeOfMatrix][sizeOfMatrix];
        int cnt = 0;

        for(int i = 0; i < sizeOfMatrix; ++i) {
            for(int j = 0; j < sizeOfMatrix; ++j) {
                if(matrix[i][j] == 1 && visited[i][j] == 0){
                    cnt++;
                    answer.add(bfs(i, j, matrix, visited));
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(answer);
        for(int i = 0; i < answer.size(); ++i){
            System.out.print(answer.get(i));
            System.out.print(" ");
        }
    }

    private static class Coord {
        int x, y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}