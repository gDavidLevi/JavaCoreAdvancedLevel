package ru.davidlevy.lesson3.homework_alt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class MainClass {
    private static TreeSet<String> getWords(String[] words) {
        return new TreeSet<>(Arrays.asList(words));
    }

    private static HashMap<String, Integer> getWordsCount(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Lévy", "+7 926 555-55-55");
        phonebook.add("Katz", "+7 901 222-22-22");
        phonebook.add("Lévy", "+7 903 333-33-33");
        phonebook.add("Dvin", "+972 722-822-544");
        //phonebook.add("Dvin", "+972 722-822-544"); // throw new RuntimeException("Дублирование записи: name " + name + " phone: " + phone);
        phonebook.add("Dvin", "+972 236-002-411");

        System.out.println("Lévy phones: " + phonebook.get("Lévy"));
        System.out.println("Katz phones: " + phonebook.get("Katz"));
        System.out.println("Dvin phones: " + phonebook.get("Dvin"));
    }
}

class Phonebook {
    private final HashMap<String, HashSet<String>> records = new HashMap<>();

    public void add(String name, String phone) {
        HashSet<String> phones = records.get(name);
        if (phones == null) {
            phones = new HashSet<>();
            records.put(name, phones);
        }
        if (!phones.add(phone))
            throw new RuntimeException("Дублирование записи: name " + name + " phone: " + phone);
    }

    public HashSet<String> get(String surname) {
        return records.get(surname);
    }
}