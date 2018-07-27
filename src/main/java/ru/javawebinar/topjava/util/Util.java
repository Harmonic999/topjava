package ru.javawebinar.topjava.util;

public class Util {

    private Util() {
    }

    public static <T extends Comparable<? super T>> boolean isBetween(T value, T start, T end) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

    public static <T> T orElse(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static float nanoToSeconds(long nanoTime) {
        return nanoTime / 1000000;
    }
}
