package ru.davidlevy.lesson1.homework;

import ru.davidlevy.lesson1.homework.animals.Cat;
import ru.davidlevy.lesson1.homework.animals.Competitor;
import ru.davidlevy.lesson1.homework.animals.Dog;
import ru.davidlevy.lesson1.homework.animals.Human;
import ru.davidlevy.lesson1.homework.obstacles.Race;
import ru.davidlevy.lesson1.homework.obstacles.Obstacle;
import ru.davidlevy.lesson1.homework.obstacles.Wall;
import ru.davidlevy.lesson1.homework.obstacles.Water;

public class MainClass {
    /* Точка входа */
    public static void main(String[] args) {
        /* Массив препятствий */
        Obstacle[] obstacles = new Obstacle[]{new Race(4000), new Wall(3), new Race(480), new Water(1)};

        /* Очередь */
        Queue queue = new Queue(obstacles);

        /* Участники комманды Bobs */
        Competitor[] bobs = new Competitor[]{new Human("Боб"), new Dog("Бобби"), new Human("Боба"), new Human("Бобёр")};
        Team teamBobs = new Team("Бобы", bobs);

        /* Участники комманды Mos */
        Competitor[] mos = new Competitor[]{new Human("Мо"), new Cat("Мото"), new Human("Моба"), new Human("Мока")};
        Team teamMos = new Team("Мосы", mos);

        /* Показать участников */
        teamBobs.showCompetitors();
        teamMos.showCompetitors();

        /* Протестировать участников */
        queue.run(teamBobs);
        queue.run(teamMos);

        /* Отобразить результаты комманд */
        teamBobs.showResults();
        teamMos.showResults();
    }
}