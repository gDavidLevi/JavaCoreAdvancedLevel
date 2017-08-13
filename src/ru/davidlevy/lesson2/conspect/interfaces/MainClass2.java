package ru.davidlevy.lesson2.conspect.interfaces;

public class MainClass2 {
    public static void main(String[] args) {
        // вызвали метод onClick класса ClassA
        OnClickListenerA onClickListenerA = new ClassA();
        onClickListenerA.onClick();
    }
}

@FunctionalInterface
interface OnClickListenerA {
    void onClick();
}

class ClassA implements OnClickListenerA {
    @Override
    public void onClick() {
        System.out.println("ClassA.onClick()");
    }
}