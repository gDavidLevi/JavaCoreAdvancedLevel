package ru.davidlevy.lesson5.homework;

public class MainClass {
    public static void main(String[] args) {
        float[] array = new float[1000000];
        System.out.printf("Один поток решает задачу за %d мс.\n", Multithreading.oneThread(array)); // 598 мс.
        System.out.printf("Два потока решает задачу за %d мс.\n", Multithreading.twoThreads(array)); // 344 мс.
    }
}

final class Multithreading {
    /**
     * Переменная хранит время до запуска потока расчета
     */
    private static long timeBefore;

    /**
     * Метод initArray инициирует массив единицами
     *
     * @param array входной массив
     */
    private static void initArray(float[] array) {
        int i = 0;
        while (i < array.length) {
            array[i++] = 1;
        }
    }

    /**
     * Метод oneThread вычисляет формулу в одном потоке (в потоке main)
     *
     * @param array входной массив
     * @return время затраченное на расчет, мс
     */
    public static long oneThread(float[] array) {
        initArray(array);
        //
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - timeBefore;
    }

    /**
     * Метод twoThreads вычисляет формулу в двух потоках
     *
     * @param array входной массив
     * @return время затраченное на расчет, мс
     */
    public static long twoThreads(float[] array) {
        int half = array.length / 2;
        float[] threadPart1 = new float[half];
        float[] threadPart2 = new float[half];
        initArray(array);
        //
        timeBefore = System.currentTimeMillis();
        System.arraycopy(array, 0, threadPart1, 0, half);
        System.arraycopy(array, half, threadPart2, 0, half);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < half; i++) {
                    threadPart1[i] = (float) (threadPart1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < half; i++) {
                    threadPart2[i] = (float) (threadPart2[i] * Math.sin(0.2f + (i + half) / 5) * Math.cos(0.2f + (i + half) / 5) * Math.cos(0.4f + (i + half) / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(threadPart1, 0, array, 0, half);
        System.arraycopy(threadPart2, 0, array, half, half);
        return System.currentTimeMillis() - timeBefore;
    }
}