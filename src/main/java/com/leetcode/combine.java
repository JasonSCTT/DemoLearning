package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason
 */
public class combine {
    public static void main(String[] args) {
        System.out.println(new combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(1, n, k, combineList, ret);
        return ret;
    }

    private void backtracking(int start, int n, int k, List<Integer> combineList, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList(combineList));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {  // 剪枝
            combineList.add(i);
            backtracking(i + 1, n, k - 1, combineList, ret);
            combineList.remove(combineList.size() - 1);
        }
    }
}
