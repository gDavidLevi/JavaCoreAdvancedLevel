package ru.davidlevy.lesson1.homework.animals;

/**
 * Интерфейс участника гонки
 */
public interface Competitor {
    /**
     * Бежать дистанцию
     *
     * @param distance int
     */
    void run(int distance);

    /**
     * Заплыть на дистанцию
     *
     * @param distance int
     */
    void swim(int distance);

    /**
     * Прыгнуть на высоту
     *
     * @param height int
     */
    void jump(int height);

    /**
     * Отобразить результаты
     */
    void showResults();

    /**
     * На дистанции?
     */
    boolean isOnDistance();

    /**
     * Получить имя участника
     *
     * @return String
     */
    String getName();

    /**
     * **************
     *
     * @return boolean
     */
    boolean getActive();
}