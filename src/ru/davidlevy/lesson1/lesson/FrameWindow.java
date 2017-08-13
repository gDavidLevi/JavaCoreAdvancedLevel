package ru.davidlevy.lesson1.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * Главное окно программы
 */
public class FrameWindow extends JFrame {
    /* Параметры окна */
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /* Массивы спрайтов */
    private static Sprite[] sprites = new Sprite[2];
    private static Sprite[] spritesAdded;

    /* Фон */
    private static Background background = new Background();

    /* Точка входа */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameWindow();
            }
        });
    }

    /**
     * Конструктор главного окна
     */
    private FrameWindow() {
        /* Параметры главного окна */
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);

        /* На главное окно положим игровую панель */
        PanelDraw panelDraw = new PanelDraw(this);
        add(panelDraw);

        /* Слушатель событий мыши */
        panelDraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addBall(spritesAdded);
            }
        });

        /* Создание шариков */
        createBalls();

        /* Сделать окно видимым */
        setVisible(true);
    }

    /**
     * Создание шариков.
     */
    private void createBalls() {
        final int quantity = sprites.length;
        for (int i = 0; i < quantity; i++) {
            sprites[i] = new Circle();
        }
    }

    /**
     * Расширяет массив и добавляет в него новый шарик.
     *
     * @param in текущий массив
     */
    private void addBall(Sprite[] in) {
        if (spritesAdded == null) {
            spritesAdded = new Sprite[1];
            spritesAdded[0] = new Circle();
        } else {
            spritesAdded = Arrays.copyOf(in, in.length + 1);
            spritesAdded[spritesAdded.length - 1] = new Circle();
        }
    }

    /**
     * Отрисовка с частотой 60 fps
     *
     * @param panelDraw панель для рисования
     * @param g         графика
     * @param deltaTime дельта времени
     */
    void draw(PanelDraw panelDraw, Graphics g, float deltaTime) {
        /* Обновить параметры объектов */
        update(panelDraw, deltaTime);

        /* Отрисовка графики на панели */
        draw(panelDraw, g);
    }

    /**
     * Метод обновляет параметры объектов
     *
     * @param panelDraw панель для рисования
     * @param deltaTime дельта времени
     */
    private void update(PanelDraw panelDraw, float deltaTime) {
        /* Обновить параметры фона */
        background.update(panelDraw, deltaTime);

        /* Обновить параметры спрайтов */
        final int quantity = sprites.length;
        for (int i = 0; i < quantity; i++) {
            sprites[i].update(panelDraw, deltaTime);
        }

        /* Обновить параметры добавленных спрайтов */
        if (spritesAdded != null) {
            final int quantityAdded = spritesAdded.length;
            for (int i = 0; i < quantityAdded; i++) {
                spritesAdded[i].update(panelDraw, deltaTime);
            }
        }
    }

    /**
     * Метод отрисовывает объекты
     *
     * @param panelDraw панель для рисования
     * @param g         графика
     */
    private void draw(PanelDraw panelDraw, Graphics g) {
        /* Отрисовка фона */
        background.render(panelDraw, g);

        /* Отрисовка спрайтов */
        final int quantity = sprites.length;
        for (int i = 0; i < quantity; i++) {
            sprites[i].render(panelDraw, g);
        }

        /* Отрисовка добавленных спрайтов */
        if (spritesAdded != null) {
            final int quantityAdded = spritesAdded.length;
            for (int i = 0; i < quantityAdded; i++) {
                spritesAdded[i].render(panelDraw, g);
            }
        }
    }
}