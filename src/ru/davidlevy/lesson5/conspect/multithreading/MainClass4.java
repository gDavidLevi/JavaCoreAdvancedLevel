package ru.davidlevy.lesson5.conspect.multithreading;

public class MainClass4 {
    // Синхронизированная переменная на чтение и запись
    // Изменяться разными потоками
    // У переменных с модификатором volatile локальных копий нет. Все потоки работают с мастер копией
    // Значение переменной с будет "всегда читаться".
    private static volatile String valueVolatile = "volatile";

    private static void method1() {
        System.out.println(Thread.currentThread().getName() + " (старт)");
        valueVolatile += " + method1()";
        System.out.println(" " + valueVolatile);
        System.out.println(Thread.currentThread().getName() + " (стоп)");
    }

    private static void method2() {
        System.out.println(Thread.currentThread().getName() + " (старт)");
        valueVolatile += " + method2()";
        System.out.println(" " + valueVolatile);
        System.out.println(Thread.currentThread().getName() + " (стоп)");
    }

    public static void main(String[] args) {
        System.out.println("1. volatile String value = " + valueVolatile);
        new Thread(MainClass4::method1).start();
        new Thread(MainClass4::method2).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2. volatile String value = " + valueVolatile);
    }
}