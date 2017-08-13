package ru.davidlevy.lesson1.homework;

import ru.davidlevy.lesson1.homework.animals.Competitor;

/**
 * Комманда
 */
class Team {
    /* Имя комманды */
    private String name;

    /* Участники комманды */
    private Competitor[] competitors;

    /**
     * Конструктор
     *
     * @param name        имя комманды
     * @param competitors массив переменной дленны
     */
    Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    /**
     * Показать участников комманды
     */
    void showCompetitors() {
        System.out.println("\nКоманда '" + this.name + "' состоит из:");
        for (Competitor c : this.competitors) {
            System.out.println("- " + c.getName());
        }
    }

    /**
     * Возвращает массив участников
     *
     * @return Competitor[]
     */
    Competitor[] getCompetitors() {
        return competitors;
    }

    /**
     * Отображает рузультаты комманды
     */
    void showResults() {
        for (Competitor c : competitors) {
            System.out.println(c.getName() + ": " + c.getActive());
        }
    }
}