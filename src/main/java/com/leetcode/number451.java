package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 */
public class number451 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequecyMap = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (frequecyMap.get(c) == null) {
                frequecyMap.put(c, 0);
            } else {
                frequecyMap.put(c, frequecyMap.get(c) + 1);
            }
        }
        List<Character>[] frequencyBucket = new List[s.length() + 1];
        for (char c : frequecyMap.keySet()) {
            int f = frequecyMap.get(c);
            if (frequencyBucket[f] == null) {
                frequencyBucket[f] = new ArrayList<>();
            }

            frequencyBucket[f].add(c);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0; i--) {
            if (frequencyBucket[i] == null) {
                continue;
            }
            for (char c : frequencyBucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();


    }
}
