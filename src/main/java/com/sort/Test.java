package com.sort;

import java.io.File;
import java.io.FileFilter;

/**
 * @author jason
 */
public class Test {
    public static void main(String[] args) {
        try {
            File[] file = new File("src").listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith("");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
