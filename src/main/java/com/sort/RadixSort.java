package com.sort;

import java.util.Arrays;

/**
 * @author jason
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = new int[]{78, 2314, 513, 124, 1236, 6, 843, 234, 134, 134};
        new RadixSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    /*基数排序是基于桶排序的另一种算法*/
    public void sort(int[] array) {

        int n = 1;

        int[][] buckets = new int[10][array.length];

        int count[] = new int[array.length];

        while (n <= 100) {
            for (int i = 0; i < array.length; i++) {
                int degit = (array[i] / n) % 10;
                buckets[degit][count[degit]] = array[i];
                count[degit]++;
            }
            int k = 0;
            for (int i = 0; i < array.length; i++) {
                if (count[i] != 0) {
                    for (int j = 0; j < count[i]; j++) {
                        array[k] = buckets[i][j];
                        k++;
                    }
                    count[i] = 0;
                }
            }

            System.out.println(Arrays.toString(array));
            n *= 10;
        }
    }
}
