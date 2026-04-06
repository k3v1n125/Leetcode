package ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        int[] movements = new int[n + 1];
        movements[0] = 1;
        movements[1] = 1;

        for (int i = 2; i <= n; i++) {
            movements[i] = movements[i - 1] + movements[i - 2];
        }

        return movements[n];
    }
}
