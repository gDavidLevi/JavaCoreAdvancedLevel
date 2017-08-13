package ru.davidlevy.lesson5.conspect.multithreading;

public class MainClass3 {
    private static synchronized void methodSynchronized() {
        System.out.println(Thread.currentThread().getName() + " (старт)");
        System.out.println(" synchronized void methodSynchronized() {...");
        System.out.println(Thread.currentThread().getName() + " (стоп)\n");
    }

    private static final Object OBJECT_MONITOR = new Object();

    private static void methodMonitor() {
        synchronized (OBJECT_MONITOR) {
            System.out.println(Thread.currentThread().getName() + " (старт)");
            System.out.println(" synchronized (OBJECT_MONITOR) {...");
            System.out.println(Thread.currentThread().getName() + " (стоп)\n");
        }
    }

    private void methodMonitorSelf() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " (старт)");
            System.out.println(" synchronized (this) {...");
            System.out.println(Thread.currentThread().getName() + " (стоп)\n");
        }
    }

    public static void main(String[] args) {
        new Thread(MainClass3::methodSynchronized).start();
        new Thread(MainClass3::methodSynchronized).start();

        new Thread(MainClass3::methodMonitor).start();
        new Thread(MainClass3::methodMonitor).start();

        new Thread(() -> new MainClass3().methodMonitorSelf()).start();
        new Thread(() -> new MainClass3().methodMonitorSelf()).start();
    }
}