package ru.davidlevy.lesson1.homework.animals;

/**
 * Абстрактный класс описывающий Животное.
 */
public abstract class Animal implements Competitor {
    /* Имя и тип животного */
    private String type;
    private String name;

    /* Максимальные возможности */
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    /* Участвует в гонке? */
    private boolean onDistance;

    /**
     * Конструктор
     *
     * @param type            тип
     * @param name            имя
     * @param maxRunDistance  максимальное расстояние, на кототорое животное может пробежать
     * @param maxJumpHeight   максимальное расстояние, на кототорое животное может прыгнуть
     * @param maxSwimDistance максимальное расстояние, на кототорое животное может заплыть
     */
    Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public boolean getActive() {
        return false;
    }

    /**
     * Возвращает имя животного
     *
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Учавствует в гонке?
     *
     * @return boolean
     */
    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    /**
     * Рассчитывает преодалеваемое расстояние
     *
     * @param distance int
     */
    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(type + " " + name + " успешно пробежал кросс");
        } else {
            System.out.println(type + " " + name + " не смог справиться с кроссом");
            onDistance = false;
        }
    }

    /**
     * Рассчитывает преодалеваемую высоту прыжка
     *
     * @param height int
     */
    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " успешно перепрыгнул стену");
        } else {
            System.out.println(type + " " + name + " не смог перепрыгнуть стену");
            onDistance = false;
        }
    }

    /**
     * Рассчитывает преодалеваемое расстояние вплавь
     *
     * @param distance int
     */
    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (distance <= maxSwimDistance) {
            System.out.println(type + " " + name + " успешно проплыл дистанцию");
        } else {
            System.out.println(type + " " + name + " не смог проплыть дистанцию");
            onDistance = false;
        }
    }

    /**
     * Отображает результат
     */
    @Override
    public void showResults() {
        System.out.println(type + " " + name + ": " + onDistance);
    }
}