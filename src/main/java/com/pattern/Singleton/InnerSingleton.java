package com.pattern.Singleton;

/**
 * @author jason
 */
public class InnerSingleton {

    private static class getSingleto {
        private static InnerSingleton innerSingleton = new InnerSingleton();

    }

    private InnerSingleton() {
    }

    ;

    public static InnerSingleton getInnerSingleton() {
        return getSingleto.innerSingleton;
    }


}
