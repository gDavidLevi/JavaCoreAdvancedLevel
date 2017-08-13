package ru.davidlevy.lesson2.lesson.figures;

import ru.davidlevy.lesson2.lesson.engine.PanelDraw;
import ru.davidlevy.lesson2.lesson.engine.Sprite;

import java.awt.*;

/**
 * Класс описывает спрайт Прямоугольник
 */
public class Rectangle extends Sprite {
    /* Случайные значение */
    private float vx = 150f + (float) (Math.random() * 200f);
    private float vy = 150f + (float) (Math.random() * 200f);
    private Color color =
            new Color((int) (Math.random() * 256f), (int) (Math.random() * 256f), (int) (Math.random() * 256f));

    Rectangle() {
        halfHeight = 20f + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    /* Конструктор для установки спрайта по клику мыши */
    Rectangle(int x, int y){
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
        xCenterOfSprite += vx * deltaTime;
        yCenterOfSprite += vy * deltaTime;
        if(getLeft() < panelDraw.getLeft()) {
            setLeft(panelDraw.getLeft());
            vx = -vx;
        }
        if(getRight() > panelDraw.getRight()) {
            setRight(panelDraw.getRight());
            vx = -vx;
        }
        if(getBottom() > panelDraw.getBottom()) {
            setBottom(panelDraw.getBottom());
            vy = -vy;
        }
        if(getTop() < panelDraw.getTop()) {
            setTop(panelDraw.getTop());
            vy = -vy;
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
        g.fillRect((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}