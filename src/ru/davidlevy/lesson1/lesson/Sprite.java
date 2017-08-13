package ru.davidlevy.lesson1.lesson;

import java.awt.*;

/**
 * Абстрактный класс описывает спрайт
 */
abstract class Sprite {

    /* Центр спрайта */
    float xCenter;
    float yCenter;

    /* Размер */
    float halfWidth; // ширина
    float halfHeight; // высота

    /**
     * Возвращает левую позицию
     *
     * @return float
     */
    float getLeft() {
        return xCenter - halfWidth;
    }

    /**
     * Устанавливает левую позицию
     *
     * @param left float
     */
    void setLeft(float left) {
        xCenter = left + halfWidth;
    }

    /**
     * Возвращает правую позицию
     *
     * @return float
     */
    float getRight() {
        return xCenter + halfWidth;
    }

    /**
     * Устанавливает правую позицию
     *
     * @param right float
     */
    void setRight(float right) {
        xCenter = right - halfWidth;
    }

    /**
     * Возвращает верхнюю позицию
     *
     * @return float
     */
    float getTop() {
        return yCenter - halfHeight;
    }

    /**
     * Устанавливает верхнюю позицию
     *
     * @param top float
     */
    void setTop(float top) {
        yCenter = top + halfHeight;
    }

    /**
     * Возвращает нижнюю позицию
     *
     * @return float
     */
    float getBottom() {
        return yCenter + halfHeight;
    }

    /**
     * Устанавливает нижнюю позицию
     *
     * @param bottom float
     */
    void setBottom(float bottom) {
        yCenter = bottom - halfHeight;
    }

    /**
     * Возвращает ширину спрайта
     *
     * @return float
     */
    float getWidth() {
        return 2f * halfWidth;
    }

    /**
     * Возвращает высоту спрайта
     *
     * @return float
     */
    float getHeight() {
        return 2f * halfHeight;
    }

    /**
     * Абстрактный метод обновления канвы
     *
     * @param PanelDraw канва
     * @param deltaTime дельта времени
     */
    abstract void update(PanelDraw PanelDraw, float deltaTime);

    /**
     * Абстрактный метод отрисовки канвы
     *
     * @param PanelDraw канва
     * @param g         графика
     */
    abstract void render(PanelDraw PanelDraw, Graphics g);
}