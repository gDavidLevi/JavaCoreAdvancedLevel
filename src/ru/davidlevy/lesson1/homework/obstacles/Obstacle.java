package ru.davidlevy.lesson1.homework.obstacles;

import ru.davidlevy.lesson1.homework.animals.Competitor;

/**
 * Препятствия
 */
public abstract class Obstacle {
    /**
     * Испытать препятствие на участнике
     *
     * @param competitor Competitor
     */
    public abstract void run(Competitor competitor);
}