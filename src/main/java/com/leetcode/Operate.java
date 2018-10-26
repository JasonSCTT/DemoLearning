package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason
 */
public class Operate {
    public static void main(String[] args) {
        List<List<Integer>> set = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        boolean[] visited = new boolean[3];
        int[] array = new int[]{1, 2, 3};
        a(a, array, set, visited);

        for (List iten : set) {
            System.out.println(iten.toString());
        }
    }

    private static void a(List<Integer> a, int[] array, List<List<Integer>> set, boolean[] visited) {
        if (a.size() == 3) {
            set.add(new ArrayList<Integer>(a));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            a.add(array[i]);
            a(a, array, set, visited);
            a.remove(a.size() - 1);
            visited[i] = false;
        }
    }
}
