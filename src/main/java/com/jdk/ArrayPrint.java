package com.jdk;

/**
 * @author jason
 */
public class ArrayPrint {


    public static void main(String[] args) {
        int m = 5, n = 4;
        int array[][] = new int[m][n];

        arrayPrint(array, m, 4);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void arrayPrint(int array[][], int m, int n) {
        int x = 0, y = 0;
        int direction = 0;
        int value = 1;
        for (int j = 0; j < m * n; j++) {
            array[x][y] = value;
            int tmpx = x, tmpy = y;
            switch (direction) {
                case 0:
                    tmpy++;
                    break;
                case 1:
                    tmpx++;
                    break;
                case 2:
                    tmpy--;
                    break;
                case 3:
                    tmpx--;
                    break;
            }

            if (tmpx >= 0 && tmpx < m && tmpy < n && tmpy >= 0 && array[tmpx][tmpy] == 0) {
                x = tmpx;
                y = tmpy;
            } else {
                value++;
                direction = (direction + 1) % 4;
                switch (direction) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x--;
                        break;
                }
            }
        }
    }
}
