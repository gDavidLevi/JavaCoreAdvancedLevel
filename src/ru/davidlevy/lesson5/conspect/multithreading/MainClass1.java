package ru.davidlevy.lesson5.conspect.multithreading;

public class MainClass1 {

    public static void main(String[] args) {
        method0(); // класс extends Thread
        method1(); // класс интерфейс Runnable
        method2(); // Thread thread = new Thread(new Runnable()...
        method3(); // new Thread(new Runnable()...
    }

    private static void method3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*
                Код
                 */
            }
        }, "Имя_потока").start();
    }

    private static void method2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            /*
            Код
             */
            }
        }, "Имя_потока");
        /*
        thread.start();
        thread.setName("Мой поток");
        thread.getName(); // Мой поток
        thread.isAlive(); // запущен ли поток
        thread.isInterrupted();
        thread.isDaemon();
        thread.getName();
        thread.setPriority(5); // только для Windows
        thread.getPriority();
        System.out.println(Thread.currentThread().getName()); // main
        */
    }

    private static void method1() {
        Thread thread = new Thread(new MyThreadImpl(), "Имя_потока");
        thread.start();
    }

    private static void method0() {
        MyThread myThread = new MyThread("Имя_потока");
        myThread.start();
    }
}

class MyThread extends Thread {

    MyThread(String name) {
        super(name); // Возволяет нам видеть имя потока при throw new RuntimeException();
        //start(); // Можно запустить поток сразу при создании объекта класса
    }

    @Override
    public void run() {
        // Выполнять пока снаружи не придет сигнал new MyThread().interrupt;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100);
                /*
                Код
                 */
            } catch (InterruptedException e) {
                break; // выход из цикла
            }
        }
        //
        //throw new RuntimeException();
    }
}

class MyThreadImpl implements Runnable {

    @Override
    public void run() {
        /*
        Код
         */
    }
}