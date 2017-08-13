package ru.davidlevy.lesson2.homework;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Исключения
 */
public class MainClass {
    /* Правильный размер входной матрицы */
    private static final int SIZE = 4;

    /**
     * Возвращает сумму элементов массива.
     *
     * @param stringArray String[][]
     * @return int
     * @throws MyExceptions
     */
    private static int calcSum(String[][] stringArray) throws MyExceptions {
        if (stringArray[1].length > SIZE | stringArray.length > SIZE)
            throw new MyArraySizeException("Размер матрицы привышен");
        int sum = 0;
        int j = 0;
        while (j < SIZE) {
            int i = 0;
            while (i < SIZE) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования значения \"" + stringArray[i][j] + "\" по координатам (" + (j + 1) + "," + (i + 1) + ") в число");
                }
                i++;
            }
            j++;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // Вариант 1. матрица 4х4 // исключения не встречаются
        String[][] input = new String[][]{{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        // Вариант 2. матрица 4х5 // MyArraySizeException
        //String[][] input = new String[][]{{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"2", "2", "2", "2"}};

        // Вариант 3. матрица 4х4 символ вместо числа // MyArrayDataException
        //String[][] input = new String[][]{{"1", "1", "1", "@"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        System.out.println("Входные данные:");
        for (String[] row : input) System.out.println(Arrays.toString(row));

        System.out.println("Результат расчёта суммы: " + calcSum(input));
    }
}

/**
 * Базовый класс для моих исключений
 */
class MyExceptions extends RuntimeException {
    private String message;
    private Date date;

    MyExceptions(String message) {
        super(message);
        this.message = message;
        this.date = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        return this.date + " MyExceptions." + this.message;
    }
}

/**
 * Класс ArrayDataException
 */
class MyArrayDataException extends MyExceptions {
    MyArrayDataException(String message) {
        super("MyArrayDataException : " + message);
    }
}

/**
 * Класс ArraySizeException
 */
class MyArraySizeException extends MyExceptions {
    MyArraySizeException(String message) {
        super("MyArraySizeException : " + message);
    }
}