package ru.yandex.coderun.solutions.stepik;

import java.math.BigInteger;
import java.util.Arrays;

public class StepikTrainee {

    public static void main(String[] args) {
        int i = flipBit(0, 1);
        System.out.println("flipBit = " + i);

        double a = 0x0bp3;
        // 0b[16] => 11[10]; p3 => 2^3; => 88.0
        System.out.println("a = " + a);

        String string = "Madam, I'm Adam!";
        boolean isPolindrom = isPolindrom(string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(), 0);
        System.out.println("isPolindrom = " + isPolindrom);

        BigInteger factorial = factorial(5);
        System.out.println("factorial = " + factorial);

        int[] a1 = {0, 2, 2};
        int[] a2 = {1, 3};
        String array = Arrays.toString(mergeArrays(a1, a2));
        System.out.println("array = " + array);
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int l1 = a1.length;
        int l2 = a2.length;
        int[] a = new int[l1 + l2];
        merge(a1, a2, a);
        return a;
    }

    private static void merge(int[] a1, int[] a2, int[] a) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < a.length) {
            if (i < a1.length) {
                if (j < a2.length) {
                    if (a1[i] < a2[j]) {
                        a[k] = a1[i];
                        i++;
                    } else {
                        a[k] = a2[j];
                        j++;
                    }
                } else {
                    a[k] = a1[i];
                    i++;
                }
            } else {
                if (j < a2.length) {
                    a[k] = a2[j];
                    j++;
                }
            }
            k++;
        }
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(value);
        if (value == 1) return BigInteger.ONE;
        // 3*2*1 раскрутка стека
        // 1*2*3 скрутка стека - результат
        return result.multiply(factorial(--value));
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {

        return value ^ (1 << (bitIndex - 1));
    }

    private static boolean isPolindrom(String string, int i) {
        System.out.println("string = " + string);
        int length = string.length();
        if (string.charAt(i) != string.charAt(length - 1 - i)) {
            return false;
        }
        if (length / 2 == i) {
            return true;
        }
        return isPolindrom(string, ++i);
    }

    /**
     * Вам дан список ролей и сценарий пьесы в виде массива строчек.<br/>
     * <br/>
     * Каждая строчка сценария пьесы дана в следующем виде:<br/>
     * Роль: текст<br/>
     * <br/>
     * Текст может содержать любые символы.<br/>
     * <br/>
     * Напишите метод, который будет группировать строчки по ролям,
     * пронумеровывать их и возвращать результат в виде готового текста (см. пример).
     * Каждая группа распечатывается в следующем виде:<br/>
     * <br/>
     * Роль:<br/>
     * i) текст<br/>
     * j) текст2<br/>
     * ...<br/>
     * ==перевод строки==<br/>
     * <br/>
     * i и j -- номера строк в сценарии.
     * Индексация строчек начинается с единицы,
     * выводить группы следует в соответствии с порядком ролей.
     * Переводы строк между группами обязательны,
     * переводы строк в конце текста не учитываются.
     * <p>
     *
     * @param roles     Роли
     * @param textLines Текст роли
     * @return Группировка текста по ролям.
     */
    public static String printTextPerRole(String[] roles, String[] textLines) {
        final String NEW_LINE = "\n";
        StringBuilder printTextPerRole = new StringBuilder();
        for (String role : roles) {
            boolean isStartingText = true;
            for (int textLine = 1; textLine <= textLines.length; textLine++) {
                if (isStartingText) {
                    printTextPerRole.append(role).append(":").append(NEW_LINE);
                }
                String textRole = textLines[textLine - 1];
                if (textRole.startsWith(role + ":")) {
                    printTextPerRole.append(textLine).append(") ")
                            .append(textRole.replaceFirst(String.format("%s: ", role),""))
                            .append(NEW_LINE);
                }
                isStartingText = false;
            }
            printTextPerRole.append(NEW_LINE);
        }

        return printTextPerRole.toString();
    }
}