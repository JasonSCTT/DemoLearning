package com.jdk;

/**
 * @author jason
 */
public class TestArray {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(a));
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[0] = dp[0] + grid[i][0];           // 只能从上侧走到该位置
                else if (i == 0) dp[j] = dp[j - 1] + grid[0][j];  // 只能从右侧走到该位置
                else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
