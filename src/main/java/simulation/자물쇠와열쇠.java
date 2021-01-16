package simulation;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class 자물쇠와열쇠 {
    public static void main(String[] args){
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        assertEquals(solution(key, lock), true);
    }

    public static int[][] rotate(int[][] key){
        int[][] ret = new int[key.length][key.length];
        int n = ret.length;
        for(int i = 0; i < ret.length; ++i){
            for(int j = 0; j < ret.length; ++j){
                ret[i][j] = key[n - 1 - j][i];
            }
        }
        return ret;
    }

    public static boolean check(int[][] lock){
        boolean ret = true;
        for (int i = 0; i < lock.length; ++i) {
            for (int j = 0; j < lock.length; ++j) {
                if (lock[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] copyKey = key.clone();
        for(int rotate = 0; rotate < 4; ++rotate) {
            copyKey = rotate(copyKey);
            for (int i = 0; i < lock.length; ++i) {
                for (int j = 0; j < lock.length; ++j) {
                    int[][] copyLock = Arrays.stream(lock).map(int[]::clone).toArray(int[][]::new);
                    for (int startI = i, keyI = 0; startI < lock.length && keyI < key.length; ++startI, ++keyI) {
                        for (int startJ = j, keyJ = 0; startJ < lock.length && keyJ < key.length; ++startJ, ++keyJ) {
                            if(copyKey[keyI][keyJ] == 1 && copyLock[startI][startJ] == 1){
                                copyLock[startI][startJ] = 0;
                                break;
                            }
                            if(copyKey[keyI][keyJ] == 1 && copyLock[startI][startJ] == 0){
                                copyLock[startI][startJ] = 1;
                            }
                        }
                    }
                    //check
                    if(check(copyLock)){
                        System.out.println(i + " " + j);
                        for(int k = 0; k < copyLock.length; ++k){
                            for(int l = 0; l < copyLock.length; ++l){
                                System.out.print(copyKey[k][l]);
                            }
                            System.out.println();
                        }
                        System.out.println("");
                        for(int k = 0; k < copyLock.length; ++k){
                            for(int l = 0; l < copyLock.length; ++l){
                                System.out.print(copyLock[k][l]);
                            }
                            System.out.println();
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
