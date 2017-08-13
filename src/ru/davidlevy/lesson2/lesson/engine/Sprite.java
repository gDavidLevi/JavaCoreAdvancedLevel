package ru.davidlevy.lesson2.lesson.engine;

import java.awt.*;

/**
 * Базовый класс фигур - Спрайт
 */
public class Sprite implements Figure {
    /* Центр спрайта */
    protected float xCenterOfSprite;
    protected float yCenterOfSprite;

    /* Размеры спрайта */
    protected float halfWidth;
    protected float halfHeight;

    /**
     * Возвращает левую сторону спрайта
     *
     * @return float
     */
    public float getLeft() {
        return xCenterOfSprite - halfWidth;
    }

    /**
     * Устанавливает левую сторону спрайта
     *
     * @param left float
     */
    public void setLeft(float left) {
        xCenterOfSprite = left + halfWidth;
    }

    /**
     * Возвращает правую сторону спрайта
     *
     * @return float
     */
    public float getRight() {
        return xCenterOfSprite + halfWidth;
    }

    /**
     * Устанавливает правую сторону спрайта
     *
     * @param right float
     */
    public void setRight(float right) {
        xCenterOfSprite = right - halfWidth;
    }

    /**
     * Возвращает верх спрайта
     *
     * @return float
     */
    public float getTop() {
        return yCenterOfSprite - halfHeight;
    }

    /**
     * Устанавливает верхнюю сторону спрайта
     *
     * @param top float
     */
    public void setTop(float top) {
        yCenterOfSprite = top + halfHeight;
    }

    /**
     * Возвращает низ спрайта
     *
     * @return float
     */
    public float getBottom() {
        return yCenterOfSprite + halfHeight;
    }

    /**
     * Устанавливает нижнюю сторону спрайта
     *
     * @param bottom float
     */
    public void setBottom(float bottom) {
        yCenterOfSprite = bottom - halfHeight;
    }

    /**
     * Ширина спрайта
     *
     * @return float
     */
    public float getWidth() {
        return 2f * halfWidth;
    }

    /**
     * Высота спрайта
     *
     * @return float
     */
    public float getHeight() {
        return 2f * halfHeight;
    }

    /**
     * Обновить параметры фигуры.
     *
     * @param panelDraw панель для рисования
     * @param deltaTime дельта времени
     */
    @Override
    public void update(PanelDraw panelDraw, float deltaTime) {
        /* Обновить параметры фигуры */
    }

    /**
     * Отрисовать фигуру используя графические примитивы.
     *
     * @param panelDraw панель для рисования
     * @param g         графика
     */
    @Override
    public void render(PanelDraw panelDraw, Graphics g) {

    }
}