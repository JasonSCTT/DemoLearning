package com.leetcode;

/**
 * @author jason
 */
public class KeFeng {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;

    public static void main(String[] args) {
        char[][] a = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'X'}};
        new KeFeng().solve(a);
        ;

    }

    public void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);

        }
        print(board);
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);

            dfs(board, m - 1, i);

        }
        print(board);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        print(board);
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O')
            return;

        board[r][c] = 'T';
        for (int[] d : direction)
            dfs(board, r + d[0], c + d[1]);
    }
}
