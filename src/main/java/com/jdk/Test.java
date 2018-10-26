package com.jdk;

/**
 * @author jason
 */
public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{2, 9, 10, 15, 1, 10, 8};

        int temp = array[1] - array[0];
        int min = array[0];
        int minindex = 0;
        int maxindex = 1;
        int resultindex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minindex = i;
            }

            if (array[i] - min > temp) {
                temp = array[i] - min;
                resultindex = minindex;
                maxindex = i;
            }
        }
        System.out.println(array[maxindex] + "-" + array[resultindex] + "--------" + temp);
    }


}
