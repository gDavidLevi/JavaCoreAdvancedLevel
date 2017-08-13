package ru.davidlevy.lesson2.lesson.engine;

import ru.davidlevy.lesson2.lesson.figures.Background;
import ru.davidlevy.lesson2.lesson.figures.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Главное окно программы
 *
 * @see FrameWindowListener объявляет метод draw()
 * @see PanelDraw панель для рисования; источник событий для слушателя FrameWindowListener
 */
public class FrameWindow extends JFrame implements FrameWindowListener {
    /* Параметры окна */
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /* Начальное количество шариков */
    private static final int START_BALLS_COUNT = 1;

    /* Массив спрайтов */
    private Figure[] arrayFigures = new Figure[START_BALLS_COUNT];
    private int gameObjectsCount;

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
            public void mousePressed(MouseEvent e) {
                int btn = e.getButton();
                if (btn == MouseEvent.BUTTON1)
                    addGameObject(new Ball(e.getX(), e.getY()));  // new Rectangle(
                else if (gameObjectsCount > 1)
                    removeSprite();
            }
        });

        /* Инициализация игры */
        initGame();

        /* Сделать окно видимым */
        setVisible(true);
    }

    /**
     * Добавляет объект в массив спрайтов
     *
     * @param figure интерфейс обновления и рендаринга
     */
    private void addGameObject(Figure figure) {
        if (gameObjectsCount == arrayFigures.length) {
            Figure[] newArray = new Figure[arrayFigures.length * 2];
            System.arraycopy(arrayFigures, 0, newArray, 0, arrayFigures.length);
            arrayFigures = newArray;
        }
        arrayFigures[gameObjectsCount++] = figure;
    }

    /**
     * Удаляет спрайт из массива
     *
     * @return Figure
     */
    private Figure removeSprite() {
        if (gameObjectsCount > 0) {
            Figure lastFigure = arrayFigures[--gameObjectsCount];
            arrayFigures[gameObjectsCount] = null;
            return lastFigure;
        }
        return null;
    }

    /**
     * Инициализация
     */
    private void initGame() {
        /* Добавляем фон */
        addGameObject(new Background());

        /* Добавляем шарики*/
        for (int i = 0; i < START_BALLS_COUNT; i++)
            addGameObject(new Ball());  // new Rectangle(
    }

    /**
     * Отрисовка с частотой 60 fps
     *
     * @param panelDraw панель для рисования
     * @param g         графика
     * @param deltaTime дельта времени
     */
    @Override
    public void draw(PanelDraw panelDraw, Graphics g, float deltaTime) {
        update(panelDraw, deltaTime);
        draw(panelDraw, g);
    }

    /**
     * Метод обновляет параметры объектов
     *
     * @param panelDraw панель для рисования
     * @param deltaTime дельта времени
     */
    private void update(PanelDraw panelDraw, float deltaTime) {
        for (int i = 0; i < gameObjectsCount; i++) {
            arrayFigures[i].update(panelDraw, deltaTime);
        }
    }

    /**
     * Метод отрисовывает объекты
     *
     * @param panelDraw панель для рисования
     * @param g         графика
     */
    private void draw(PanelDraw panelDraw, Graphics g) {
        for (int i = 0; i < gameObjectsCount; i++) {
            arrayFigures[i].render(panelDraw, g);
        }
    }
}