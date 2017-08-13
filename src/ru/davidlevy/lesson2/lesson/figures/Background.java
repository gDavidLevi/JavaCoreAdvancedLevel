package ru.davidlevy.lesson2.lesson.figures;

import ru.davidlevy.lesson2.lesson.engine.Figure;
import ru.davidlevy.lesson2.lesson.engine.PanelDraw;

import java.awt.*;

/**
 * Фон
 */
public class Background implements Figure {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    /**
     * Расчет изменерия цвета
     *
     * @param panelDraw канва
     * @param deltaTime дельта времени
     */
    @Override
    public void update(PanelDraw panelDraw, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    /**
     * Установка цвета фона
     *
     * @param panelDraw канва
     * @param g         графика
     */
    @Override
    public void render(PanelDraw panelDraw, Graphics g) {
        panelDraw.setBackground(color);
    }
}