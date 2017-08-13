package ru.davidlevy.lesson5.conspect.multithreading;

public class MainClass2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++){}
                System.out.println("Завершился поток " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable, "T1");
        Thread thread2 = new Thread(runnable, "T2");
        //
        System.out.println("Запуск потоков");
        //
        thread1.start();
        thread2.start();
        //
        try {
            thread1.join(); // главный поток main ждет завершения потока thread1
            thread2.join(); // главный поток main ждет завершения потока thread2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Потоки завершились.");
    }
}
