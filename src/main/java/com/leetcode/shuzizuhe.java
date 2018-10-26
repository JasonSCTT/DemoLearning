package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason
 */
public class shuzizuhe {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
//        List<String> abc=new shuzizuhe().letterCombinations("234");
//        for(String item :abc){
//            System.out.println(item);
//        }

        String digits = "234";
        System.out.println(digits.charAt("a".length()) - '0');


        StringBuilder sb = new StringBuilder();
        sb.append("abcd");
        sb.deleteCharAt(2);
        System.out.println(sb.toString());
    }


    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ret;
        combination(new StringBuilder(), digits, ret);
        return ret;
    }

    private void combination(StringBuilder prefix, String digits, List<String> ret) {
        if (prefix.length() == digits.length()) {
            ret.add(prefix.toString());
            return;
        }
        String letters = KEYS[digits.charAt(prefix.length()) - '0'];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                         // 添加
            combination(prefix, digits, ret);
            prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
}
