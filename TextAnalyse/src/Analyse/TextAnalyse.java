package Analyse;

import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;
/**
 * Класс для подсчета пробелов,символов,символов без пробелов и количесва слов в текстовом файле
 */
public class TextAnalyse {
    //private static final int CHARS_BUFFER_SIZE = 256;
    private static Scanner scanner = new Scanner(System.in);
    final private static String STATISTICS_FOR_THE_TEXT =
                    "Количество пробелов: %d \n" +
                    "Количество символов: %d \n" +
                    "Количество символов без пробела: %d \n" +
                    "Количество слов: %d,";
    final private static String FILE_PATH =
                    "Введите путь к файлу:\n";
    final private static String ACCESS_ERROR =
            "Вы не верно указали путь к файлу!";
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile()))) {

            String fileLine;
            int space = 0;
            int symbols = 0;
            int word = 0;

            while ((fileLine = bufferedReader.readLine()) != null) {
                space += countingOfSpace(fileLine);
                symbols += countingOfSymbols(fileLine);
                word += countingOfWord(fileLine);
            }
            System.out.printf(STATISTICS_FOR_THE_TEXT, space, symbols, symbols - space, word);
        } catch (IOException e) {
            System.out.print(ACCESS_ERROR);
        }
    }
    /**
     * Метод позволяет ввести пользователю путь к файлу
     */
    private static String getFile() {
        System.out.println(FILE_PATH);
        return scanner.nextLine();
    }
    /**
     * Метод находит количество пробелов в предложенях.
     * Метод удаляет всё, кроме пробелов и считает их количество.
     */
    private static int countingOfSpace(String fileLine) {
        return fileLine.replaceAll("[^ ]", "").length();
    }
    /**
     * Метод, который подсчитывает количество символов в тексте.
     */
    private static int countingOfSymbols(String fileLine) {
        return fileLine.length();
    }
    /**
     * Метод, который подсчитывает количество слов в тексте
     * с помощью split() рабивает предложения на отдельные слова
     */
    private static int countingOfWord(String fileLine) {
        fileLine = fileLine.replaceAll(" {2,}", " ");
        return fileLine.split(" ").length;
    }
}