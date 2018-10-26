package com.leetcode;

/**
 * @author jason
 */
public class liantongliang {
    public static void main(String[] args) {
        int[][] grids = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        new liantongliang().dfs(grids, 0, 0);
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                System.out.print(grids[i][j]);
            }
            System.out.println();
        }
    }


    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int islandsNum = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != '0') {
                    dfs(grid, i, j);
                    islandsNum++;
                }

        return islandsNum;
    }


    private void dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }

}
