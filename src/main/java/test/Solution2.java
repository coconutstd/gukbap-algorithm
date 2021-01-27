package test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*
 [7, 1, 2, 5] => 4
 [7, 5, 3, 1] => -1
 [2, 3, 10, 2, 4, 8, 1] => 8
 */

public class Solution2 {
    public static void main(String[] args) {
        List<Integer> px = new ArrayList<>(Arrays.asList(7, 1, 2, 5));
        assertEquals(maxDifference(px), 4);
        px = new ArrayList<>(Arrays.asList(7, 5, 3, 1));
        assertEquals(maxDifference(px), -1);
        px = new ArrayList<>(Arrays.asList(2, 3, 10, 2, 4, 8, 1));
        assertEquals(maxDifference(px), 8);
    }

    public static int maxDifference(List<Integer> px) {
        List<Integer> diffArray = new ArrayList<>();

        for(int i = 0; i < px.size(); ++i){
            int quote = px.get(i);
            for(int j = i - 1; j >= 0; --j){
                int earlier = px.get(j);
                if(quote > earlier) diffArray.add(quote - earlier);
            }
        }

        if(diffArray.size() == 0) return -1;

        int maxDiff = Collections.max(diffArray);
        return maxDiff;
    }
}
