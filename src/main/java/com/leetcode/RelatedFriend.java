package com.leetcode;

/**
 * @author jason
 */
public class RelatedFriend {
    public static void main(String[] args) {
        int grids[][] = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        System.out.println(new RelatedFriend().number(grids));
    }


    public void dfs(int grid[][], int i, boolean[] hasvisit) {
        hasvisit[i] = true;
        for (int k = 0; k < grid.length; k++) {
            if (grid[i][k] == 1 && !hasvisit[k]) {
                dfs(grid, k, hasvisit);
            }
        }
    }

    public int number(int grids[][]) {
        int num = 0;
        int n = grids.length;
        boolean[] hasvisit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasvisit[i]) {
                dfs(grids, i, hasvisit);
                num++;
            }
        }


        return num;
    }


}
