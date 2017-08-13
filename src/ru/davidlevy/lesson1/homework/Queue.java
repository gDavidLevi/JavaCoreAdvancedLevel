package ru.davidlevy.lesson1.homework;

import ru.davidlevy.lesson1.homework.animals.Competitor;
import ru.davidlevy.lesson1.homework.obstacles.Obstacle;

/**
 * Очередь
 */
public class Queue {
    /* Массив препятствий */
    private Obstacle[] obstacles;

    /* Конструктор */
    Queue(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * Прогнать комманду участников через препятствия
     *
     * @param team Team
     */
    public void run(Team team) {
        Competitor[] competitors = team.getCompetitors();
        for (Competitor competitor : competitors) {
            for (Obstacle obstacle : this.obstacles) {
                /* Выйти из цикла если участник не на дистанции */
                if (!competitor.isOnDistance()) break;
                /* Потестировать участника по препятствиям */
                obstacle.run(competitor);
            }
        }
    }
}
