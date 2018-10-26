package com.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jason
 */
public class migong {
    public static void main(String[] args) {
        int[][] grids = {{1, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1}};


        System.out.println(minPathLength(grids, 2, 2));


    }

    public static int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                for (int[] d : direction) {
                    Pair<Integer, Integer> next = new Pair(cur.getKey() + d[0], cur.getValue() + d[1]);
                    if (next.getKey() < 0 || next.getValue() >= m || next.getKey() < 0 || next.getValue() >= n)
                        continue;
                    grids[next.getKey()][next.getValue()] = 0; // 标记
                    if (next.getKey() == tr && next.getValue() == tc)
                        return pathLength;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
