package ru.davidlevy.lesson3.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Телефонный справочник
 */
public class Phonebook {
    private int id;
    private HashMap<Integer, Record> records = new HashMap<>();

    /**
     * Тип записи для хранения пары имя=телефон
     */
    private class Record {
        private String name;
        private String phone;

        Record(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public int hashCode() {
            return 31 * name.hashCode() + phone.hashCode();
        }
    }

    Phonebook() {
        this.id = -1;
    }

    /**
     * Добавляет запись в телефонную книгу
     *
     * @param name имя
     * @param phone телефон
     */
    public void add(String name, String phone) {
        this.records.put(++this.id, new Record(name, phone));
    }

    /**
     * Метод возвращает массив телефонов зарегистрированных на имя
     *
     * @param name имя
     */
    public ArrayList<String> get(String name) {
        ArrayList<String> result = new ArrayList<>();
        Set<HashMap.Entry<Integer, Record>> set = records.entrySet();
        System.out.print(name + ": ");
        for (HashMap.Entry<Integer, Record> o : set) {
            if (o.getValue().name.toLowerCase().equals(name.toLowerCase()))
                result.add(o.getValue().phone);
        }
        return result;
    }

    /**
     * Метод показывает все записи телефонной книги
     */
    public void show() {
        System.out.printf("%-4s%-7s%-17s\n", "id", "name", "phone");
        Set<HashMap.Entry<Integer, Record>> set = records.entrySet();
        for (HashMap.Entry<Integer, Record> o : set)
            System.out.printf("%-4s%-7s%-17s\n", o.getKey(), o.getValue().name, o.getValue().phone);
    }
}