package XorRangeMultiply;

public class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int increment = query[2];
            int multiply = query[3];
            for (int i = left; i <= right; i += increment) {
                nums[i] = (int) (((long) nums[i] * multiply) % 1000000007);
            }
        }
        

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}