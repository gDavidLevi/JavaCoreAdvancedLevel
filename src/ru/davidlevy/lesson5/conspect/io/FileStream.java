package ru.davidlevy.lesson5.conspect.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStream {
    public static void main(String[] args) throws Exception {
        {
            FileOutputStream outputStream = new FileOutputStream("file.txt");
            for (int i = 0; i < 5; i++) {
                outputStream.write(65 + i);  // пишем байты
            }
            outputStream.flush();
            outputStream.close();
        }

        {
            FileInputStream inputStream = new FileInputStream("file.txt");
            int x;
            while ((x = inputStream.read()) != -1) {
                System.out.print((char) x);  // читаем байты
            }
            inputStream.close();
        }

    }
}