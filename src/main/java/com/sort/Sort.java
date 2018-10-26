package com.sort;

import java.util.Arrays;

/**
 * @author jason
 */
public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {26, 53, 48, 11, 13, 48, 32, 15};

        sort.selectSort(a);
        System.out.println(Arrays.toString(a));

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*插入排序，时间复杂度为o(n2)*/
    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    /*希尔排序*/
    public void shellSort(int[] arr, int delta) {
        for (int i = delta; i < arr.length; i++) {
            for (int j = i; j >= delta; j -= delta) {
                if (arr[j - delta] > arr[j]) {
                    swap(arr, j - delta, j);
                }
            }
        }
    }

    /*冒泡排序*/
    public void bubbleSort(int[] arr) {
        //一个一个冒泡上去找到自己应该在的位置
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }
    }


    /*快速排序*/
    public void quickSort(int[] arr, int low, int high) {
        if (low > high) return;
        int temp = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            // 从最大找到第一个小于temp的值
            while (i < j && arr[j] >= temp) {
                j--;
            }

            //从小到大找到第一个大于temp的值
            while (i < j && arr[i] <= temp) {
                i++;
            }
            //交换
            if (i < j) {
                swap(arr, i, j);
            }
        }
        //交换两个地方的值
        swap(arr, low, i);
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    public void selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[min] > arr[k]) {
                    min = k;
                }
            }
            swap(arr, i, min);
        }
    }


}
