package com.sort;

import java.util.Arrays;

/**
 * @author jason
 */
public class quicksort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {26, 53, 48, 11, 13, 48, 32, 15};

        sort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public void quickSort(int[] arr, int low, int high) {
        if (low > high) return;
        int temp = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[j] >= temp) {
                j--;
            }

            while (arr[i] <= temp) {
                i++;
            }

            if (i < j) {
                swap(arr, i, j);
            }


        }

        swap(arr, low, i);
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
