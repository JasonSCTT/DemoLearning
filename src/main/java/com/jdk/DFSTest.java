package com.jdk;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jason
 */
public class DFSTest {
    public static void main(String[] args) {
        new DFSTest().anInt();
    }

    public int anInt() {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] array = {{1, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1}};

        int m = array.length;
        int n = array[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer, Integer>(0, 0));
        int pathlength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathlength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                for (int[] d : direction) {
                    Pair<Integer, Integer> next = new Pair(cur.getKey() + d[0], cur.getValue() + d[1]);
                    if (next.getKey() < 0 || next.getValue() >= m || next.getKey() < 0 || next.getValue() >= n)
                        continue;
                    array[next.getKey()][next.getValue()] = 0; // 标记
                    if (next.getKey() == 3 && next.getValue() == 2)
                        return pathlength;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
