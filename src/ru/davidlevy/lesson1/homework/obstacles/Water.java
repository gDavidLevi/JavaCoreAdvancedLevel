package ru.davidlevy.lesson1.homework.obstacles;

import ru.davidlevy.lesson1.homework.animals.Competitor;

/**
 * Проптыть
 */
public class Water extends Obstacle {
    /* Расстояние */
    private int length;

    /**
     * Проплыть расстояние
     *
     * @param length int
     */
    public Water(int length) {
        this.length = length;
    }

    /**
     * Проплыть!
     *
     * @param competitor Competitor
     */
    @Override
    public void run(Competitor competitor) {
        competitor.swim(length);
    }
}