package ru.davidlevy.lesson2.lesson.engine;

import java.awt.*;

/**
 * Интерфейс управления фигурой
 */
public interface Figure {
    /**
     * Расчет параметров фигуры
     *
     * @param panelDraw панель для рисования
     * @param deltaTime   дельта времени
     */
    void update(PanelDraw panelDraw, float deltaTime);

    /**
     * Работа с грачическими объектами
     *
     * @param panelDraw панель для рисования
     * @param g           графика
     */
    void render(PanelDraw panelDraw, Graphics g);
}