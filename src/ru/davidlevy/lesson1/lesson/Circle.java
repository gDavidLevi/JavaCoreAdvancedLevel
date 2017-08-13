package ru.davidlevy.lesson1.lesson;

import java.awt.*;

/**
 * Класс описывает спрайт Круг
 */
class Circle extends Sprite {
    /* Случайные значение */
    private float xCircle = 150f + (float) (Math.random() * 200f);
    private float yCircle = 150f + (float) (Math.random() * 200f);
    private Color color =
            new Color((int) (Math.random() * 256f), (int) (Math.random() * 256f), (int) (Math.random() * 256f));

    Circle() {
        halfHeight = 20f + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    /**
     * Расчет перемещения
     *
     * @param panelDraw канва
     * @param deltaTime дельта времени
     */
    @Override
    void update(PanelDraw panelDraw, float deltaTime) {
        xCenter += xCircle * deltaTime;
        yCenter += yCircle * deltaTime;
        if (getLeft() < panelDraw.getLeft()) {
            setLeft(panelDraw.getLeft());
            xCircle = -xCircle;
        }
        if (getRight() > panelDraw.getRight()) {
            setRight(panelDraw.getRight());
            xCircle = -xCircle;
        }
        if (getBottom() > panelDraw.getBottom()) {
            setBottom(panelDraw.getBottom());
            yCircle = -yCircle;
        }
        if (getTop() < panelDraw.getTop()) {
            setTop(panelDraw.getTop());
            yCircle = -yCircle;
        }
    }

    /**
     * Отрисовывает графические компоненты
     *
     * @param panelDraw канва
     * @param g         графика
     */
    @Override
    void render(PanelDraw panelDraw, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}