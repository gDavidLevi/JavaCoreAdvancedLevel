package ru.davidlevy.lesson5.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class BytesStream {
    public static void main(String[] args) throws Exception {
        { //ПЛОХО // Так делать нельзя потому, что создается новый экземплар строки String с каждой иттерацией
            Timer.start();
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            String s = "";
            int x;
            while ((x = fileInputStream.read()) != -1) {
                s += (char) x; // z, zz, zzz, zzzz...
            }
            fileInputStream.close();
            Timer.stopDeltaTime(); // Файл размером 91140 байт читается за 5654 ms.
        }

        { //ХОРОШО // Читаем файл кусочками
            Timer.start();
            // BufferedInputStream читает по DEFAULT_BUFFER_SIZE = 8192;
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("file.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            int xx;
            while ((xx = inputStream.read()) != -1) {
                stringBuilder.append((char) xx); // Правильное решение!
            }
            inputStream.close();
            Timer.stopDeltaTime(); // Файл размером 91140 байт читается за 10 ms.
        }

        { //ХОРОШО+ // Используем байтовый буфер размером .available()
            Timer.start();
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            // Создаем буфер из массива байт
            byte[] bytes = new byte[fileInputStream.available()]; // .available() - размер файла входного
            fileInputStream.read(bytes); // Очень быстрое чтение!
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append((char) b);
            }
            fileInputStream.close();
            Timer.stopDeltaTime(); // Файл размером 91140 байт читается за 5 ms.
        }

        {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("file_out.txt"));
            bufferedOutputStream.write(65);
            bufferedOutputStream.flush(); // слить в файл до переполнения буфера
            bufferedOutputStream.close();
        }

        { // Пишем/читаем из/в массив(а)
            byte[] bytes = {1, 2, 3, 4, 5, 6, 7};
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            int x;
            while ((x = byteArrayInputStream.read()) != -1) {
                System.out.print(x + " ");
            }
            System.out.println();
            byteArrayInputStream.close();
            //
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < 100; i++) {
                byteArrayOutputStream.write(i);
            }
            byteArrayOutputStream.close();
            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        }

        {
            // SequenceInputStream "сшивает" несколько потоков в один, и мы работаем в итоге с одним потоком
            ArrayList<FileInputStream> list = new ArrayList<>();
            list.add(new FileInputStream("1.txt"));
            list.add(new FileInputStream("2.txt"));
            Enumeration<FileInputStream> fis = Collections.enumeration(list);
            SequenceInputStream sequenceInputStream = new SequenceInputStream(fis);
            int x;
            while ((x = sequenceInputStream.read()) != -1) {
                System.out.print((char) x);
            }
        }

        {// Данные потоки создаются парами!
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            pipedInputStream.connect(pipedOutputStream);
            pipedOutputStream.write(10);
            pipedOutputStream.write(20);
            System.out.println(pipedInputStream.read());
            System.out.println(pipedInputStream.read());
        }

        { // OtherPrimitiveTypes :: bool, int, float, long...
            long value = 99999990L;
            // Для записи примитивных типов, кроме byte, используют DataOutputStream
            // DataOutputStream не буферезирован по умолчанию поэтому выходной поток оборачивают в буферизированный поток BufferedOutputStream!
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("1.txt")));
            dataOutputStream.writeLong(value);
            //dataOutputStream.writeUTF("@");
            //dataOutputStream.writeBoolean(false);
            //dataOutputStream.writeFloat(0.2563f);
            dataOutputStream.flush();
            dataOutputStream.close();
            //
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("1.txt"));
            System.out.println("long: " + dataInputStream.readLong()); // 99999990
        }

        { // RandomAccessFile - читает байты; получение доступа к определенному месту в файле
            // "r" Открывает файл только по чтению. Запуск любых методов записи данных приведет к выбросу исключения IOException.
            // "rw" Открывает файл по чтению и записи. Если файл еще не создан, то осуществляется попытка создать его.
            // "rws" Открывает файл по чтению и записи подобно "rw", и также требует системе при каждом изменении содержимого файла или метаданных синхронно записывать эти изменения на основной носитель.
            // "rwd" Открывает файл по чтению и записи подобно "rws", но принуждает систему синхронно записывать изменения на основной носитель только при каждом изменении содержимого файла. Если изменяются метаданные, синхронная запись не осуществляется.
            RandomAccessFile randomAccessFile = new RandomAccessFile("file.txt", "rw"); //ABCDEFG
            int position = 0; // позиця м=символа
            randomAccessFile.seek(position);
            System.out.println(randomAccessFile.read()); // A
            //
            randomAccessFile.write('Z');
            System.out.println(randomAccessFile.read()); // Z
            randomAccessFile.close();
        }

    }
}