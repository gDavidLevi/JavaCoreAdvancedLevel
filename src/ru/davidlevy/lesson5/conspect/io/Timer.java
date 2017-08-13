package ru.davidlevy.lesson5.conspect.io;

final class Timer {
    private static long startTime;

    static void start() {
        startTime = System.currentTimeMillis();
    }

    static void stopDeltaTime() {
        System.out.println(String.valueOf(System.currentTimeMillis() - startTime) + " ms.");
    }
}