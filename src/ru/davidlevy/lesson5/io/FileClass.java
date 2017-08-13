package ru.davidlevy.lesson5.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileClass {
    public static void main(String[] args) throws Exception {
        {
            File file = new File("1.txt");
            file.length(); // размер в байтах
            file.getName(); // получить имя
            file.isFile(); // это файл?
            file.isDirectory(); // это папка?
            file.deleteOnExit(); // удалить файл после выхода из приложения
            file.getAbsolutePath(); // полный путь файла от корня
            file.getCanonicalPath(); // вычисленный путь из относительного "c://windows//..//distr"
            file.isHidden(); // скрытый?
        }
        {
            File dir = new File("MyNewDir");
            dir.mkdir();
            //dir.mkdirs(); // создаст вложенную структуру если File dir = new File("MyNewDir/1/2/3");
            dir.list(); // листинг каталога в виде String[]
            dir.listFiles(); // листинг только файлов
            dir.delete();
        }
        {
            File dirD = new File("d:/");
            String[] list = dirD.list(new FilenameFilter() { // фильтр имен файлов/папок
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches("[a-zA-Z]+");
                }
            });
            System.out.println(Arrays.toString(list));
        }
    }
}