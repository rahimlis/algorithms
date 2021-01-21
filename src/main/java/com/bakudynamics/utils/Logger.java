package com.bakudynamics.utils;

public class Logger {

    private static final boolean DISABLED = false;

    public static void debug(int[] a) {
        if (DISABLED) return;
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1)
                System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void debug(String format, Object... args) {
        if (DISABLED) return;
        System.out.printf(format, args);
    }

    public static void debug(String line) {
        if (DISABLED) return;
        System.out.println(line);
    }

    public static void debug(int i) {
        if (DISABLED) return;
        System.out.println(i);
    }

    public static void debug(long i) {
        if (DISABLED) return;
        System.out.println(i);
    }

    public static void debug(double i) {
        if (DISABLED) return;
        System.out.println(i);
    }
}
