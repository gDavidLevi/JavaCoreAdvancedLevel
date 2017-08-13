package ru.davidlevy.lesson2.conspect.interfaces;

public class MainClass3 {
    public static void main(String[] args) {
        // вызов метода onClick из анонимного класса (будто бы класса ClassA и не существовало)
        // при этом реализацию метода надо будет сделать.
        OnClickListenerB onClickListenerB = new OnClickListenerB() {
            @Override
            public void onClick() {
                System.out.println("реализация метода из анонимного класса");
            }
        };
        onClickListenerB.onClick();
    }
}

/* Single Abstract Method interfaces (SAM interfaces).
Одним из самых популярных способов использования этих интерфейсов заключается в создании анонимных внутренних классов.
В Java 8 концепция SAM воссоздана и называется функциональными интерфейсами. Они могут быть представлены при помощи лямбда-выражений, ссылками на методы и конструкторами ссылок. Создана новая аннотация @FunctionalInterface которая используется для выдачи ошибок на уровне компилятора, когда интерфейс который Вы аннотировали не работает на функциональном уровне.
*/
@FunctionalInterface
interface OnClickListenerB {
    void onClick();
}