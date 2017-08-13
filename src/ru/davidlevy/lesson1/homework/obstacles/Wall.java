package ru.davidlevy.lesson1.homework.obstacles;

import ru.davidlevy.lesson1.homework.animals.Competitor;

/**
 * Перебраться через стену
 */
public class Wall extends Obstacle {
    /* Высота */
    private int height;

    /**
     * Перебрыться через стену высотой
     *
     * @param height int
     */
    public Wall(int height) {
        this.height = height;
    }

    /**
     * Перебрыться!
     *
     * @param competitor Competitor
     */
    @Override
    public void run(Competitor competitor) {
        competitor.jump(height);
    }
}