package ru.davidlevy.lesson5.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SymbolsStream {
    public static void main(String[] args) throws Exception {
        {// FileWriter используется для записи потоков символов
            File file = new File("1.txt");
            //file.createNewFile(); // не обязательно
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("stream symbols");
            fileWriter.flush();
            fileWriter.close();
        }

        {// FileReader используется для чтения потоков символов
            File file = new File("1.txt");
            FileReader fileReader = new FileReader(file);
            int size = (int) file.length();
            char[] chars = new char[size];
            fileReader.read(chars); // читаем в массив
            for (char c : chars)
                System.out.print(c); // вывод посимвольно
            fileReader.close();
        }

        { // Читает символы из потока в буфер, потом из буфера возвращает в поток
            Reader reader = new FileReader("1.txt"); // aa-aa--aaa---aaaaaa
            PushbackReader pushbackReader = new PushbackReader(reader);
            int c;
            while ((c = pushbackReader.read()) != -1) {
                if (c == '-') {
                    int nextC;
                    if ((nextC = pushbackReader.read()) == '-') {
                        System.out.print("**");
                    } else {
                        pushbackReader.unread(nextC);
                        System.out.print((char) c);
                    }
                } else {
                    System.out.print((char) c);
                }
            }
            //aa-aa**aaa**-aaaaaa
        }

        {
            // Аналог System.out.println("печать");
            PrintStream printStream = new PrintStream(System.out);
            printStream.println("печать");
            //
            //OutputStream outputStream = System.out; // вывод в консоль
            OutputStream outputStream = new FileOutputStream("1.txt");
            //
            PrintStream printStream1 = new java.io.PrintStream(outputStream);
            printStream1.write(65);
            printStream1.print(0.25f);
            printStream1.print(12854848465L);
            printStream1.print(12);
            printStream1.print(false);
            printStream1.printf("Цена: %d рублей", 10);
            printStream1.append('S');
            printStream1.append('S');
            printStream1.append('D');
            printStream1.flush();
            printStream1.close();
            outputStream.flush();
            outputStream.close();
            // A0.251285484846512falseЦена: 10 рублейSSD
        }

        {
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            charArrayWriter.write(65); // A
            //
            char[] a = charArrayWriter.toCharArray();
            System.out.println(a[0]); // A
            //
            char[] chars = {'a', 'b', 'c',};
            CharArrayReader charArrayReader = new CharArrayReader(chars);
            int c;
            while ((c = charArrayReader.read()) != -1) {
                System.out.println((char) c);
            }
        }

        { // OutputStreamWriter(Reader) - поток-обертка для чтения/записи файлов в нужной кодировке
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("1.txt"), StandardCharsets.UTF_8);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("1.txt"), StandardCharsets.US_ASCII);
        }

        { // BufferedReader читает текстовые данные из потока по разным кодировкам
            BufferedReader bufferedReader = new BufferedReader( new FileReader("1.txt"));
        }

        { // BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("1.txt"));
            bufferedWriter.write("string");
            bufferedWriter.flush();
            bufferedWriter.close();
        }

        { // PrintWriter
            PrintWriter printWriter = new PrintWriter("1.txt");
            printWriter.write(65);
            printWriter.print(0.25f);
            printWriter.print(12854848465L);
            printWriter.print(12);
            printWriter.print(false);
            printWriter.printf("Цена: %d рублей", 10);
            printWriter.append('S');
            printWriter.append('S');
            printWriter.append('D');
            printWriter.flush();
            printWriter.close();
            // A0.251285484846512falseЦена: 10 рублейSSD
        }
    }
}