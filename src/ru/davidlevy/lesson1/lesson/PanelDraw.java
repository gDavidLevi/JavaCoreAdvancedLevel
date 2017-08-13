package ru.davidlevy.lesson1.lesson;

import javax.swing.*;
import java.awt.*;

/**
 * Панель для рисования
 */
public class PanelDraw extends JPanel {
    /* Хранит ссылку на объект FrameWindow */
    private final FrameWindow frameWindow;

    /* Хранят времени отрисовки первого и последнего спрайта в наносекундах */
    private long lastDrawTime;

    /* Скорость отрисовки */
    private static final float SPEED = 1e-9f;

    /**
     * Конструктор принимает ссылку на объект FrameWindow и
     *
     * @param frameWindow
     */
    PanelDraw(FrameWindow frameWindow) {
        this.frameWindow = frameWindow;
        this.lastDrawTime = System.nanoTime();
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
        long firstDrawTime = System.nanoTime();
        float deltaTime = (firstDrawTime - this.lastDrawTime) * SPEED;
        this.lastDrawTime = firstDrawTime;

        /* Передать управление в метод FrameWindow.draw */
        frameWindow.draw(this, g, deltaTime);

        /* Отрисовка с частотой ≅ 60 fps */
        try {
            Thread.sleep((int) ((1f / 60f) * 2000));
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
    int getLeft() {
        return 0;
    }

    /**
     * Возвращает право
     *
     * @return int
     */
    int getRight() {
        return getWidth() - 1;
    }

    /**
     * Возвращает верх
     *
     * @return int
     */
    int getTop() {
        return 0;
    }

    /**
     * Возвращает низ
     *
     * @return int
     */
    int getBottom() {
        return getHeight() - 1;
    }
}