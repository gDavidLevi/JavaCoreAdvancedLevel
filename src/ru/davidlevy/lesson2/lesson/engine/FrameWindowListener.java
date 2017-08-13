package ru.davidlevy.lesson2.lesson.engine;

import java.awt.*;

/**
 * Интерфейс дает комманду рисовать
 *
 * @see FrameWindow реализует данный интерфейс
 * @see PanelDraw класс-источник событий
 */
public interface FrameWindowListener {
    /**
     * Рисовать
     *
     * @param panelDraw на панели
     * @param g         графикой
     * @param deltaTime с дельтой времени
     */
    void draw(PanelDraw panelDraw, Graphics g, float deltaTime);
}