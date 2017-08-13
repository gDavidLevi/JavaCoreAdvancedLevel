package ru.davidlevy.lesson2.lesson.engine;

import javax.swing.*;
import java.awt.*;

/**
 * Панель (холст) для рисования.
 *
 * @see FrameWindow реализует метод draw()
 */
public class PanelDraw extends JPanel {
    /* Хранит ссылку на объект слушателя FrameWindowListener */
    private final FrameWindowListener listener;

    /* Хранят времени отрисовки первого и последнего спрайта в наносекундах */
    private long lastFrameTime;

    /* Скорость отрисовки */
    private static final float SPEED = 1e-9f;

    /**
     * Конструктор принимает ссылку на объект FrameWindow и
     *
     * @param listener
     */
    public PanelDraw(FrameWindowListener listener) {
        this.listener = listener;
        lastFrameTime = System.nanoTime();
    }

    /**
     * Отрисовка компонентов на текущей панели
     *
     * @param g графика
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Вычисление расстояния (дельты времени) через которое отрисовывается следующий спрайт */
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * SPEED;
        lastFrameTime = currentTime;

        /* Передать управление в метод FrameWindow.draw */
        listener.draw(this, g, deltaTime);

        /* Отрисовка с частотой ≅ 60 fps */
        try {
            Thread.sleep((int) ((1f / 60f) * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Перерисовать этот компонент */
        repaint();
    }

    /**
     * Возвращает лево
     *
     * @return int
     */
    public int getLeft() {
        return 0;
    }

    /**
     * Возвращает право
     *
     * @return int
     */
    public int getRight() {
        return getWidth() - 1;
    }

    /**
     * Возвращает верх
     *
     * @return int
     */
    public int getTop() {
        return 0;
    }

    /**
     * Возвращает низ
     *
     * @return int
     */
    public int getBottom() {
        return getHeight() - 1;
    }
}