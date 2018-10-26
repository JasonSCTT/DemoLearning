package com.pattern.Singleton;

/**
 * @author jason
 */
public class CheckDouble {

    private static CheckDouble checkDouble;

    private CheckDouble() {
    }

    ;

    public static CheckDouble getCheckDouble() {
        if (checkDouble == null) {
            synchronized (CheckDouble.class) {
                if (checkDouble == null) {
                    checkDouble = new CheckDouble();
                }
            }
        }
        return checkDouble;
    }

}
