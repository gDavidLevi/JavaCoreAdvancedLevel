package ru.davidlevy.lesson1.homework.obstacles;

import ru.davidlevy.lesson1.homework.animals.Competitor;

/**
 * Преодатеть расстояние
 */
public class Race extends Obstacle {
    /* Расстояние */
    private int length;

    /**
     * Преодалеть расстояние
     *
     * @param length int
     */
    public Race(int length) {
        this.length = length;
    }

    /**
     * Преодалеть!
     *
     * @param competitor Competitor
     */
    @Override
    public void run(Competitor competitor) {
        competitor.run(length);
    }
}