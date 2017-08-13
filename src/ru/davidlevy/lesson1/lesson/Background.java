package ru.davidlevy.lesson1.lesson;

import java.awt.*;

/**
 * Класс описывает спрайт Фон
 */
class Background extends Sprite {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    /**
     * Расчитывает цвет фона
     *
     * @param panelDraw канва
     * @param deltaTime дельта времени
     */
    @Override
    void update(PanelDraw panelDraw, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    /**
     * Отрисовывает графические компоненты
     *
     * @param PanelDraw канва
     * @param g         графика
     */
    @Override
    void render(PanelDraw PanelDraw, Graphics g) {
        PanelDraw.setBackground(color);
    }
}