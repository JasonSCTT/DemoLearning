package com.pattern.Singleton;

/**
 * @author jason
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    ;

    public static synchronized LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
