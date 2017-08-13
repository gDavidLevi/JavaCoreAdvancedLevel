package ru.davidlevy.lesson1.homework.animals;

public class Human implements Competitor {
    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    private boolean active;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean getActive() {
        return this.active;
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 10000;
        this.maxJumpHeight = 20;
        this.maxSwimDistance = 500;
        this.active = true;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " успешно пробежал кросс");
        } else {
            System.out.println(name + " не смог справиться с кроссом");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно перепрыгнул стену");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену");
            active = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " успешно проплыл дистанцию");
        } else {
            System.out.println(name + " не смог проплыть дистанцию");
            active = false;
        }
    }

    @Override
    public void showResults() {
        System.out.println(name + ": " + active);
    }
}
