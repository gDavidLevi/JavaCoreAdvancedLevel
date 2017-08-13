package ru.davidlevy.lesson3.homework;

/**
 * Коллекции. Collections Framework
 */
public class MainClass {
    private static void task1() {
        String text = "Mon perroquet est rouge et gris\n" +
                "Il est joli comme un bouquet\n" +
                "Et si je cris Bonjour, Coco!\n" +
                "Il répond: Oui, Cocorico!";
        //System.out.println("Текст: \n" + text);
        Tokenization tokenization = new Tokenization(text);
        System.out.println("Уникальные слова: \n" + tokenization.getUniqueValues());
        System.out.println("Вхождения (ключ, раз): \n" + tokenization.getOccurrencesOfWords());
    }

    private static void task2() {
        Phonebook book = new Phonebook();
        book.add("Lévy", "+7 926 555-55-55");
        book.add("Lévy", "+7 903 333-33-33");
        book.add("Katz", "+7 901 222-22-22");
        book.add("Cohen", "+972 236-002-411");
        book.add("Dvin", "+972 722-822-544");
        book.add("Lévy", "+972 425-426-004");
        book.add("Katz", "+972 111-222-333");
        //book.show();
        System.out.println(book.get("Lévy"));
        System.out.println(book.get("Katz"));
        System.out.println(book.get("Dvin"));
    }

    public static void main(String[] args) {
        System.out.println("* Задание 1");
        task1();

        System.out.println("\n* Задание 2");
        task2();
    }
}