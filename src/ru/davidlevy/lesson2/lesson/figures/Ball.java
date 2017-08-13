package ru.davidlevy.lesson2.lesson.figures;

import ru.davidlevy.lesson2.lesson.engine.PanelDraw;
import ru.davidlevy.lesson2.lesson.engine.Sprite;

import java.awt.*;

/**
 * Класс описывает спрайт Шарик
 */
public class Ball extends Sprite {
    /* Случайные значение */
    private float xBall = 150f + (float) (Math.random() * 200f);
    private float yBall = 150f + (float) (Math.random() * 200f);
    private Color color =
            new Color((int) (Math.random() * 256f), (int) (Math.random() * 256f), (int) (Math.random() * 256f));

    public Ball() {
        halfHeight = 20f + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    /* Конструктор для установки спрайта по клику мыши */
    public Ball(int x, int y){
        this();
        this.xCenterOfSprite = x;
        this.yCenterOfSprite = y;
    }

    /**
     * Расчет перемещения
     *
     * @param panelDraw канва
     * @param deltaTime дельта времени
     */
    @Override
    public void update(PanelDraw panelDraw, float deltaTime) {
        xCenterOfSprite += xBall * deltaTime;
        yCenterOfSprite += yBall * deltaTime;
        if(getLeft() < panelDraw.getLeft()) {
            setLeft(panelDraw.getLeft());
            xBall = -xBall;
        }
        if(getRight() > panelDraw.getRight()) {
            setRight(panelDraw.getRight());
            xBall = -xBall;
        }
        if(getBottom() > panelDraw.getBottom()) {
            setBottom(panelDraw.getBottom());
            yBall = -yBall;
        }
        if(getTop() < panelDraw.getTop()) {
            setTop(panelDraw.getTop());
            yBall = -yBall;
        }
    }

    /**
     * Отрисовывает графические компоненты
     *
     * @param panelDraw канва
     * @param g         графика
     */
    @Override
    public void render(PanelDraw panelDraw, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}