package ru.davidlevy.lesson5.homework;

import java.util.Arrays;

public class MainClass {
    /* Точка входа */
    public static void main(String[] args) throws Exception {
        float[] array = new float[1000000];
        System.out.printf("Один поток решает задачу за %d мс.\n", Multithreading.oneThread(array)); // 598 мс.
        System.out.printf("Два потока решает задачу за %d мс.\n", Multithreading.twoThreads(array)); // 344 мс.
    }
}

/**
 * Многопоточность
 */
class Multithreading {
    /* Переменная хранит время до запуска расчета */
    private static long timeBefore;

    /**
     * Метод oneThread вычисляет формулу в одном потоке (в потоке main)
     *
     * @param array входной массив
     * @return время затраченное на расчет, мс
     */
    static long oneThread(float[] array) {
        /* Инициалиация массива */
        Arrays.fill(array, 1f);

        /* Засекаем время начала расчета */
        timeBefore = System.currentTimeMillis();

        /* Расчет */
        for (int i = 0, quantity = array.length; i < quantity; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        /* Возвращем результат */
        return System.currentTimeMillis() - timeBefore;
    }

    /**
     * Метод twoThreads вычисляет формулу в двух потоках
     *
     * @param array входной массив
     * @return время затраченное на расчет, мс
     */
    static long twoThreads(float[] array) throws Exception {
        int half = array.length / 2;
        float[] threadPart1 = new float[half];
        float[] threadPart2 = new float[half];

        /* Инициалиация массива */
        Arrays.fill(array, 1f);

        /* Засекаем время начала расчета */
        timeBefore = System.currentTimeMillis();

        /* Разбиваем на два массива */
        System.arraycopy(array, 0, threadPart1, 0, half);
        System.arraycopy(array, half, threadPart2, 0, half);

        /* Потоки выполнения */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                /* Расчет */
                for (int i = 0; i < half; i++) {
                    threadPart1[i] = (float) (threadPart1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                /* Расчет */
                for (int i = 0; i < half; i++) {
                    threadPart2[i] = (float) (threadPart2[i] * Math.sin(0.2f + (i + half) / 5) * Math.cos(0.2f + (i + half) / 5) * Math.cos(0.4f + (i + half) / 2));
                }
            }
        });

        /* Запускаем потоки */
        thread1.start();
        thread2.start();

        /* Ожидаем завершения потоков */
        thread1.join();
        thread2.join();

        /* Собираем массивы в один */
        System.arraycopy(threadPart1, 0, array, 0, half);
        System.arraycopy(threadPart2, 0, array, half, half);

        /* Возвращем результат */
        return System.currentTimeMillis() - timeBefore;
    }
}