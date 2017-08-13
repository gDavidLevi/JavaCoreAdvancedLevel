package ru.davidlevy.lesson3.homework;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Выделение слов и границ
 */
class Tokenization {
    private ArrayList<String> array;
    private String text;

    /**
     * Конструктор инициируется строкой
     *
     * @param text текст для разбора
     */
    Tokenization(String text) {
        this.text = text;
        this.array = new ArrayList<>();
        tokenization();
    }

    /**
     * Метод удаляет ненужные символы и приводит всё к нижнему регистру.
     *
     * @return String
     */
    private String preparation() {
        String result = this.text;
        for (String symbol : new String[]{"!", ":", ","})
            result = result.replaceAll(symbol, "");
        return result.toLowerCase();
    }

    /**
     * Метод формирует из слов список.
     */
    private void tokenization() {
        String[] lines = preparation().split("\\n");
        int x = 0;
        while (x < lines.length) {
            String[] words = lines[x].split(" ");
            int y = 0;
            while (y < words.length) {
                array.add(words[y]);
                y++;
            }
            x++;
        }
    }

    /**
     * Метод возврашает отсортированный набор уникальных значений.
     *
     * @return TreeSet
     */
    public TreeSet<String> getUniqueValues() {
        return new TreeSet<>(array);
    }

    /**
     * Метод возврашает отсортированный словарь по ключам, значение ключей - кол-во вхождений ключа в тексте.
     *
     * @return TreeMap
     */
    public TreeMap<String, Integer> getOccurrencesOfWords() {
        TreeMap<String, Integer> result = new TreeMap<>();
        int count;
        for (String key : getUniqueValues()) {
            count = 0;
            for (String word : array)
                if (key.equals(word))
                    ++count;
            result.put(key, count);
        }
        return result;
    }
}