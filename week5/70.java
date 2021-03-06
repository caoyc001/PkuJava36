public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int prev = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current + prev;
            prev = current;
            current = temp;
        }
        return current;      
    }
}