package test;

import static org.junit.Assert.assertEquals;

public class Solution1 {
    public static void main(String[] args) {
        assertEquals(addNumbers(2.3f, 1.9f), 4);
    }
    public static int addNumbers(float a, float b) {
        // Write your code here
        int floorSum = (int) (a + b);
        return floorSum;
    }
}
